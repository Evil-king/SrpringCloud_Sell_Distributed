package com.hwq.order.server.dto;

import lombok.Data;

/**
 * @author hwq
 * @date 2018/08/09
 */
@Data
public class CarDTO {

    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CarDTO() {
    }

    public CarDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
