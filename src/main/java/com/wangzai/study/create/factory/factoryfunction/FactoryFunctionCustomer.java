package com.wangzai.study.create.factory.factoryfunction;


/**
 * @author 杨灿杭
 * @Description
 * @create 2025-03-13 10:33
 */

public class FactoryFunctionCustomer {
    public static void main(String[] args) {

        Factory factory = new MBPM3Factory();
        MBP m3 = factory.createMBP();
        factory = new MBPM4Factory();
        MBP m4 = factory.createMBP();
    }
}



class MBP {
    public MBP() {
    }
}

class MBPM3 extends MBP {
    public MBPM3() {
        System.out.println("生产 ----- > MBPM3");
    }
}

class MBPM4 extends MBP {
    public MBPM4() {
        System.out.println("生产 ----- > MBPM4");
    }
}

interface Factory {
    MBP createMBP();
}

class MBPM3Factory implements Factory {

    @Override
    public MBP createMBP() {
        return new MBPM3();
    }
}

class MBPM4Factory implements Factory {

    @Override
    public MBP createMBP() {
        return new MBPM4();
    }
}