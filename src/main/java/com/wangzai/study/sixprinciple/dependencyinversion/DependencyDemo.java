package com.wangzai.study.sixprinciple.dependencyinversion;

/**
 * @author 杨灿杭
 * @Description
 * @create 2025-03-18 16:11
 */
public class DependencyDemo {
    public static void main(String[] args) {

    }
}

interface ICar {
    public void run();
}
interface IDriver {
    public void drive();
    public void drive(ICar car);
}

class Driver implements IDriver {
    private ICar car;

    // 构造方法传递依赖
    public Driver(ICar car) {
        this.car = car;
    }

    // setter方法传递依赖
    public void setCar(ICar car) {
        this.car = car;
    }

    @Override
    public void drive() {
        this.car.run();
    }

    // 接口传递依赖
    @Override
    public void drive(ICar car) {
        car.run();
    }
}
