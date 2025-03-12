package com.wangzai.study.sixprinciple.singleresponsibility;

/**
 * 接口单一原则 demo
 * @author 杨灿杭
 * @Description
 * @create 2025-03-12 14:04
 */
public class InterfaceDemo {
    public static void main(String[] args) {

    }
}

// 错误示例
interface IGood {
    /**
     * 可以看到，IGood接口中负责了太多功能，不仅要负责
     * 1. 商品信息管理：获取商品名称 + 获取商品价格
     * 2. 商品售卖管理：购买商品 + 退款
     * 不符合接口的单一原则
     */
    // 获取商品名称
    String getName();
    // 获取商品价格
    Double getPrice();
    // 购买商品
    Boolean buyGood();
    // 退款
    Boolean refund();
}

// 改正
interface IGoodInfo {
    // 获取商品名称
    String getName();
    // 获取商品价格
    Double getPrice();
}

interface IGoodManage{
    // 购买商品
    Boolean buyGood();
    // 退款
    Boolean refund();
}

class GoodImpl implements IGoodInfo, IGoodManage {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Double getPrice() {
        return null;
    }

    @Override
    public Boolean buyGood() {
        return null;
    }

    @Override
    public Boolean refund() {
        return null;
    }
}