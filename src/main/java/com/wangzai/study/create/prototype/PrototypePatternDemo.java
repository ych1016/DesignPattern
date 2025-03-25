package com.wangzai.study.create.prototype;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     原型模式
 * </p>
 * @author 杨灿杭
 * @Description
 * @create 2025-03-18 17:13
 */
public class PrototypePatternDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        ShallowClone shallowClone = new ShallowClone();
        ShallowClone shallowCloneCp = (ShallowClone) shallowClone.clone();
        shallowCloneCp.show();
        System.out.println(shallowClone.list == shallowCloneCp.list);

        DeepClone deepClone = new DeepClone();
        DeepClone deepCloneCp = (DeepClone) deepClone.clone();
        deepCloneCp.show();
        System.out.println(deepCloneCp.list == deepClone.list);
        /**
         * 输出
         * 浅拷贝
         * true
         * 深拷贝
         * false
         */
    }
}

abstract class Prototype implements Cloneable {
    protected ArrayList<String> list = new ArrayList<>();
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }
    public abstract void show();
}

class ShallowClone extends Prototype {
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Override
    public void show() {
        System.out.println("浅拷贝");
    }
}

class DeepClone extends Prototype {
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        Prototype prototype =  super.clone();
        prototype.list = (ArrayList<String>) this.list.clone();
        return prototype;
    }
    @Override
    public void show() {
        System.out.println("深拷贝");
    }
}