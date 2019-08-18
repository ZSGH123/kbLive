package com.kblive.usersystem.web.car;

/**
 * title: CarFactory
 * projectName kbLive
 * description: 汽车工产类
 * author 2671242147@qq.com
 * date 2019-08-17 17:54
 ***/
public class CarFactory {

    public static Car createCar() {
        System.out.println("car7");
        Car car = new Car();
        return car;
    }

    public Car createHongQiCar() {
        Car car = new Car();
        car.setBrand("红旗CA72");
        return car;
    }
}
