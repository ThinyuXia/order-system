package com.xiaxinyu.ordersystem.dataobject;

import com.xiaxinyu.ordersystem.enums.OrderStatusEnum;
import com.xiaxinyu.ordersystem.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@DynamicUpdate
public class OrderMaster { //订单主表
    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    //买家端微信
    private String buyerOpenid;

    //订单总金额
    private BigDecimal buyerAmount;

    //订单状态,默认为新下单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    //支付状态,默认为0未支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

//    @Transient //不去数据库找对应字段
//    private List<OrderDetail> orderDetailList;

}
