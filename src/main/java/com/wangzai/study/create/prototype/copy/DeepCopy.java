package com.wangzai.study.create.prototype.copy;

import lombok.Data;

/**
 * @author 杨灿杭
 * @Description
 * @create 2025-03-24 15:00
 */
public class DeepCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher04 teacher = new Teacher04("杨老师",54);
        Student04 zhangsan = new Student04("张三",teacher);
        Student04 lisi = zhangsan.clone();
        System.out.println("==============拷贝后===============");
        System.out.println(zhangsan);
        System.out.println(lisi);

        System.out.println("==============修改老师信息后===============");
        teacher.setName("刘老师");
        teacher.setAge(53);
        System.out.println(zhangsan);
        System.out.println(lisi);
        /**
         * 输出
         * ==============拷贝后===============
         * Student04(name=张三, teacher=Teacher04(name=杨老师, age=54))
         * Student04(name=张三, teacher=Teacher04(name=杨老师, age=54))
         * ==============修改老师信息后===============
         * Student04(name=张三, teacher=Teacher04(name=刘老师, age=53))
         * Student04(name=张三, teacher=Teacher04(name=杨老师, age=54))
         */
    }
}

@Data
class Teacher04 implements Cloneable {
    private String name;
    private Integer age;

    public Teacher04(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Teacher04 clone() throws CloneNotSupportedException {
        return (Teacher04) super.clone();
    }
}

@Data
class Student04 implements Cloneable{
    private String name;
    private Teacher04 teacher;

    public Student04(String name, Teacher04 teacher) {
        this.name = name;
        this.teacher = teacher;
    }
    @Override
    public Student04 clone() throws CloneNotSupportedException {
        Student04 student = (Student04) super.clone();
        student.setTeacher(student.getTeacher().clone());
        return student;
    }
}
