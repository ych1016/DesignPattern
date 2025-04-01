package com.wangzai.study.behavior.strategy;

import lombok.Data;

/**
 * <p>
 * 策略模式，先讲讲定义和自己的理解
 * 定义；将类中经常改变或者可能改变的部分提取为作为一个抽象策略接口类，然后在类中包含这个对象的实例，这样类实例在运行时就可以随意调用实现了这个接口的类的行为。
 * 自己的理解：它跟组合模式有点像，都是要具体实现和使用分离。但是跟组合模式又有点不太一样。组合模式更多的是不同功能类的组合，策略模式更像是组合模式更细微的表达。
 * 使用接口的方式对一个方法的多种不同实现方式进行聚合，并暴露统一的调用方法给客户端，并不会透露任何实现方式。
 * </p>
 *
 * @author 杨灿杭
 * @Description
 * @create 2025-03-26 14:45
 */
public class StrategyDesignPatternDemo {
    public static void main(String[] args) {
        // 冒泡排序
        BubbleSort bubbleSort = new BubbleSort();
        // 归并排序
        MergeSort mergeSort = new MergeSort();
        // 快速排序
        QuickSort quickSort = new QuickSort();

        // 使用冒泡排序
        SortFunction sortFunction = new SortFunction(bubbleSort);
        sortFunction.sortArr();
        // 使用归并排序
        sortFunction.setStrategy(mergeSort);
        sortFunction.sortArr();
        // 使用快速排序
        sortFunction.setStrategy(quickSort);
        sortFunction.sortArr();
    }
}

interface Strategy {
    public void sort();
}

class BubbleSort implements Strategy {

    @Override
    public void sort() {
        System.out.println("当前采用冒泡排序");
    }
}

class MergeSort implements Strategy {

    @Override
    public void sort() {
        System.out.println("当前采用归并排序");
    }
}

class QuickSort implements Strategy {

    @Override
    public void sort() {
        System.out.println("当前采用快速排序");
    }
}

@Data
class SortFunction {
    private Strategy strategy;

    public SortFunction(Strategy strategy) {
        this.strategy = strategy;
    }

    public void sortArr() {
        strategy.sort();
    }
}