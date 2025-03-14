package com.wangzai.study.sixprinciple.liskovsubstitution;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     当子类需要重载父类中的方法的时候，子类方法的形参（入参）要比父类方法输入的参数更宽松（范围更广）。
 * </p>
 * @author 杨灿杭
 * @Description
 * @create 2025-03-14 9:24
 */
public class LiskovSubstitutionDemo02 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Base02 base02 = new Base02();
        base02.method(list);
        // 将父类的位置换成子类
        Son02 son02 = new Son02();
        son02.method(list);

        System.out.println("==============================");

        Base02Correct base02Correct = new Base02Correct();
        base02Correct.method(list);
        // 将子类替换成父类
        Son02Correct son02Correct = new Son02Correct();
        son02Correct.method(list);

        /**
         * 输出：
         * 父类方法执行了~
         * 子类方法执行了~
         * ==============================
         * 父类方法执行了~
         * 父类方法执行了~
         */
    }
}

/**
 * 现在子类需要重载父类的方法
 */
// 错误示范，子类参数范围比父类小
class Base02 {
    public void method (List list){
        System.out.println("父类方法执行了~");
    }
}
class Son02 extends Base02 {
    public void method(ArrayList list) {
        System.out.println("子类方法执行了~");
    }
}

// 修正
class Base02Correct {
    public void method (ArrayList list){
        System.out.println("父类方法执行了~");
    }
}
class Son02Correct extends Base02Correct {
    public void method(List list) {
        System.out.println("子类方法执行了~");
    }
}