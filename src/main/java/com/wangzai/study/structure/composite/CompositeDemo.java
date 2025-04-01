package com.wangzai.study.structure.composite;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     组合模式，也是简单讲一下原理和自己的理解。
 *     组合模式主要采用了一种树的结构来管理对应的类，将叶子对象和容器对象进行递归组合，形成树形结构以表示“部分-整体”的层次结构，使得用户对单个对象和组合对象的使用具有一致性
 *     我的理解，其实我感觉就是一种多态的使用，把公共的方法抽象成接口或抽象类，这样在客户端使用时，可以用接口或者抽象类去接各种类型的叶子对象，
 *     在调用时也是调用了叶子对象实现的方法
 * </p>
 * @author 杨灿杭
 * @Description
 * @create 2025-03-26 13:55
 */
public class CompositeDemo {
    public static void main(String[] args) {
        /**
         *                  总文件
         *  音频文件        文本文件          子文件夹
         *                           音频文件  图片文件
         */
        // 总文件夹
        Folder zwjj = new Folder("总文件夹");
        // 在总文件夹下面再放置三个文件，分别是文本文件、音频文件和子文件夹
        Folder subwjj = new Folder("子文件夹");
        VideoFile videoFile01 = new VideoFile("总文件夹下的音频文件");
        TextFile textFile01 = new TextFile("总文件夹下的文本文件");
        // 添加
        zwjj.add(subwjj);
        zwjj.add(videoFile01);
        zwjj.add(textFile01);
        // 在子文件夹下放置两个文件
        ImageFile imageFile02 = new ImageFile("子文件下的图像文件");
        VideoFile videoFile02 = new VideoFile("子文件夹下的音频文件");
        subwjj.add(imageFile02);
        subwjj.add(videoFile02);

        zwjj.display();  // 会先调用子文件夹的display函数，所以会先打印子文件夹下的文件
        System.out.println("==========================");
        subwjj.display();
    }
}

@Data
abstract class File {
    protected String name;

    public File(String name) {
        this.name = name;
    }

    public abstract void display();
}

class Folder extends File {
    private List<File> fileList;

    public Folder(String name) {
        super(name);
        fileList = new ArrayList<>();
    }
    @Override
    public void display() {
        for (File file : fileList) {
            file.display();
        }
    }
    public void add(File file){
        fileList.add(file);
    }
    public void remove(File file){
        fileList.remove(file);
    }
}

class ImageFile extends File{

    public ImageFile(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("这是图片文件，文件名为：" + name);
    }
}

class TextFile extends File {
    public TextFile(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("这是文本文件，文件名为：" + name);
    }
}

class VideoFile extends File {

    public VideoFile(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("这是音频文件，文件名为：" + name);
    }
}