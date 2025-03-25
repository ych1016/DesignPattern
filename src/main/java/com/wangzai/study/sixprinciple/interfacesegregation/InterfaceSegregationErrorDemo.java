package com.wangzai.study.sixprinciple.interfacesegregation;

/**
 * @author 杨灿杭
 * @Description
 * @create 2025-03-24 9:25
 */
public class InterfaceSegregationErrorDemo {
    public static void main(String[] args) {
        C c = new C();
        c.dependence01(new A());
        c.dependence02(new A());
        c.dependence03(new A());

        D d = new D();
        d.dependence04(new B());
        d.dependence05(new B());
        /**
         * 输出
         * 这是A需要的接口01
         * 这是A需要的接口02
         * 这是A需要的接口03
         * 这是B需要的接口04
         * 这是B需要的接口05
         */
    }
}

interface I {
    public void run01();
    public void run02();
    public void run03();
    public void run04();
    public void run05();
}

class C {
    public void dependence01(I A) {
        A.run01();
    }
    public void dependence02(I A) {
        A.run02();
    }
    public void dependence03(I A) {
        A.run03();
    }
}

class A implements I {

    @Override
    public void run01() {
        System.out.println("这是A需要的接口01");
    }
    @Override
    public void run02() {
        System.out.println("这是A需要的接口02");
    }
    @Override
    public void run03() {
        System.out.println("这是A需要的接口03");
    }
    @Override
    public void run04() {
        System.out.println("A不需要的接口，但在继承的时候依旧需要实现04");
    }
    @Override
    public void run05() {
        System.out.println("A不需要的接口，但在继承的时候依旧需要实现05");
    }
}

class D {
    public void dependence01(I B) {
        B.run01();
    }
    public void dependence04(I B) {
        B.run04();
    }
    public void dependence05(I B) {
        B.run05();
    }
}

class B implements I {

    @Override
    public void run01() {
        System.out.println("这是B需要的接口01");
    }
    @Override
    public void run02() {
        System.out.println("B不需要的接口，但在继承的时候依旧需要实现02");
    }
    @Override
    public void run03() {
        System.out.println("B不需要的接口，但在继承的时候依旧需要实现03");
    }
    @Override
    public void run04() {
        System.out.println("这是B需要的接口04");
    }
    @Override
    public void run05() {
        System.out.println("这是B需要的接口05");
    }
}
