package com.wangzai.study.sixprinciple.liskovsubstitution;

/**
 * <p>
 * 子类可以拥有自己独特的方法或属性
 * </p>
 *
 * @author 杨灿杭
 * @Description
 * @create 2025-03-14 9:40
 */
public class LiskovSubstitutionDemo04 {
    public static void main(String[] args) {

    }
}

class Base04 {
    public int add(int a, int b) {
        return a + b;
    }
}
class Son04 extends Base04 {
    public int sub(int a, int b) {
        return a - b;
    }
}
