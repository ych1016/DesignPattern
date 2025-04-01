package com.wangzai.study.behavior.command;

import lombok.AllArgsConstructor;

/**
 * @author 杨灿杭
 * @Description
 * @create 2025-04-01 15:41
 */
public class CommandAdvancedDemo {
    public static void main(String[] args) {
        TV tv = new TV();
        ControllerAd controllerAd = new ControllerAd(new OpenCommandAd(tv),new CloseCommandAd(tv),new ChangeChannelCommandAd(tv));

        System.out.println("=======打开电视========");
        controllerAd.executeOpen();
        System.out.println("=======切换频道========");
        controllerAd.executeChangeChanel(1);
        controllerAd.executeChangePreChannel();
        controllerAd.executeChangeChanel(3);
        controllerAd.executeChangePreChannel();

        System.out.println("=======关闭电视========");
        controllerAd.executeClose();


    }
}

interface CommandAd{
    public void execute(int i);
}

// 打开命令实体类
@AllArgsConstructor
class OpenCommandAd implements CommandAd {
    private TV tv;
    @Override
    public void execute(int i) {
        System.out.println("正在执行打开命令");
        tv.open();
    }
}

// 关闭命令实体类
@AllArgsConstructor
class CloseCommandAd implements CommandAd{
    private TV tv;
    @Override
    public void execute(int i) {
        System.out.println("正在执行关闭命令");
        tv.close();
    }
}

// 切换频道
@AllArgsConstructor
class ChangeChannelCommandAd implements CommandAd {
    private TV tv;
    @Override
    public void execute(int i) {
        System.out.println("正在执行切换频道命令，切换频道为：" + i);
        tv.changeChannel();
    }
}

class ControllerAd {
    private CommandAd openCommand;
    private CommandAd closeCommand;
    private CommandAd changeChannelCommand;

    private Integer nowChannel = 0;  // 当前频道
    private Integer preChannel = 1;   // 上一个频道

    public ControllerAd(CommandAd openCommand, CommandAd closeCommand, CommandAd changeChannelCommand) {
        this.openCommand = openCommand;
        this.closeCommand = closeCommand;
        this.changeChannelCommand = changeChannelCommand;
    }

    // 执行打开指令
    public void executeOpen(){
        openCommand.execute(0);
    }
    // 执行关闭指令
    public void executeClose(){
        closeCommand.execute(0);
    }
    // 执行切换频道指令
    public void executeChangeChanel(Integer i){
        preChannel = nowChannel;
        nowChannel = i;
        changeChannelCommand.execute(nowChannel);
    }

    // 切换上一个频道
    public void executeChangePreChannel(){
        Integer tmp = preChannel;
        preChannel = nowChannel;
        nowChannel = tmp;
        changeChannelCommand.execute(nowChannel);
    }
}

class TV {
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