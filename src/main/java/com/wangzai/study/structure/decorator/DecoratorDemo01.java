package com.wangzai.study.structure.decorator;

/**
 * @author 杨灿杭
 * @Description
 * @create 2025-03-26 9:40
 */
public class DecoratorDemo01 {
    public static void main(String[] args) {
        Person person = new Person();
        Decorator decorator = new Decorator(new Decorator_two(new Decorator_one(new Decorator_zero(person))));
        decorator.wearClothes();
    }
}

// 定义被修饰者
interface Human {
    public void wearClothes();
}

// 定义修饰器   --------->  其实更像是一个中间的启动工具，接收一个对象，然后启动它的装饰方法。有点像链式反应
class Decorator implements Human {
    private Human human;

    public Decorator(Human human) {
        this.human = human;
    }

    @Override
    public void wearClothes() {
        human.wearClothes();
    }
}

class Decorator_zero extends Decorator {

    public Decorator_zero(Human human) {
        super(human);
    }

    public void goHome() {
        System.out.println("去房间找找看~");
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        goHome();
    }
}

class Decorator_one extends Decorator{
    public Decorator_one(Human human) {
        super(human);
    }

    public void goClothespress(){
        System.out.println("去衣柜找找看~");
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        goClothespress();
    }
}

class Decorator_two extends Decorator{

    public Decorator_two(Human human) {
        super(human);
    }

    public void findClothes(){
        System.out.println("找到了一件李宁的T shirt");
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        findClothes();
    }
}

class Person implements Human{

    @Override
    public void wearClothes() {
        System.out.println("今天穿什么？");
    }
}

