package com.xiaxinyu.ordersystem.service.impl;

import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.xiaxinyu.ordersystem.dto.OrderDTO;
import com.xiaxinyu.ordersystem.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService {

    private BestPayServiceImpl bestPayService;

    @Override
    public void create(OrderDTO orderDTO){
        PayRequest payRequest = new PayRequest();
        bestPayService.pay(payRequest);
    }
}
