package com.fastcampus.ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Properties;

public class AppliCationContextTest {
    @Component
    @Scope("prototype")
    class Door {}
    @Component class Engine {}
    @Component class TurboEngine extends Engine {}
    @Component class SuperEngine extends Engine {}

    @Component
    class Car {
        @Value("red") String color;
        @Value("100") int oil;
        @Autowired
        Engine engine;
        @Autowired    Door[] doors;

        @Override
        public String toString() {
            return "Car{" +
                    "color='" + color + '\'' +
                    ", oil=" + oil +
                    ", engine=" + engine +
                    ", doors=" + Arrays.toString(doors) +
                    '}';
        }
    }

    @Component
    @PropertySource("setting.properties")
    class SysInfo{
        @Value("#{systemProperties['user.timeZone']}")
        String timeZone;
        @Value("#{systemEnvironment['APPDATA']}")
        String currDir;
        @Value("${autosaveDir}")
        String autosaveDir;
        @Value("${autosaveInterval}")
        int autosaveInterval;
        @Value("${autosave}")
        boolean autosave;

        @Override
        public String toString() {
            return "SysInfo{" +
                    "timeZone='" + timeZone + '\'' +
                    ", currDir='" + currDir + '\'' +
                    ", autosaveDir='" + autosaveDir + '\'' +
                    ", autosaveInterval=" + autosaveInterval +
                    ", autosave=" + autosave +
                    '}';
        }
    }

    public class ApplicationContextTest {
        public void main(String[] args) {
            ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
//      Car car = ac.getBean("car", Car.class); // 타입을 지정하면 형변환 안해도됨. 아래의 문장과 동일
            Car car  = (Car) ac.getBean("car"); // 이름으로 빈 검색
            Car car2 = (Car) ac.getBean(Car.class);   // 타입으로 빈 검색
            System.out.println("car = " + car);

            System.out.println("ac.getBean(SysInfo.class) = " + ac.getBean(SysInfo.class));
            Properties properties = System.getProperties();
            System.out.println("properties = " + properties);
            
        }
    }
}