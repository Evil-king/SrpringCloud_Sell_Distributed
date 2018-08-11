package com.hwq.product.common;

import lombok.Data;

/**
 * 减库存入参
 * @author hwq
 * @date 2018/08/02
 */
@Data
public class DecreaseStockInput {

    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}