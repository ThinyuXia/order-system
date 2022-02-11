package com.xiaxinyu.ordersystem.service.impl;

import com.xiaxinyu.ordersystem.controller.exception.SellException;
import com.xiaxinyu.ordersystem.dataobject.ProductInfo;
import com.xiaxinyu.ordersystem.dto.CartDTO;
import com.xiaxinyu.ordersystem.enums.ProductStatusEnum;
import com.xiaxinyu.ordersystem.enums.ResultEnum;
import com.xiaxinyu.ordersystem.repository.ProductInfoRepository;
import com.xiaxinyu.ordersystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.getById(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO : cartDTOList){
            ProductInfo productInfo = repository.getById(cartDTO.getProductId());
            if(productInfo == null)
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if(result < 0)
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);

            System.out.println(result);
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }
}
