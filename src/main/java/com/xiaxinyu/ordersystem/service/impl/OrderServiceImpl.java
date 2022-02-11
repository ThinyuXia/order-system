package com.xiaxinyu.ordersystem.service.impl;

import com.xiaxinyu.ordersystem.controller.exception.SellException;
import com.xiaxinyu.ordersystem.dataobject.OrderDetail;
import com.xiaxinyu.ordersystem.dataobject.OrderMaster;
import com.xiaxinyu.ordersystem.dataobject.ProductInfo;
import com.xiaxinyu.ordersystem.dto.CartDTO;
import com.xiaxinyu.ordersystem.dto.OrderDTO;
import com.xiaxinyu.ordersystem.enums.OrderStatusEnum;
import com.xiaxinyu.ordersystem.enums.PayStatusEnum;
import com.xiaxinyu.ordersystem.enums.ResultEnum;
import com.xiaxinyu.ordersystem.repository.OrderDetailRepository;
import com.xiaxinyu.ordersystem.repository.OrderMasterRepository;
import com.xiaxinyu.ordersystem.service.OrderService;
import com.xiaxinyu.ordersystem.service.ProductService;
import com.xiaxinyu.ordersystem.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        String orderId = KeyUtil.genUniqueKey();

        //1.查询商品(数量,价格)
        for(OrderDetail orderDetail : orderDTO.getOrderDetailList()){
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if(productInfo == null)
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);

            //2.计算订单总价
            orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount);

            //订单详情入库
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetailRepository.save(orderDetail);

        }


        //3.写入订单数据库(orderMaster)
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);

        //4.库存减少
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(), e.getProductQuantity())
        ).collect(Collectors.toList());

        productService.decreaseStock(cartDTOList);

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
