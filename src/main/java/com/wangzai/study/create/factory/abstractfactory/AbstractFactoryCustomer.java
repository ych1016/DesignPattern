package com.wangzai.study.create.factory.abstractfactory;

/**
 * @author 杨灿杭
 * @Description
 * @create 2025-03-13 13:45
 */
public class AbstractFactoryCustomer {

    public static void main(String[] args) {
        Factory m3Factory = new MBPM3Factory();
        m3Factory.createKeyBoard();
        m3Factory.createMonitor();

        Factory m4Factory = new MBPM4Factory();
        m4Factory.createMonitor();
        m4Factory.createKeyBoard();
    }
}


// 键盘
interface KeyBoard {

}
// MBPM3键盘
class MBPM3KB implements KeyBoard {
    public MBPM3KB() {
        System.out.println("生产 ---------> MBPM3键盘");
    }
}
// MBPM4键盘
class MBPM4KB implements KeyBoard {
    public MBPM4KB() {
        System.out.println("生产 ---------> MBPM4键盘");
    }
}

// 显示器
interface Monitor {

}
// MBPM3显示器
class MBPM3MT implements Monitor{
    public MBPM3MT() {
        System.out.println("生产 --------->  MBPM3显示器");
    }
}
// MBPM4显示器
class MBPM4MT implements Monitor{
    public MBPM4MT() {
        System.out.println("生产 --------->  MBPM4显示器");
    }
}

interface Factory{
    Monitor createMonitor();
    KeyBoard createKeyBoard();
}
class MBPM3Factory implements Factory {
    @Override
    public Monitor createMonitor() {
        return new MBPM3MT();
    }
    @Override
    public KeyBoard createKeyBoard() {
        return new MBPM3KB();
    }
}
class MBPM4Factory implements Factory{
    @Override
    public Monitor createMonitor() {
        return new MBPM4MT();
    }
    @Override
    public KeyBoard createKeyBoard() {
        return new MBPM4KB();
    }
}


