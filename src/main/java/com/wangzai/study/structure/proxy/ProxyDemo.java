package com.wangzai.study.structure.proxy;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>
 * 代理模式实现代码，这里简单讲一下原理，看了其他文章，总体描述下来就是，代理对象是替原来的对象去完成某些任务。
 * 但是我自己看完后有自己的理解，我觉得代理模式更像是以上帝视角去操纵这一切。
 * 举个抽象场景：
 * （1）现在有三个角色：角色A、角色B、角色C，角色A是原对象，角色B是被访问对象，角色C是代理对象
 * （2）现在A想送B礼物，但是缘分未到，不敢送。所以A求助了C，此时C刚好能操纵A，同时也具备对B的访问权限。
 * （3）代码实现： A要想送礼物给B，就需要对B有访问权限，最直接的方法就是实现关联，其具体实现便是将B作为A的属性成员，并且A有所有送礼物给B的方法。
 * C想要操纵A，则需要把A当作自己的属性成员。C操纵A去调用自己送礼物的方法。
 * </p>
 *
 * @author 杨灿杭
 * @Description
 * @create 2025-03-26 10:32
 */
public class ProxyDemo {
    public static void main(String[] args) {
        BeautifulGirl mm = new BeautifulGirl("小美");
        ProxyGod proxyGod = new ProxyGod(mm);
        proxyGod.giveFlowers();
        proxyGod.giveChocolate();
        proxyGod.giveBook();
    }
}

@Data
@AllArgsConstructor
class BeautifulGirl {
    private String name;
}

interface GiveGift {
    void giveFlowers();

    void giveChocolate();

    void giveBook();

}

@AllArgsConstructor
class You implements GiveGift {
    private BeautifulGirl mm;

    @Override
    public void giveFlowers() {
        System.out.println(mm.getName() + " 送你花花");
    }

    @Override
    public void giveChocolate() {
        System.out.println(mm.getName() + " 送你巧克力");
    }

    @Override
    public void giveBook() {
        System.out.println(mm.getName() + " 送你书本");
    }
}

class ProxyGod implements GiveGift {

    private You you;

    public ProxyGod(BeautifulGirl mm) {
        this.you = new You(mm);
    }

    @Override
    public void giveFlowers() {
        you.giveFlowers();
    }
    @Override
    public void giveChocolate() {
        you.giveChocolate();
    }
    @Override
    public void giveBook() {
        you.giveBook();
    }
}


