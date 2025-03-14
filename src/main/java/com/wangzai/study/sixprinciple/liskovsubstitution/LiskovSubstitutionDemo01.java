package com.wangzai.study.sixprinciple.liskovsubstitution;

/**
 * <p>
 * 子类必须实现父类的抽象方法，但不得重写（覆盖）父类的非抽象（已实现）方法。
 * </p>
 *
 * @author 杨灿杭
 * @Description
 * @create 2025-03-14 9:08
 */
public class LiskovSubstitutionDemo01 {
    public static void main(String[] args) {
        // 父类应用
        Base01 base = new Base01();
        System.out.println(base.cal(1, 2));

        // 将用到父类的地方替换成子类
        Son01 son = new Son01();
        System.out.println(son.cal(1, 2));

        /**
         * 输出
         * 两数的运算结果为：3
         * 3
         * 两数的运算结果为：-1
         * -1
         */
    }
}
/**
 * 现在子类要实现两数相减
 */
class Base01 {
    public int cal(int a, int b) {
        System.out.println("两数的运算结果为：" + (a + b));
        return a + b;
    }
}
// 错误示范
class Son01 extends Base01 {
    // 子类重写了父类的方法
    public int cal(int a, int b) {
        System.out.println("两数的运算结果为：" + (a - b));
        return a - b;
    }
}

// 修正
class Son01Correct extends Base01 {
    // 新增一个方法
    public int sub(int a, int b) {
        return a - b;
    }
}
