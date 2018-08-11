package com.hwq.product.server.enums;


import lombok.Getter;

/**
 * @author hwq
 * @date 2018/08/03
 */
@Getter
public enum ProductStatusEnum {

    UP(0,"上架"),
    DOWN(1,"下架")
    ;

    private Integer code;

    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
