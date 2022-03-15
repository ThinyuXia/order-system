package com.xiaxinyu.ordersystem.service;

import com.xiaxinyu.ordersystem.dto.OrderDTO;

public interface PayService {
    void create(OrderDTO orderDTO);
}
