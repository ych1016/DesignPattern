package com.wangzai.study.create.prototype.copy;

/**
 * @author 杨灿杭
 * @Description
 * @create 2025-03-24 14:47
 */
public class ObjectCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher02 teacher02 = new Teacher02("李四",29);
        Teacher02 teacher02_1 = teacher02.clone();
        System.out.println(teacher02);
        System.out.println(teacher02_1);
        /**
         * 输出
         * com.wangzai.study.create.prototype.copy.Teacher02@7699a589
         * com.wangzai.study.create.prototype.copy.Teacher02@58372a00
         */
    }
}

class Teacher02 implements Cloneable {
    private String name;
    private Integer age;

    public Teacher02(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Teacher02 clone() throws CloneNotSupportedException {
        return (Teacher02) super.clone();
    }
}
