package com.wangzai.study.create.singleton;

import java.util.Objects;

/**
 * @author 杨灿杭
 * @Description
 * @create 2025-03-13 17:12
 */
public class LazyInitializationDemo {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}

class Singleton {
    private Singleton() {
        System.out.println("我是懒汉，恭喜你启动我的创建功能");
    }

    private static Singleton singleton = null;

    // 静态工厂方法，提供唯一公共访问点
    public static Singleton getInstance() {
        if (Objects.isNull(singleton)) {
            singleton = new Singleton();
        }
        return singleton;
    }
}

// 添加同步机制
class SingletonV2 {
    private SingletonV2() {
        System.out.println("我是懒汉，恭喜你启动我的创建功能");
    }

    private static SingletonV2 singletonV2 = null;

    // 静态工厂方法，提供唯一公共访问点
    public static synchronized SingletonV2 getInstance() {
        if (Objects.isNull(singletonV2)) {
            singletonV2 = new SingletonV2();
        }
        return singletonV2;
    }
}

// 双重判断
class SingletonV3 {
    private SingletonV3() {
        System.out.println("我是懒汉，恭喜你启动我的创建功能");
    }

    private static volatile SingletonV3 singletonV3 = null;

    // 静态工厂方法，提供唯一公共访问点
    public static SingletonV3 getInstance() {
        if (Objects.isNull(singletonV3)) {
            synchronized (SingletonV3.class) {
                if (Objects.isNull(singletonV3)) {
                    singletonV3 = new SingletonV3();
                }
            }
        }
        return singletonV3;
    }
}

// 静态内部类
class SingletonV4 {
    private SingletonV4() {
        System.out.println("我是懒汉，恭喜你启动我的创建功能");
    }
    private static class LayHolder {
        private static final SingletonV4 INSTANCE = new SingletonV4();
    }
    // 静态工厂方法，提供唯一公共访问点
    public static synchronized SingletonV4 getInstance() {
        return LayHolder.INSTANCE;
    }
}
