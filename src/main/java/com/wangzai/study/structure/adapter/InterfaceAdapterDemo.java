package com.wangzai.study.structure.adapter;

/**
 * <p>
 * 接口适配器实现demo代码
 * 简单说明一下：就是有些时候我们需要继承某些接口，实现某些具体的方法，
 * 但是接口中的方法并不全是我们想要的，我们不想实现接口中所有方法，
 * 所以需要中间有一层，帮我们减少对所有方法的实现
 * </p>
 *
 * @author 杨灿杭
 * @Description
 * @create 2025-03-26 9:22
 */
public class InterfaceAdapterDemo {
    public static void main(String[] args) {
        SourceSub01 sourceSub01 = new SourceSub01();
        SourceSub02 sourceSub02 = new SourceSub02();
        sourceSub01.method01();
        sourceSub01.method02();

        sourceSub02.method01();
        sourceSub02.method02();
    }
}

interface Sourceable {
    public void method01();

    public void method02();
}

abstract class Adapter03 implements Sourceable {
    public void method01() {
        System.out.println("method01——这里可以实现也可以不实现");
    }

    public void method02() {
        System.out.println("method02——这里可以实现也可以不实现");
    }
}

class SourceSub01 extends Adapter03 {
    @Override
    public void method01() {
        System.out.println("我只会用到method01的功能，所以我只需要实现method01");
    }
}

class SourceSub02 extends Adapter03 {
    @Override
    public void method02() {
        System.out.println("我只会用到method02的功能，所以我只需要实现method02");
    }
}

