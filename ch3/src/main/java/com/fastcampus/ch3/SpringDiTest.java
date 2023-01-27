//package com.fastcampus.ch3;
//
//
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Component
//class Car{
//    String color;
//    int oil;
//    Engine engine;
//    Door[] doors;
//
//    public Car() {}// 기본 생성자를 꼭 만들어 주기
//    public Car(String color, int oil, Engine engine, Door[] doors) {
//        this.color = color;
//        this.oil = oil;
//        this.engine = engine;
//        this.doors = doors;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public void setOil(int oil) {
//        this.oil = oil;
//    }
//
//    public void setEngine(Engine engine) {
//        this.engine = engine;
//    }
//
//    public void setDoors(Door[] doors) {
//        this.doors = doors;
//    }
//
//    @Override
//    public String toString() {
//        return "Car{" +
//                "color='" + color + '\'' +
//                ", oil=" + oil +
//                ", engine=" + engine +
//                ", doors=" + Arrays.toString(doors) +
//                '}';
//    }
//}
//
//@Component
//class Engine{}
//@Component
//class Door{}
//
//public class SpringDiTest {
//    public static void main(String[] args) {
//        try {
//            ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
//            Car car = ac.getBean(Car.class);
//            Car car2 = ac.getBean(Car.class);
//            Engine engine = ac.getBean(Engine.class);
//            Door door = ac.getBean(Door.class);
//
////            car.setColor("red");
////            car.setOil(100);
////            car.setDoors(new Door[]{(Door)ac.getBean("door"),(Door)ac.getBean("door")});
//            System.out.println("car = " + car);
//        } catch (BeansException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
