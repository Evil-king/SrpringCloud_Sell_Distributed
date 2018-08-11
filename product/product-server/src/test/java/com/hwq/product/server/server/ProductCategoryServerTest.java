package com.hwq.product.server.server;

import com.hwq.product.server.dataobject.ProductCategory;
import com.hwq.product.server.repository.ProductCategoryRepository;
import com.hwq.product.server.repository.ProductCategoryRepositoryTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


/**
 * @author hwq
 * @date 2018/08/03
 */
@Component
public class ProductCategoryServerTest extends ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> list =  productCategoryRepository.findByCategoryTypeIn(Arrays.asList(1,22));
        Assert.assertTrue(list.size() > 0);
    }

}