package com.xiaxinyu.ordersystem.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock; //商品库存

    private String productDescription;

    private String productIcon;

    // 0正常 1 下架
    private Integer productStatus;

    //类目编号
    private Integer categoryType;
}
