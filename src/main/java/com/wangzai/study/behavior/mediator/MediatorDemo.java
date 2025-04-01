package com.wangzai.study.behavior.mediator;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 中介模式，定义与自己的理解
 * 定义：中介者模式通过中介者对象来封装一系列的对象交互，将对象间复杂的关系网状结构变成结构简单的以中介者为核心的星形结构，对象间一对多的关联转变为一对一的关联，简化对象间的关系，便于理解；各个对象之间的关系被解耦，每个对象不再和它关联的对象直接发生相互作用，而是通过中介者对象来与关联的对象进行通讯，使得对象可以相对独立地使用，提高了对象的可复用和系统的可扩展性。
 * 理解：功能与含义一致，就是充当中介的作用，就是一个转发的角色。
 * </p>
 *
 * @author 杨灿杭
 * @Description
 * @create 2025-04-01 14:34
 */
public class MediatorDemo {
    public static void main(String[] args) {
        MediatorStructure mediatorStructure = new MediatorStructure();   // 现有中介
        HouseOwner houseOwner = new HouseOwner("小明", mediatorStructure); // 房主小明找上中介
        mediatorStructure.setHouseOwner(houseOwner);  // 中介帮小明登记
        Tenant tenant = new Tenant("小军",mediatorStructure);   // 小军找上中介
        mediatorStructure.setTenant(tenant);   // 中介帮小军登记

        // 下面开始发送信息
        houseOwner.constact("我是房主。我有一间房子要出租，有谁需要嘛？");
        tenant.constact("我是租户， 我想要租一间房子！");

    }
}

/**
 * 以租房子为栗子，在这中间共有三个角色，分别为：房主、租户、和中介机构。 房主和租户是联系不上对方的个体
 */

// 中介抽象类
abstract class Mediator {
    // 声明一个联络方法
    public abstract void constact(String message, Person person);
}

// 中介实体
@EqualsAndHashCode(callSuper = true)
@Data
class MediatorStructure extends Mediator {
    private HouseOwner houseOwner;  // 中介需要有房主的信息
    private Tenant tenant;   // 中介需要知道租户的信息

    @Override
    public void constact(String message, Person person) {
        if (person.equals(houseOwner)) {   // 是房主要发消息， 应该发给租户
            tenant.getMessage(message);
            return;
        }
        // 是租户发消息，应该发给房主
        houseOwner.getMessage(message);
    }
}

// 个体对象抽象
abstract class Person {
    protected String name;
    protected Mediator mediator;   // 每一个个体需要有一个中介

    public Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    // 发送信息给中介
    public abstract void constact(String message);

    // 从中介那里获取到信息
    public abstract void getMessage(String message);
}

// 房主
class HouseOwner extends Person {

    public HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    // 发消息给中介
    @Override
    public void constact(String message) {
        mediator.constact(message, this);
    }

    // 在中介那获取消息
    @Override
    public void getMessage(String message) {
        System.out.println("我是房主" +  name +"，我从中介那里获得消息，消息内容为：" + message);
    }
}

// 租户
class Tenant extends Person {
    public Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }

    // 发消息给中介
    @Override
    public void constact(String message) {
        mediator.constact(message, this);
    }

    // 在中介那获取消息
    @Override
    public void getMessage(String message) {
        System.out.println("我是租户" + name + "，我从中介那里获得消息，消息内容如下：" + message);
    }
}


