package com.wangzai.study.structure.bridging;

/**
 * <p>
 * 桥接模式，这里还是解释一下原理吧
 * 给我的感觉是跟装饰器是差不多的，不同的地方是，装饰器强调的是对原有方法功能的增强，而桥接模式更多强调的是通过更换不同的对象，来实现不同的基础功能。
 * 举个栗子吧，我们这里举一下汽车的栗子：
 * 对于一辆赛车来说，搭配的是硬胎或者是软胎就能够在干燥的马路上行驶，
 * 而如果要在下雨的路面行驶，就需要搭配雨胎了，
 * 这种根据行驶的路面不同，需要搭配不同的轮胎的变化的情况
 * </p>
 *
 * @author 杨灿杭
 * @Description
 * @create 2025-03-26 10:59
 */
public class BridGingDemo {
    public static void main(String[] args) {
        NormalTire normalTire = new NormalTire("普通轮胎");
        RainTire rainTire = new RainTire("雨胎");
        // 配备普通轮胎的赛车
        RacingCar racingCar = new RacingCar(normalTire);
        racingCar.reinforceRun();
        // 配备雨胎的赛车
        RacingCar reinRacingCar = new RacingCar(rainTire);
        reinRacingCar.reinforceRun();
    }
}

// 轮胎抽象类 ----------->   这里用接口或者用抽象类都可以，用抽象类主要是因为要定义基础属性
abstract class BaseTire {
    protected String name;

    public BaseTire(String name) {
        this.name = name;
    }

    public abstract void operatorImpl();
}

// 细化轮胎品类，也是对基础轮胎的实现
// 普通轮胎
class NormalTire extends BaseTire {
    public NormalTire(String name) {
        super(name);
    }
    @Override
    public void operatorImpl() {
        System.out.println(this.name + "，可以在普通道路行驶");
    }
}
// 雨胎
class RainTire extends BaseTire {
    public RainTire(String name) {
        super(name);
    }

    @Override
    public void operatorImpl() {
        System.out.println(this.name + "，可以在雨天行驶");
    }
}

abstract class BaseCar {
    protected BaseTire baseTire;

    public BaseCar(BaseTire baseTire) {
        this.baseTire = baseTire;
    }
    public void run(){
        this.baseTire.operatorImpl();
    }
}

class RacingCar extends BaseCar{
    public RacingCar(BaseTire baseTire) {
        super(baseTire);
    }

    public void reinforceRun(){
        this.run();
        System.out.println("可以在做一些增强操作。");
    }
}
