package com.xiaxinyu.ordersystem.controller.exception;

import com.xiaxinyu.ordersystem.enums.ResultEnum;

public class SellException extends RuntimeException{
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
