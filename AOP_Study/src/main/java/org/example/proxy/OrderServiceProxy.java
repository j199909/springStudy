package org.example.proxy;

public class OrderServiceProxy implements OrderService{
    OrderServiceImpl orderService=new OrderServiceImpl();
    @Override
    public void showOrder() {
        System.out.println("-----log----日志操作");
        orderService.showOrder();
    }
}
