package com.wangzai.study.create.factory.easyfactory;

/**
 * <p>
 *     简单工厂模式
 * </p>
 * @author 杨灿杭
 * @Description
 * @create 2025-03-12 20:43
 */
public class EasyFactoryCustomer {
    public static void main(String[] args) {
        Factory factory = new Factory();
        MBP m3 = factory.createMBP("M3");
        MBP m4 = factory.createMBP("M4");

        MBP m31 = Factory.createMBPStatic("M3");
        MBP m41 = Factory.createMBPStatic("M4");
    }
}

class MBP {
    public MBP() {
    }
}
class MBPM3 extends MBP{
    public MBPM3() {
        System.out.println("生产M----->MBP3");
    }
}
class MBPM4 extends MBP{
    public MBPM4() {
        System.out.println("生产M----->MBP4");
    }
}

class Factory{
    public MBP createMBP(String type){
        switch (type){
            case "M3":
                return new MBPM3();
            case "M4":
                return new MBPM4();
            default:
                return null;
        }
    }

    // 静态工厂
    static public MBP createMBPStatic(String type){
        switch (type){
            case "M3":
                return new MBPM3();
            case "M4":
                return new MBPM4();
            default:
                return null;
        }
    }
}