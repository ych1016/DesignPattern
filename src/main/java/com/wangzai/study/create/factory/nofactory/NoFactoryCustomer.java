package com.wangzai.study.create.factory.nofactory;

/**
 * <p>
 *     不使用工厂模式
 * </p>
 * @author 杨灿杭
 * @Description
 * @create 2025-03-12 20:07
 */
public class NoFactoryCustomer {
    public static void main(String[] args) {
        NoFactoryCustomer customer = new NoFactoryCustomer();
        customer.createMBPM3();
        customer.createMBPM4();
    }

    public MBPM3 createMBPM3() {
        return new MBPM3();
    }

    public MBPM4 createMBPM4() {
        return new MBPM4();
    }
}

class MBPM3 {
    public MBPM3(){
        System.out.println("生产---> MBPM3电脑");
    }
}

class MBPM4 {
    public MBPM4(){
        System.out.println("生产MBPM4电脑");
    }
}
