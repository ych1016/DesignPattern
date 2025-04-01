package com.wangzai.study.structure.facade;

/**
 * <p>
 * 外观模式。还是讲一下原理和自己学习的一些理解。
 * 外观模式其实就是为了解耦具体实现和使用。比较贴合生活的栗子是，把连接处做成即插即用，使用方不需要关心具体功能是如何实现的，实现方也不需要关心自己会被怎么使用
 * 关于我自己的理解，其实我感觉在实际开发中，很想MVC的三层架构，通过分层，各司其职，下层向上层提供方法，不需要透露自己实现的代码。
 * </p>
 *
 * @author 杨灿杭
 * @Description
 * @create 2025-03-26 13:41
 */
public class FacadeDemo {
    public static void main(String[] args) {
        CPU cpu = new CPU();
        Memory memory = new Memory();
        Monitor monitor = new Monitor();
        Computer computer = new Computer(cpu, memory, monitor);
        computer.start();
        System.out.println("==========================================");
        computer.close();
    }
}

// 这个接口可要可不要
interface IUpAndDown {
    public void start();

    public void close();
}

class CPU implements IUpAndDown {

    @Override
    public void start() {
        System.out.println("start the CPU!");
    }

    @Override
    public void close() {
        System.out.println("close the CPU!");
    }
}

class Memory implements IUpAndDown {

    @Override
    public void start() {
        System.out.println("start the Memory!");
    }

    @Override
    public void close() {
        System.out.println("close the Memory!");
    }
}

class Monitor implements IUpAndDown {

    @Override
    public void start() {
        System.out.println("start the Monitor!");
    }

    @Override
    public void close() {
        System.out.println("close the Monitor!");
    }
}


// 外观模式客户端类
class Computer implements IUpAndDown {
    private CPU cpu;
    private Memory memory;
    private Monitor monitor;

    public Computer(CPU cpu, Memory memory, Monitor monitor) {
        this.cpu = cpu;
        this.memory = memory;
        this.monitor = monitor;
    }


    @Override
    public void start() {
        System.out.println("start the computer!");
        cpu.start();
        memory.start();
        monitor.start();
        System.out.println("complete started the computer!");
    }

    @Override
    public void close() {
        System.out.println("close the computer!");
        cpu.close();
        memory.close();
        monitor.close();
        System.out.println("complete closed the computer!");
    }
}
