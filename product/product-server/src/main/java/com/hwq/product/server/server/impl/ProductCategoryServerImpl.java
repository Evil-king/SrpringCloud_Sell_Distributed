package com.hwq.product.server.server.impl;

import com.hwq.product.server.dataobject.ProductCategory;
import com.hwq.product.server.repository.ProductCategoryRepository;
import com.hwq.product.server.server.ProductCategoryServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hwq
 * @date 2018/08/03
 */
@Service
public class ProductCategoryServerImpl implements ProductCategoryServer {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> productCategory) {

        return productCategoryRepository.findByCategoryTypeIn(productCategory);
    }
}
