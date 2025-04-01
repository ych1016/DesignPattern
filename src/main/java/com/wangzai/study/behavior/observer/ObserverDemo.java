package com.wangzai.study.behavior.observer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 观察者模式的定义与旺仔的理解
 * 定义： 观察者模式又称为 发布-订阅模式，定义了对象之间一对多依赖关系，当目标对象(被观察者)的状态发生改变时，它的所有依赖者(观察者)都会收到通知。
 * 观察者模式主要包含两种模式，一种推送模式，一种拉去模式。（现实软件一般是这两者的结合实现的通知）
 * 推送模式，当被观察者有任何变动时，系统会主动推送通知给观察者
 * 拉去模式。当被观察者有任何变动时，系统不会主动推送通知，而是得等观察者想要知道被观察者时，主动去访问系统才会推送最新的消息
 * 自己的理解：其实这种业务很多，小红书，微信朋友圈都是，一旦用户之间存在联系，那么这种场景就会存在。
 * 对于推送模式，被观察者得有观察他的对象的列表，以便即使通知。
 * 而拉去模式，则需要留存他观察的对象的列表。
 * 具体代码实现，还是分为主题两步，先抽象后实现
 * </p>
 *
 * @author 杨灿杭
 * @Description
 * @create 2025-03-31 14:17
 */
public class ObserverDemo {
    public static void main(String[] args) {
        Instrument instrument = new Instrument("地表探测仪器", 23.3);
        Staff zs = new Staff("小美");
        Staff ls = new Staff("李四");
        Staff ew = new Staff("无名者");

        instrument.addObserver(zs);
        instrument.addObserver(ls);
        instrument.addObserver(ew);

        System.out.println("======数据第一次变动========");
        instrument.updateNumber(12.3);

        System.out.println("======数据第二次变动========");
        instrument.updateNumber(32.21);

        System.out.println("======数据第三次变动========");
        instrument.updateNumber(2.32);
    }
}

/**
 * 推送模式
 */

// 被观察者
interface IBeObserver {
    // 添加观察者
    public void addObserver(IObserver observer);

    //删除观察者
    public void removeObserver(IObserver observer);

    // 通知观察者
    public void notifyObserver();
}

@Data
class Instrument implements IBeObserver {

    private String name;  // 仪器名称
    private List<IObserver> observerList;  // 观察者列表
    private Double number;

    public Instrument(String name, Double number) {
        this.name = name;
        this.number = number;
        observerList = new ArrayList<>();
    }

    public void updateNumber(Double number) {
        this.number = number;  // 更新数据
        notifyObserver();   // 通知观察者
    }

    @Override
    public void addObserver(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (IObserver observer : observerList) {
            observer.acceptUpdate(number);
        }
    }
}

// 观察者
interface IObserver {
    public void acceptUpdate(Double number);
}

@Data
@AllArgsConstructor
class Staff implements IObserver {
    private String name; // 员工名字
    @Override
    public void acceptUpdate(Double number) {
        System.out.println("我是员工" + name + "，我收到通知，仪器数据被改成了：" + number);
        // 这里可以执行任何关于数据变动后需要执行的操作
    }
}

