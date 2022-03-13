package com.xiaxinyu.ordersystem.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xiaxinyu.ordersystem.dataobject.OrderDetail;
import com.xiaxinyu.ordersystem.dto.OrderDTO;
import com.xiaxinyu.ordersystem.enums.ResultEnum;
import com.xiaxinyu.ordersystem.exception.SellException;
import com.xiaxinyu.ordersystem.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class OrderFrom2OrderDTO {
    public static OrderDTO convert(OrderForm orderFrom){
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderFrom.getName());
        orderDTO.setBuyerPhone(orderFrom.getPhone());
        orderDTO.setBuyerAddress(orderFrom.getAddress());
        orderDTO.setBuyerOpenid(orderFrom.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try{

            orderDetailList = gson.fromJson(orderFrom.getItems(),new TypeToken<List<OrderDetail>>(){}.getType());

        }catch (Exception e){
            log.error("【对象转换】错误,string={}",orderFrom.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);

        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
