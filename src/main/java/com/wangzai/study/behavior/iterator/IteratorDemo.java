package com.wangzai.study.behavior.iterator;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 迭代器模式，定义和自己的理解
 * </p>
 *
 * @author 杨灿杭
 * @Description
 * @create 2025-04-02 19:54
 */
public class IteratorDemo {
    public static void main(String[] args) {
        MovieMenu movieMenu = new MovieMenu();
        movieMenu.add(new MenuItem(1, "肖申克的救赎", "自由，幸福，离你有多远"));
        movieMenu.add(new MenuItem(2, "海上钢琴师", "向往，勇敢，清澈"));
        movieMenu.add(new MenuItem(3, "绿皮书", "忠诚、友善、感人"));

        Iterator iterator = movieMenu.createIterator();
        while (iterator.hasNext()) {
            MenuItem menuItem = (com.wangzai.study.behavior.iterator.MenuItem) iterator.next();
            menuItem.display();
        }
    }
}

// 最基础的迭代对象
@Data
@AllArgsConstructor
class MenuItem {
    private Integer channel;
    private String name;
    private String desc;

    public void display() {
        System.out.print("channe:" + channel + ",  ");
        System.out.print("name:" + name + ",  ");
        System.out.println("description :" + desc);
    }
}

interface Iterator {
    Boolean hasNext();

    Object next();
}

@Data
class MovieMenuIterator implements Iterator {

    private List<MenuItem> menuItemList;
    private Integer idx;

    public MovieMenuIterator(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
        idx = 0;
    }

    @Override
    public Boolean hasNext() {
        return idx < this.menuItemList.size();
    }

    @Override
    public Object next() {
        MenuItem menuItem = this.menuItemList.get(idx);
        ++idx;
        return menuItem;
    }
}

// 菜单接口
interface ITVMenu {
    public void add(MenuItem menuItem);

    public Iterator createIterator();
}

class MovieMenu implements ITVMenu {

    private final static Integer MAX_SIZE = 10;

    private List<MenuItem> menuItemList;

    public MovieMenu() {
        menuItemList = new ArrayList<>();
    }

    @Override
    public void add(MenuItem menuItem) {
        if (menuItemList.size() >= MAX_SIZE) {
            throw new RuntimeException("超出最大容量");
        }
        menuItemList.add(menuItem);
    }

    @Override
    public Iterator createIterator() {
        return new MovieMenuIterator(menuItemList);
    }
}