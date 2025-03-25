package com.wangzai.study.sixprinciple.dependencyinversion;


/**
 * @author 杨灿杭
 * @Description
 * @create 2025-03-18 15:09
 */
public class DependencyInversionDemo {
    public static void main(String[] args) {
//        Book book = new Book();
//        Monther monther = new Monther();
//        monther.readContent(book);
        /**
         * 输出：
         * 童话说雨后会有彩虹，却不曾说也会转身成空~
         */
        MontherRight montherRight = new MontherRight();
        BookRight bookRight = new BookRight();
        NewsPaperRight newsPaperRight = new NewsPaperRight();
        montherRight.readContent(bookRight);
        montherRight.readContent(newsPaperRight);
        /**
         * 输出：
         *  童话说雨后会有彩虹，却不曾说也会转身成空~
         *  最新消息，本台记者报道~
         */
    }
}

/**
 * 错误示范
 */
class Book {
    public String getContent() {
        String content = "童话说雨后会有彩虹，却不曾说也会转身成空~";
        System.out.println(content);
        return content;
    }
}

class NewPaper {
    public String getContent() {
        String content = "最新消息，本台记者报道~";
        System.out.println(content);
        return content;
    }
}

class Monther {
    // 母亲只能读睡前故事，读不了报纸，要想读报纸就得就该母亲这个类
    public void readContent(Book book) {
        book.getContent();
    }
}

/**
 * 修正
 */
interface Reader {
    public String getContent();
}

class BookRight implements Reader {
    @Override
    public String getContent() {
        String content = "童话说雨后会有彩虹，却不曾说也会转身成空~";
        System.out.println(content);
        return content;
    }
}

class NewsPaperRight implements Reader {
    @Override
    public String getContent() {
        String content = "最新消息，本台记者报道~";
        System.out.println(content);
        return content;
    }
}

class MontherRight {
    public void readContent(Reader reader) {
        reader.getContent();
    }
}