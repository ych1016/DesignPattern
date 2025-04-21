package com.wangzai.study.behavior.memento;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 杨灿杭
 * @Description
 * @create 2025-04-02 19:24
 */
public class MementoDemo {
    public static void main(String[] args) {
        History history = new History();   // 备忘录存储器
        Editor editor = new Editor("1");   // 编辑者
        history.insert(editor.createMemento());   // 保存备忘录--> 1

        editor.setContent("2");
        history.insert(editor.createMemento());   // 保存备忘录 --> 2

        editor.setContent("3");
        history.insert(editor.createMemento());    // 保存备忘录  --> 3

        System.out.println("接下类开始回复历史数据");
        editor.restoreMemento(history.pop());
        editor.restoreMemento(history.pop());
        editor.restoreMemento(history.pop());

    }
}

// 编辑者
@Data
class Editor {
    // 编辑的文本内容
    private String content;

    public Editor(String content) {
        this.content = content;
    }

    // 创建备忘录方法
    public Memento createMemento() {
        System.out.println("正在保存备忘录，当前保存的内容为------》 " + content);
        return new Memento(content);
    }
    // 重置当前信息
    public void restoreMemento(Memento memento) {
        this.content = memento.getContent();
        System.out.println("正在恢复备忘录，当前恢复的内容为---------》" + content);
    }

}

@Data
class Memento {
    private String content;  // 备忘录应该具备要记录的属性

    public Memento(String content) {
        this.content = content;
    }
}

class History {
    private List<Memento> mementoList;

    public History() {
        mementoList = new ArrayList<>();
    }

    public void insert(Memento memento) {
        mementoList.add(memento);
    }

    public Memento pop(){
        int lastIndex = mementoList.size() - 1;
        Memento memento = mementoList.get(lastIndex);
        mementoList.remove(lastIndex);
        return memento;
    }
}
