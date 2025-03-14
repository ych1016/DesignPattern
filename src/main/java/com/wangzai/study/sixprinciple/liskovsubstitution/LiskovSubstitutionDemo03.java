package com.wangzai.study.sixprinciple.liskovsubstitution;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     重写或者实现父类方法的时候，方法的返回值可以被缩小，但是不能放大。
 * </p>
 * @author 杨灿杭
 * @Description
 * @create 2025-03-14 9:36
 */
public class LiskovSubstitutionDemo03 {
    public static void main(String[] args) {

    }
}

// 错误示范
class Base03 {
    public ArrayList getList(){
        return new ArrayList();
    }
}
class Son03 extends Base03{
//    public List getList() {     // 编译器直接不通过
//        return new ArrayList();
//    }
}

// 修正
class Base03Correct{
    public List getList(){
        return new ArrayList();
    }
}
class Son03Correct extends Base03Correct{
    public ArrayList getList() {
        return new ArrayList();
    }
}