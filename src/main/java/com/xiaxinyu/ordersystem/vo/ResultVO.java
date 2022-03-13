package com.xiaxinyu.ordersystem.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
//http请求返回的最外层对象--view object
public class ResultVO<T> {
    private Integer code; //错误码

    private String msg; //提示信息

    private T data; //具体内容
}
