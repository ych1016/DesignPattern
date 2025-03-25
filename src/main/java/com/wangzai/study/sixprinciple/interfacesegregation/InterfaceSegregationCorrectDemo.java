package com.wangzai.study.sixprinciple.interfacesegregation;

/**
 * @author 杨灿杭
 * @Description
 * @create 2025-03-24 9:44
 */
public class InterfaceSegregationCorrectDemo {
    public static void main(String[] args) {
        CRight cRight = new CRight();
        cRight.dependence01(new ARight());
        cRight.dependence02(new ARight());
        cRight.dependence03(new ARight());

        DRight dRight = new DRight();
        dRight.dependence01(new BRight());
        dRight.dependence04(new BRight());
        dRight.dependence05(new BRight());

        /**
         * 输出
         * 这是A需要实现的接口01
         * 这是A需要实现的接口02
         * 这是A需要实现的接口03
         * 这是B需要实现的接口01
         * 这是B需要实现的接口04
         * 这是B需要实现的接口05
         */
    }
}

// 拆分接口，其实就是细粒度化接口
interface IBase {
    public void run01();
}

interface IA {
    public void run02();
    public void run03();
}

interface IB {
    public void run04();
    public void run05();
}

class ARight implements IBase, IA {

    @Override
    public void run01() {
        System.out.println("这是A需要实现的接口01");
    }

    @Override
    public void run02() {
        System.out.println("这是A需要实现的接口02");
    }

    @Override
    public void run03() {
        System.out.println("这是A需要实现的接口03");
    }
}

class CRight {
    public void dependence01(IBase A) {
        A.run01();
    }

    public void dependence02(IA A) {
        A.run02();
    }

    public void dependence03(IA A) {
        A.run03();
    }
}

class BRight implements IBase, IB {

    @Override
    public void run01() {
        System.out.println("这是B需要实现的接口01");
    }

    @Override
    public void run04() {
        System.out.println("这是B需要实现的接口04");
    }

    @Override
    public void run05() {
        System.out.println("这是B需要实现的接口05");
    }
}

class DRight {
    public void dependence01(IBase B) {
        B.run01();
    }

    public void dependence04(IB B) {
        B.run04();
    }

    public void dependence05(IB B) {
        B.run05();
    }
}