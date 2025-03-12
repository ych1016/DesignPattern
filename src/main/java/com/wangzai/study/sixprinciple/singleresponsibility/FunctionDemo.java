package com.wangzai.study.sixprinciple.singleresponsibility;

/**
 * 方法的单一原则
 *
 * @author 杨灿杭
 * @Description
 * @create 2025-03-12 14:14
 */
public class FunctionDemo {
    public static void main(String[] args) {

    }
}

// 错误示范
class User {
    /**
     * 当前方法需要完成两个动作，一个是设置用户名称，另外一个是获取用户年龄并返回
     * 不符合方法的单一原则
     * 解决：
     * 拆分方法，将功能模块化
     */
    public Integer setNameAndGetAge(String name) {
        // 1. 设置用户名

        // 2. 获取用户年龄

        return 0;
    }
}

class User2 {
    public void setName(String name) {
        // 设置用户名
    }

    public Integer getAge() {
        // 获取年龄
        return 0;
    }
}
