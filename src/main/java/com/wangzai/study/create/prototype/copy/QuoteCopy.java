package com.wangzai.study.create.prototype.copy;

/**
 * @author 杨灿杭
 * @Description
 * @create 2025-03-24 14:44
 */
public class QuoteCopy {
    public static void main(String[] args) {
        Teacher01 teacher01 = new Teacher01("张三",29);
        Teacher01 teacher01_1 = teacher01;
        System.out.println(teacher01);
        System.out.println(teacher01_1);
        /**
         * 输出
         * com.wangzai.study.create.prototype.copy.Teacher01@7699a589
         * com.wangzai.study.create.prototype.copy.Teacher01@7699a589
         */
    }
}

class Teacher01 {
    private String name;
    private Integer age;

    public Teacher01(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
