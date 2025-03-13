package com.wangzai.study.create.singleton;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 杨灿杭
 * @Description
 * @create 2025-03-13 20:18
 */
public class RegisterInitializationDemo {
    public static void main(String[] args) {

    }
}

// 枚举型单例
enum EnumSingleton {
    INSTANCE
}

// 登记型单例
class CashSingleton {
    private CashSingleton() {
        System.out.println("我是登记型单例，我已经帮你登记好了");
    }
    private static Map<String, CashSingleton> singletonMap = new HashMap<>();
    // 在类加载时执行，且只能执行一次
    static {
        CashSingleton cashSingleton = new CashSingleton();
        singletonMap.put(cashSingleton.getClass().getName(), cashSingleton);
    }
    // 静态工厂，返回此类唯一实例
    public CashSingleton getInstance(String name) {
        if (Objects.isNull(name)) {
            name = CashSingleton.class.getName();
            System.out.println(" name == null " + "---->name=" + name);
        }
        if (Objects.isNull(singletonMap.get(name))) {
            try {
                singletonMap.put(name, (CashSingleton) Class.forName(name).newInstance());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return singletonMap.get(name);
    }
}