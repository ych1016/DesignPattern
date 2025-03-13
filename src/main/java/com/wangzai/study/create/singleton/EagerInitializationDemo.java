package com.wangzai.study.create.singleton;

/**
 * @author 杨灿杭
 * @Description
 * @create 2025-03-13 20:11
 */
public class EagerInitializationDemo {
    public static void main(String[] args) {

    }
}

class EagerSingleton {
    EagerSingleton() {
        System.out.println("我是饿汉，不用调用我，我也会帮你创建好");
    }
    private final static EagerSingleton single = new EagerSingleton();
    public static EagerSingleton getInstance() {
        return single;
    }
}