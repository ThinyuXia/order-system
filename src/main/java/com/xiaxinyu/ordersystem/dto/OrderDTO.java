package com.xiaxinyu.ordersystem.dto;

import com.xiaxinyu.ordersystem.dataobject.OrderDetail;
import com.xiaxinyu.ordersystem.enums.OrderStatusEnum;
import com.xiaxinyu.ordersystem.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    //买家端微信
    private String buyerOpenid;

    private BigDecimal orderAmount;

    //订单状态,默认为新下单
    private Integer orderStatus;

    //支付状态,默认为0未支付
    private Integer payStatus;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

    List<OrderDetail> orderDetailList;
}
