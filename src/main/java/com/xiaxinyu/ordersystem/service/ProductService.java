package com.xiaxinyu.ordersystem.service;

import com.xiaxinyu.ordersystem.dataobject.ProductInfo;
import com.xiaxinyu.ordersystem.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductInfo findOne(String productId);

    //查询所有在架商品
    List<ProductInfo> findUpAll();

    //后台查询所有商品
    Page<ProductInfo> findAll(Pageable pageable);

    //新增 / 修改商品
    ProductInfo save(ProductInfo productInfo);

    //库存自增
    void increaseStock(List<CartDTO> cartDTOList);

    //库存自减
    void decreaseStock(List<CartDTO> cartDTOList);

}
