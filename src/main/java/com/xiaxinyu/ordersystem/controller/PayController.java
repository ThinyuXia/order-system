package com.xiaxinyu.ordersystem.controller;

import com.xiaxinyu.ordersystem.dto.OrderDTO;
import com.xiaxinyu.ordersystem.enums.ResultEnum;
import com.xiaxinyu.ordersystem.exception.SellException;
import com.xiaxinyu.ordersystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/create")
    public void creat(@RequestParam("orderId") String orderId,
                      @RequestParam("returnUrl") String returnUrl){
        //1.查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //2.发起支付

    }
}
