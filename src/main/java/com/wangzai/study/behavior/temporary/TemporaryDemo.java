package com.wangzai.study.behavior.temporary;


/**
 * <p>
 *     模板方法，讲一下定义与自己的理解
 *     定义：模板方法是基于继承实现的，在抽象父类中声明一个模板方法，并在模板方法中定义算法的执行步骤（即算法骨架）。
 *     在模板方法模式中，可以将子类共性的部分放在父类中实现，而特性的部分延迟到子类中实现，只需将特性部分在父类中声明成抽象方法即可，使得子类可以在不改变算法结构的情况下，重新定义算法中的某些步骤，不同的子类可以以不同的方式来实现这些逻辑。
 *     理解：学了这么多设计模式，我仍然觉得思路都是一致的，都是在将业务抽象化，而具体落实的抽象则是通过Java的多态和继承机制，模板方法也是一样
 *     也是通过定义接口或者抽象类的形式，对代码进行抽象，唯一的区别是，模板方法需要适配有些流程是固定的业务需求，
 *     所以基本都会使用抽象类来做各个特殊功能类的父类，然后在抽象类中定义一个final方法，使其执行流程不被修改。
 * </p>
 * @author 杨灿杭
 * @Description
 * @create 2025-03-31 11:00
 */
public class TemporaryDemo {
    public static void main(String[] args) {
        SpinachDish spinachDish = new SpinachDish();
        CarrotDish carrotDish = new CarrotDish();
        spinachDish.finishDishes();
        System.out.println("===================================");
        carrotDish.finishDishes();
    }
}

/**
 * 举个炒菜的栗子：不同菜品的步骤顺序基本一致，都是：洗菜、放油，炒菜，装盘
 * 但是不同菜品在各个步骤执行的东西又不一样，
 * 所以，需要对于执行步骤顺序，需要有一个抽象类控制每道菜品都必须实现炒菜步骤，并且需要抽象类定义一个final方法，使得步骤的顺序固定不变
 */

//  抽象类定义整个流程骨架
abstract class AbstractDishes {
    public final void finishDishes(){
        washVegetable();
        downOil();
        stirFry();
        dishingUp();
    }

    // 洗菜
    protected abstract void washVegetable();
    // 放油
    protected abstract void downOil();
    // 炒菜
    protected abstract void stirFry();
    // 装盘
    protected abstract void dishingUp();
}

class SpinachDish extends AbstractDishes{

    @Override
    protected void washVegetable() {
        System.out.println("洗菠菜");
    }

    @Override
    protected void downOil() {
        System.out.println("下猪油");
    }

    @Override
    protected void stirFry() {
        System.out.println("开始进行翻炒，但是中间需要焖煮1分钟");
    }

    @Override
    protected void dishingUp() {
        System.out.println("开始进行菠菜摆盘啦");
    }
}

class CarrotDish extends AbstractDishes{

    @Override
    protected void washVegetable() {
        System.out.println("清洗一下胡萝卜");
    }

    @Override
    protected void downOil() {
        System.out.println("下入橄榄油");
    }

    @Override
    protected void stirFry() {
        System.out.println("开始翻炒胡萝卜！");
    }

    @Override
    protected void dishingUp() {
        System.out.println("开始进行胡萝卜摆盘！");
    }
}