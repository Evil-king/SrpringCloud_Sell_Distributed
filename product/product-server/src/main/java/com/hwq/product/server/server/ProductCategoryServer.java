package com.hwq.product.server.server;

import com.hwq.product.server.dataobject.ProductCategory;

import java.util.List;

/**
 * @author hwq
 * @date 2018/08/03
 */
public interface ProductCategoryServer {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> productCategory);
}
