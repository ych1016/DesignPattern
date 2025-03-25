package com.wangzai.study.create.prototype.copy;

import lombok.Data;

/**
 * @author 杨灿杭
 * @Description
 * @create 2025-03-24 14:49
 */
public class ShallowCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher03 teacher = new Teacher03("王老师", 43);
        Student03 xiaoming = new Student03("小明", teacher);
        Student03 zhangsan = xiaoming.clone();
        System.out.println("==============拷贝后===============");
        System.out.println(xiaoming);
        System.out.println(zhangsan);

        System.out.println("==============修改老师信息后===============");
        teacher.setName("刘老师");
        teacher.setAge(53);
        System.out.println(xiaoming);
        System.out.println(zhangsan);

        /**
         * 输出
         * ==============拷贝后===============
         * Student03(name=小明, teacher=Teacher03(name=王老师, age=43))
         * Student03(name=小明, teacher=Teacher03(name=王老师, age=43))
         * ==============修改老师信息后===============
         * Student03(name=小明, teacher=Teacher03(name=刘老师, age=53))
         * Student03(name=小明, teacher=Teacher03(name=刘老师, age=53))
         */
    }
}

@Data
class Teacher03 implements Cloneable {
    private String name;
    private Integer age;

    public Teacher03(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Teacher03 clone() throws CloneNotSupportedException {
        return (Teacher03) super.clone();
    }
}

@Data
class Student03 implements Cloneable {
    private String name;
    private Teacher03 teacher;

    public Student03(String name, Teacher03 teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    @Override
    public Student03 clone() throws CloneNotSupportedException {
        Student03 student = (Student03) super.clone();
        return student;
    }
}
