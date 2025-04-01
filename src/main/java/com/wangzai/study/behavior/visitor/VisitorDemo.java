package com.wangzai.study.behavior.visitor;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     访问者模式，先说说定义和自己的理解
 *     定义：访问者模式适用于数据结构相对稳定的系统，将数据结构与基于数据的操作进行分离，使得添加作用于这些数据结构的新操作变得简单，
 *     并且不需要改变各数据结构，为不同类型的数据结构提供多种访问操作方式，这样是访问者模式的设计动机。
 *     自己的理解：emmm... 是有点不太好理解，看到实例代码后，感觉还是可以说一下自己的想法。
 *     主要的场景是这样的，现在有一个总体类和多个成员类。并且总体类里有成员类作为属性，且很长一段时间内都不会变动这些成员。
 *     现在总体类不改变成员，但是希望能新增成员类的功能，如果不使用访问者模式，则就需要修改成员类和总体类，成员类需要新增方法，总体类需要新增调用成员类新方法的方法。
 *     非常麻烦不说，还违背了开闭原则。访问者模式是如何解决？
 *     访问者模式把成员类当作是被访问者，把访问动作抽象成接口，并将其作为方法参数传入总体类的方法中。总体类想要成员类完成不同动作时，只需要传入对应的完成动作的类即可
 *     对于被访问者。又该如何实现不修改而新增新功能呢？ 被访问者需要实现一个接收方法，
 * </p>
 * @author 杨灿杭
 * @Description
 * @create 2025-03-31 16:19
 */
public class VisitorDemo {
    public static void main(String[] args) {
        Company company = new Company();
        // 开发设计软件
        SocialApp socialApp = new SocialApp();
        company.startProject(socialApp);
        System.out.println("=================================================");
        // 开发短视频软件
        LiveApp liveApp = new LiveApp();
        company.startProject(liveApp);
    }
}

// 员工抽象接口
interface IEmployer {
    public void accept(CorporateSlaveVisitor visitor);
}

// 员工实体类：程序员
@Data
@AllArgsConstructor
class Programmer implements IEmployer{
    private String name;
    @Override
    public void accept(CorporateSlaveVisitor visitor) {
        visitor.visit(this);   // 把自己的权限给访问者
    }
}

// 员工实体类：测试
@Data
@AllArgsConstructor
class Tester implements IEmployer {
    private String name;

    @Override
    public void accept(CorporateSlaveVisitor visitor) {
        visitor.visit(this);   // 把自己的权限交给访问者
    }
}

// 员工实体类：运维
@Data
@AllArgsConstructor
class Ops implements IEmployer {
    private String name;
    @Override
    public void accept(CorporateSlaveVisitor visitor) {
        visitor.visit(this);    // 把自己的权限交给访问者
    }
}

// 员工抽象访问者接口
interface CorporateSlaveVisitor{
    public void visit(Programmer programmer);  // 拿到程序员权限
    public void visit(Tester tester);   // 拿到测试员的权限
    public void visit(Ops ops);    // 拿到运维的权限
}

// 公司
class Company {
    private List<IEmployer> employerList;   // 养了一帮员工

    public Company() {
        employerList = new ArrayList<>();
        employerList.add(new Programmer("张三"));  // 雇了程序员张三
        employerList.add(new Tester("李四"));   // 雇了测试李四
        employerList.add(new Ops("王五"));   // 雇了 运维王五
    }

    /**
     * 开启项目方法
     * @param visitor 需要有个hr带人来工作
     */
    public void startProject(CorporateSlaveVisitor visitor) {
        for (IEmployer employer : employerList) {
            employer.accept(visitor);    // 员工接收hr
        }
    }
}

class SocialApp implements CorporateSlaveVisitor {
    @Override
    public void visit(Programmer programmer) {
        System.out.printf("%s: 给你一个月，先仿照微信搞个类似的APP出来,要能语音能发红包,将来公司上市了少不了你的，好好干...%n", programmer.getName());
    }

    @Override
    public void visit(Ops ops) {
        System.out.printf("%s: 给你一个月，把项目部署好，把环境调通，...%n", ops.getName());
    }

    @Override
    public void visit(Tester tester) {
        System.out.printf("%s: 这是咱创业的第一炮，一定要打响，测试不能掉链子啊，不能让APP带伤上战场，以后给你多招点人，你就是领导了...%n", tester.getName());
    }
}

class LiveApp implements CorporateSlaveVisitor {
    @Override
    public void visit(Programmer programmer) {
        System.out.printf("%s: 最近小视频很火啊，咱能不能抄袭下抖音，搞他一炮,将来公司上市了，你的身价至少也是几千万，甚至上亿...%n",programmer.getName());
    }

    @Override
    public void visit(Ops ops) {
        System.out.printf("%s: 咱公司就数你长得靓，哪天化化妆，把你的事业线适当露一露，要是火了你在北京买房都不是梦...%n",ops.getName());
    }

    @Override
    public void visit(Tester tester) {
        System.out.printf("%s: 你也开个账户，边测试边直播，两不耽误...%n",tester.getName());
    }
}


