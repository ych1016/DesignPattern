package com.wangzai.study.behavior.state;

import lombok.Data;

/**
 * @author 杨灿杭
 * @Description
 * @create 2025-04-02 16:17
 */
public class StateDemo {
    public static void main(String[] args) {
        //创建上下文对象（自动售卖机）
        Machine machine = new Machine();

        System.out.println("=======直接选择商品=======");
        machine.selectProduct();

        System.out.println("======投币--->选择商品--->发放商品=======");
        machine.insertCoin();
        machine.selectProduct();
        machine.dispense();

        System.out.println("=======投币--->发放商品=======");
        machine.insertCoin();
        machine.dispense();
    }
}

// 状态抽象接口
interface State {
    // 投币
    public void insertCoin();

    // 选择商品
    public void selectProduct();

    // 发放商品
    public void dispense();
}

// 具体状态： 未投币状态
class NoCoinState implements State {

    private Machine machine;

    public NoCoinState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("已投币");
        machine.setCurrentState(machine.getHasCoinState());
    }

    @Override
    public void selectProduct() {
        System.out.println("请先投币");
    }

    @Override
    public void dispense() {
        System.out.println("请先投币和选择商品");
    }
}

// 已投币状态
class HasCoinState implements State {

    private Machine machine;

    public HasCoinState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("正在出售商品，请稍等~");
    }

    @Override
    public void selectProduct() {
        System.out.println("挑选商品完成！");
        machine.setCurrentState(machine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("请先选择商品");
    }
}

// 出售状态
class SoldState implements State {

    private Machine machine;

    public SoldState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("正在出售商品，请稍等~");
    }

    @Override
    public void selectProduct() {
        System.out.println("正在出售商品，请稍等~");
    }

    @Override
    public void dispense() {
        System.out.println("出售商品完成！");
        machine.setCurrentState(machine.getNoCoinState());
    }
}

// 机器，也就是综合所有状态的上下文
@Data
class Machine {
    private State noCoinState;  // 未投币状态
    private State hasCoinState;   // 已投币状态
    private State soldState;   // 出售状态
    private State currentState;   // 当前状态

    public Machine() {
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        soldState = new SoldState(this);
        currentState = noCoinState;   // 最开始的当前状态应该是未投币状态
    }

    // 需要提供切换状态的方法
    public void insertCoin() {   // 投币
        currentState.insertCoin();
    }

    public void selectProduct() {  // 挑选商品
        currentState.selectProduct();
    }

    public void dispense() {   // 出售
        currentState.dispense();
    }

}