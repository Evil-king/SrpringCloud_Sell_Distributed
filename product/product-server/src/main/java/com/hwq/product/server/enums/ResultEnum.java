package com.hwq.product.server.enums;

import lombok.Getter;

/**
 * @author hwq
 * @date 2018/08/09
 */
@Getter
public enum ResultEnum {

    PRODUCT_BIT_EXIT(1,"商品不存在"),
    PRODUCT_STOCK_ERROP(2,"库存有误"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
