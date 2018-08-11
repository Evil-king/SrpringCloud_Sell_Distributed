package com.hwq.product.server.server;

import com.hwq.product.server.dataobject.ProductInfo;
import com.hwq.product.server.dto.CarDTO;

import java.util.List;

/**
 * @author hwq
 * @date 2018/08/03
 */
public interface ProductServer {

    /**
     * 查询所有在架商品
     */

    List<ProductInfo> findUp();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfo> findByProductIdIn(List<String> productIdList);

    /**
     * 扣库存
     * @param carDTOList
     */
    void decreaseStock(List<CarDTO> carDTOList);

}
