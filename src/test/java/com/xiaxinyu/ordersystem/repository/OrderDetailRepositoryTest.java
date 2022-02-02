package com.xiaxinyu.ordersystem.repository;

import java.util.List;
import com.xiaxinyu.ordersystem.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567890");
        orderDetail.setOrderId("11111111");
        orderDetail.setProductIcon("https====");
        orderDetail.setProductId("11111112");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(1.2));
        orderDetail.setProductQuantity(2);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotEquals(null,result);

    }

    @Test
    public void findByOrderId(){
        List<OrderDetail> orderDetailList = repository.findByOrderId("11111111");
        Assert.assertNotEquals(0,orderDetailList.size());
    }

}