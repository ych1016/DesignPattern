package com.wangzai.study.create.builder;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 杨灿杭
 * @Description
 * @create 2025-03-14 10:37
 */
public class BuilderPatternDemo {
    public static void main(String[] args) {
        // 指挥者
        Director director = new Director();
        // 还得有订单
        MBPM3Builder mbpm3Builder = new MBPM3Builder();
        // 把订单给指挥者
        director.setAbstractBulider(mbpm3Builder);
        // 构建订单
        director.construct();
        /**
         * 输出：
         * 构建 --------->   MBPM3键盘
         * 构建 --------->   MBPM3显示器
         */
    }

}

// 产品类
// 1. 抽象产品
@Data
class MBP {
    private String keyBoard;
    private String monitor;
}
// 2. 具体产品：MBPM3
@Data
@EqualsAndHashCode(callSuper = true)
class MBPM3 extends MBP {
}
@Data
@EqualsAndHashCode(callSuper = true)
class MBPM4 extends MBP {
}

// 构建者
// 1. 抽象构建者
abstract class AbstractBulider {
    MBP mbp = new MBP();
    public abstract void buildKeyBoard();
    public abstract void buildMonitor();
    public MBP getMbp(){
        return this.mbp;
    }
}
// 2. 具体构建者
class MBPM3Builder extends AbstractBulider{
    @Override
    public void buildKeyBoard() {
        mbp.setKeyBoard("MBPM3键盘");
        System.out.println("构建 --------->   MBPM3键盘");
    }
    @Override
    public void buildMonitor() {
        mbp.setKeyBoard("MBPM3显示器");
        System.out.println("构建 --------->   MBPM3显示器");
    }
}
class MBPM4Builder extends AbstractBulider{
    @Override
    public void buildKeyBoard() {
        mbp.setKeyBoard("MBPM4键盘");
        System.out.println("构建 --------->   MBPM4键盘");
    }
    @Override
    public void buildMonitor() {
        mbp.setKeyBoard("MBPM4显示器");
        System.out.println("构建 --------->   MBPM4显示器");
    }
}

// 指挥者
class Director {
    private AbstractBulider abstractBulider;

    public void setAbstractBulider(AbstractBulider abstractBulider) {
        this.abstractBulider = abstractBulider;
    }

    public MBP construct(){
        this.abstractBulider.buildKeyBoard();
        this.abstractBulider.buildMonitor();
        return this.abstractBulider.getMbp();
    }
}
