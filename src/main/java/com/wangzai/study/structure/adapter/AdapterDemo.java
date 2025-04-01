package com.wangzai.study.structure.adapter;

/**
 * @author 杨灿杭
 * @Description
 * @create 2025-03-26 9:07
 */
public class AdapterDemo {
    public static void main(String[] args) {
        // 使用普通类的普通方法
        ConcreteTarget concreteTarget = new ConcreteTarget();
        concreteTarget.request();

        // 使用类适配器的普通方法
        Adapter adapter = new Adapter();
        adapter.request();
        // 使用对象适配器的普通方法
        Adapter02 adapter02 = new Adapter02(new Adaptee());
        adapter02.request();
    }
}

/**
 * 类的适配器
 */
// 已存在的、具有特殊功能、但不符合我们既有的标准接口的类
class Adaptee {
    public void specificRequest() {
        System.out.println("被适配的类，具有某种特殊功能！");
    }
}

// 目标接口
interface Target {
    public void request();
}

// 目标接口实现类，也就是普通类
class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("普通类，普通接口~");
    }
}

// 适配器类 ----------> 采用继承的方法， 从特殊类中获取特殊方法
class Adapter extends Adaptee implements Target {
    // 现在相当于新建了一个类替换掉原有的普通类，由于这个类与原有的类继承了同个接口，所以，可以平替
    @Override
    public void request() {
        // 在实现对应的目标接口方法时调用被适配的类，也就是父类的特殊功能方法
        super.specificRequest();
    }
}

/**
 * 对象的适配器模式
 */
class Adapter02 implements Target {

    public Adapter02(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    private Adaptee adaptee;  // 将具有特殊功能的类，作为自己的属性变量。即与具有特殊功能的类实现关联关系

    @Override
    public void request() {
        // 在实现目标接口方法时，调用具有特殊功能类的特殊方法
        adaptee.specificRequest();
    }
}