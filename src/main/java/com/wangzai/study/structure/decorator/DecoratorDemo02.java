package com.wangzai.study.structure.decorator;

/**
 * @author 杨灿杭
 * @Description
 * @create 2025-03-26 10:02
 */
public class DecoratorDemo02 {
    public static void main(String[] args) {
        ChickenBurger chickenBurger = new ChickenBurger();
        Lettuce lettuce = new Lettuce(chickenBurger);
        System.out.println(lettuce.getName() + "-----> 价格是： " + lettuce.getPrice());
        Chilli chilli = new Chilli(chickenBurger);
        System.out.println(chilli.getName() +  "----->  价格是： " + chilli.getPrice());
        Lettuce chilliAndLettuce = new Lettuce(chilli);
        System.out.println(chilliAndLettuce.getName() +  "----->  价格是： " + chilliAndLettuce.getPrice());
    }
}


// 汉堡基类，相当于被装饰的类
abstract class Hamburger {
    protected String name;

    public String getName() {
        return name;
    }

    public abstract double getPrice();
}

// 配料的基类，相当于装饰器的基类
abstract class Condiment extends Hamburger {
    protected Hamburger hamburger;

    public Condiment(Hamburger hamburger) {
        this.hamburger = hamburger;
    }

    public abstract String getName();
}

// 生菜类，相当于装饰器1号
class Lettuce extends Condiment {
    public Lettuce(Hamburger hamburger) {
        super(hamburger);
    }

    @Override
    public double getPrice() {
        return super.hamburger.getPrice() + 1.5;
    }

    @Override
    public String getName() {
        return super.hamburger.getName() + " 加生菜";
    }
}

// 辣椒类， 相当于装饰器2号
class Chilli extends Condiment {
    public Chilli(Hamburger hamburger) {
        super(hamburger);
    }

    @Override
    public double getPrice() {
        return super.hamburger.getPrice();   // 辣椒免费
    }

    @Override
    public String getName() {
        return super.hamburger.getName() + " 加辣椒";
    }
}

class ChickenBurger extends Hamburger {

    public ChickenBurger() {
        name = "鸡腿堡";
    }

    @Override
    public double getPrice() {
        return 10;
    }
}