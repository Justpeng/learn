package com.just.learn.basic.dynamic;

public class OrderServiceImpl implements OrderService{
    @Override
    public Integer createOrder(String uid) {
        System.out.println("创建了订单" + uid);
        return 1;
    }
}
