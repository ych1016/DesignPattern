package com.wangzai.study.sixprinciple.singleresponsibility;

import lombok.Data;

/**
 * <p>
 *     类的单一原则 demo
 * </p>
 * @author 杨灿杭
 * @Description
 * @create 2025-03-12 13:45
 */

public class KindDemo {
    public static void main(String[] args) {
//        Animal animal = new Animal();
//        animal.eating("羊");
//        animal.eating("牛");
        MeatAnimal meatAnimal = new MeatAnimal();
        meatAnimal.eating("狼");
        GrassAnimal grassAnimal = new GrassAnimal();
        grassAnimal.eating("草");
    }
}

// 错误示范
class Animal {
    /**
     * 根据名称判断吃什么，可以看到类中的方法存在 if-else，也就是这个类需要负责两个不一样的功能，违背了单一原则
     * 改进：
     * 1. 可以抽离类，将这个类抽成两个类，各自负责自己的那部分
     * 2. 可以抽离方法，把if的内容写成一个方法，把else写成一个方法
     */
    public void eating(String name){
        if("羊".equals(name)){
            System.out.println(name + "吃草");
        }else {
            System.out.println(name + "吃肉");
        }
    }
}

// 修正   用装饰器模式，将动物类抽象成父类
abstract class AnimalFather {
    public abstract void eating(String name);
}

class MeatAnimal extends AnimalFather{
    @Override
    public void eating(String name) {
        System.out.println(name + "吃肉");
    }
}

class GrassAnimal extends AnimalFather {
    @Override
    public void eating(String name) {
        System.out.println(name + "吃草");
    }
}