package com.xiaxinyu.ordersystem.controller;

import com.xiaxinyu.ordersystem.converter.OrderFrom2OrderDTO;
import com.xiaxinyu.ordersystem.dto.OrderDTO;
import com.xiaxinyu.ordersystem.enums.ResultEnum;
import com.xiaxinyu.ordersystem.exception.SellException;
import com.xiaxinyu.ordersystem.form.OrderForm;
import com.xiaxinyu.ordersystem.service.BuyerService;
import com.xiaxinyu.ordersystem.service.OrderService;
import com.xiaxinyu.ordersystem.utils.ResultVOUtil;
import com.xiaxinyu.ordersystem.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    // 创建订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确，orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderFrom2OrderDTO.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);

        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());
        return ResultVOUtil.success(map);
    }
    // 订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size){
        if(StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest request = PageRequest.of(page,size);
        Page<OrderDTO> orderDTOPage =  orderService.findList(openid,request);



        return ResultVOUtil.success(orderDTOPage.getContent());
//        ResultVO resultVO = new ResultVO();
//        resultVO.setCode(0);
//        return resultVO;
    }

    // 订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                       @RequestParam("orderId") String orderId){

        OrderDTO orderDTO = buyerService.findOrderOne(openid,orderId);
        return ResultVOUtil.success(orderDTO);
    }

    // 取消订单
    @GetMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId){
        //TODO 不安全做法
        buyerService.findOrderOne(openid,orderId);
        return ResultVOUtil.success();
    }
}
