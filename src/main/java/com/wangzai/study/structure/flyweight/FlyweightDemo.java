package com.wangzai.study.structure.flyweight;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     享元模式，讲一下定义和自己的理解
 *      享元模式通过共享技术有效地支持细粒度、状态变化小的对象复用，当系统中存在有多个相同的对象，那么只共享一份，不必每个都去实例化一个对象，极大地减少系统中对象的数量。
 *      自己的理解，其实在我看来，享元模式有点像工厂和单例的结合，系统需要创建对象，但是通过对象可能会被多次创建，但是对象发挥的作用都是一样的。
 *      这也就会导致很消耗内存，我们的改进措施就是，直接可以建一个工厂类，工厂里有存放对象的容器。容器一般用Map去接
 *      然后采用创建单例的方式创建对象，对于没有创建的对象，先创建，再塞入到容器中，最后直接返回；对于已创建的对象，则在容器中查找后，直接返回
 * </p>
 * @author 杨灿杭
 * @Description
 * @create 2025-03-26 14:26
 */
public class FlyweightDemo {
    public static void main(String[] args) {
        Shape red = FlyWeightFactory.getShape("红色");
        red.draw();
        Shape blue = FlyWeightFactory.getShape("蓝色");
        blue.draw();
        Shape green = FlyWeightFactory.getShape("绿色");
        green.draw();
        Shape write = FlyWeightFactory.getShape("白色");
        write.draw();
        Shape red02 = FlyWeightFactory.getShape("红色");
        red02.draw();

        System.out.println("最终创建了：" + FlyWeightFactory.getSize() + " 个圆形");
    }
}

@Data
abstract class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract void draw();
}

class Circle extends Shape {
    public Circle(String color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("画一个 " + color + " 颜色的圆");
    }
}

class FlyWeightFactory {
    private static Map<String, Shape> shapeMap = new HashMap<>();

    // 构造函数私有化，防止重复new工厂对象
    private FlyWeightFactory() {
    }

    public static Shape getShape(String color) {
        if (shapeMap.containsKey(color)) {
            return shapeMap.get(color);
        }
        Circle circle = new Circle(color);
        shapeMap.put(color, circle);
        return circle;
    }

    public static Integer getSize() {
        return shapeMap.size();
    }
}