package com.hwq.product.server.dto;

import lombok.Data;

/**
 * @author hwq
 * @date 2018/08/09
 */
@Data
public class CarDTO {

    private  String productId;

    private Integer productQuantity;

    public CarDTO() {
    }

    public CarDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
