package com.xiaxinyu.ordersystem.service;

import com.xiaxinyu.ordersystem.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductInfo findOne(String productId);

    //查询所有在架商品
    List<ProductInfo> findUpAll();

    //管理段查询所有商品
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //库存自增

    //库存自减

}
