package com.xiaxinyu.ordersystem.repository;

import com.xiaxinyu.ordersystem.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest

class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "20203644";

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("15142662711");
        orderMaster.setBuyerAddress("锦州");
        orderMaster.setBuyerOpenid("20203644");
        orderMaster.setOrderAmount(new BigDecimal(2.3));
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    void findByOpenid() {
        PageRequest request = PageRequest.of(0,2);
        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID,request);
        System.out.println(result.getTotalElements());

    }
}