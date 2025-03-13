package com.wangzai.study.sixprinciple.openclose;

/**
 * @author 杨灿杭
 * @Description
 * @create 2025-03-13 10:10
 */
public class OpenCloseDemo {
    public static void main(String[] args) {

    }
}

/**
 * 商品接口
 */
interface IGood {
    String getId();

    String getName();

    Double getPrice();
}

/**
 * 普通商品类
 */
class NormalGood implements IGood {
    private String id;
    private String name;
    private Double price;

    public NormalGood(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}

/**
 * 折扣商品类
 */
class DiscountGood extends NormalGood {
    public DiscountGood(String id, String name, Double price) {
        super(id, name, price);
    }

    public Double getDisCountPrice(Double discount) {
        return super.getPrice() * discount;
    }
}