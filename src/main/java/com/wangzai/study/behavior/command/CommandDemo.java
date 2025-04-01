package com.wangzai.study.behavior.command;

import lombok.AllArgsConstructor;

/**
 * <p>
 *     命令模式。定义与理解
 *     定义：  命令模式的本质是将请求封装成对象，将发出命令与执行命令的责任分开，命令的发送者和接收者完全解耦，发送者只需知道如何发送命令，不需要关心命令是如何实现的，甚至是否执行成功都不需要理会。命令模式的关键在于引入了抽象命令接口，发送者针对抽象命令接口编程，只有实现了抽象命令接口的具体命令才能与接收者相关联。
 *     另外命令可以像强对象一样可以被存储和传递，所以可支持撤销的操作
 *     理解：
 * </p>
 * @author 杨灿杭
 * @Description
 * @create 2025-04-01 15:05
 */
public class CommandDemo {
    public static void main(String[] args) {
        Television television = new Television();  // 有一个电视
        // 有一个遥控器，注册了所有能控制电视的指令
        Controller controller = new Controller(
                new OpenCommand(television),new CloseCommand(television),new ChangeChannelCommand(television));
        System.out.println("=======打开电视========");
        controller.executeOpen();
        System.out.println("=======切换频道========");
        controller.executeChangeChanel();
        System.out.println("=======关闭电视========");
        controller.executeClose();
    }
}

// 命令抽象接口
interface Command {
    // 命令执行方法
    public void execute();
}

// 打开命令实体类
@AllArgsConstructor
class OpenCommand implements Command {
    private Television tv;
    @Override
    public void execute() {
        System.out.println("正在执行打开命令");
        tv.open();
    }
}

// 关闭命令实体类
@AllArgsConstructor
class CloseCommand implements Command{
    private Television tv;
    @Override
    public void execute() {
        System.out.println("正在执行关闭命令");
        tv.close();
    }
}

// 切换频道
@AllArgsConstructor
class ChangeChannelCommand implements Command {
    private Television tv;
    @Override
    public void execute() {
        System.out.println("正在执行切换频道命令");
        tv.changeChannel();
    }
}

// 遥控器，存在所有指令
class Controller {
    private Command openCommand;
    private Command closeCommand;
    private Command changeChannelCommand;

    public Controller(Command openCommand, Command closeCommand, Command changeChannelCommand) {
        this.openCommand = openCommand;
        this.closeCommand = closeCommand;
        this.changeChannelCommand = changeChannelCommand;
    }

    // 执行打开指令
    public void executeOpen(){
        openCommand.execute();
    }
    // 执行关闭指令
    public void executeClose(){
        closeCommand.execute();
    }
    // 执行切换频道指令
    public void executeChangeChanel(){
        changeChannelCommand.execute();
    }
}

class Television {
    public void open(){
        System.out.println("打开电视~~~");
    }
    public void close() {
        System.out.println("关闭电视~~~");
    }
    public void changeChannel(){
        System.out.println("切换频道~~~");
    }
}
