package com.wangzai.study.behavior.chainofresponsibility;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

/**
 * <p>
 *     责任链方法，依旧是定义和自己的理解
 *     定义：职责链可以将请求的处理者组织成一条链，并将请求沿着链传递，如果某个处理者能够处理请求则处理，否则将该请求交由上级处理。客户端只需将请求发送到职责链上，无须关注请求的处理细节，通过职责链将请求的发送者和处理者解耦了，这也是职责链的设计动机。
 *     理解：我觉得责任链有点像类的单一原则，把存在 if-else 的程序进行拆分，让每一种情况都有一种类进行处理，
 *     不过与之不同的时，要用到责任链的场景是原有 if-else 实现的程序的条件判断存在顺序关系（即递增或递减关系），
 *     具体的代码实现则是，先判断的类把后判断的类作为自己的属性，建立关联关系，当自己处理不了时，交给上一级处理
 * </p>
 * @author 杨灿杭
 * @Description
 * @create 2025-03-31 13:51
 */
public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        Counselor counselor = new Counselor("小明");
        DepartmentHead departmentHead = new DepartmentHead("小张");
        Dean dean = new Dean("小李");
        President president = new President("小工");

        // 建立关系
        counselor.setAfterHandler(departmentHead);  // 辅导员上级是系主任
        departmentHead.setAfterHandler(dean);   // 系主任上级是院长
        dean.setAfterHandler(president);    // 院长上级是校长

        // 现在有一份请假条  不同天数，处理人不一样, 但都是先交给辅导员
        // 3天
        LeaveNode leaveNode = new LeaveNode("张三",3);
        counselor.handleRequest(leaveNode);
        // 5天
        leaveNode.setNumber(5);
        counselor.handleRequest(leaveNode);
        // 10天
        leaveNode.setNumber(10);
        counselor.handleRequest(leaveNode);
        // 15天
        leaveNode.setNumber(15);
        counselor.handleRequest(leaveNode);
    }
}

// 处理对象
@Data
@AllArgsConstructor
class LeaveNode {
    // 请假人
    private String person;
    // 请假天数
    private Integer number;
}

// 抽象处理者
@Data
abstract class Handler {
    // 处理者姓名
    protected String name;
    // 后继处理者
    protected Handler afterHandler;
    // 抽象处理函数
    public abstract void handleRequest(LeaveNode leaveNode);

    public Handler(String name){
        this.name = name;
    }
}

// 辅导员
class Counselor extends Handler {

    public Counselor(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveNode leaveNode) {
        if(leaveNode.getNumber() <= 3) {
            System.out.println("辅导员" + name + "审批" + leaveNode.getPerson() + "同学的请假条,请假天数为" + leaveNode.getNumber() + "天。");
            return;
        }
        if(Objects.nonNull(afterHandler)){
            afterHandler.handleRequest(leaveNode);
        }
    }
}

// 系主任
class DepartmentHead extends Handler{
    public DepartmentHead(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveNode leaveNode) {
        if(leaveNode.getNumber()<=7){
            System.out.println("系主任" + name + "审批" + leaveNode.getPerson() + "同学的请假条,请假天数为" + leaveNode.getNumber() + "天。");
            return;
        }
        if(Objects.nonNull(afterHandler)){
            afterHandler.handleRequest(leaveNode);
        }
    }
}

// 院长
class Dean extends Handler{

    public Dean(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveNode leaveNode) {
        if(leaveNode.getNumber() <= 10){
            System.out.println("院长" + name + "审批" + leaveNode.getPerson() + "同学的请假条,请假天数为" + leaveNode.getNumber() + "天。");
            return;
        }
        if(Objects.nonNull(afterHandler)){
            afterHandler.handleRequest(leaveNode);
        }
    }
}

// 校长
class President extends Handler {

    public President(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveNode leaveNode) {
        if(leaveNode.getNumber() <= 15){
            System.out.println("校长" + name + "审批" + leaveNode.getPerson() + "同学的请假条,请假天数为" + leaveNode.getNumber() + "天。");
            return;
        }
        System.out.println("超过15天，不给审批！");
    }
}