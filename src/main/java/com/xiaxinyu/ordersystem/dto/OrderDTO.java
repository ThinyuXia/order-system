package com.xiaxinyu.ordersystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xiaxinyu.ordersystem.dataobject.OrderDetail;
import com.xiaxinyu.ordersystem.enums.OrderStatusEnum;
import com.xiaxinyu.ordersystem.enums.PayStatusEnum;
import com.xiaxinyu.ordersystem.utils.serializer.Date2LongSerializer;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL) 全局配置
//字段为空时不返回
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    //买家端微信
    private String buyerOpenid;

    private BigDecimal buyerAmount;

    //订单状态,默认为新下单
    private Integer orderStatus;

    //支付状态,默认为0未支付
    private Integer payStatus;

    //创建时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    //更新时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;
}
