package com.xiaxinyu.ordersystem.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class ProductInfo {

    @Id
    private String productId; //主键是字符串类型，不自增

    private String productName; //商品名

    private BigDecimal productPrice;  //商品价格

    private Integer productStock; //商品库存

    private String productDescription; //商品描述

    private String productIcon; //商品图片

    // 0 正常 1 下架
    private Integer productStatus;

    private Integer categoryType; //类目编号

}
