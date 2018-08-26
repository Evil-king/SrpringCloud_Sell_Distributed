package com.hwq.product.server.server;

import com.hwq.product.server.ProductServerApplicationTests;
import com.hwq.product.server.dataobject.ProductInfo;
import com.hwq.product.server.dto.CarDTO;
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
public class ProductServerTest extends ProductServerApplicationTests {

    @Autowired
    private ProductServer productServer;

//    @Test
//    public void findUp() throws Exception {
//        List<ProductInfo> list = productServer.findUp();
//        Assert.assertTrue(list.size() > 0);
//    }
//
//    @Test
//    public void findByProductIdIn() throws Exception {
//        List<ProductInfo> list = productServer.findByProductIdIn(Arrays.asList("157875196366160022", "157875227953464068"));
//        Assert.assertTrue(list.size() > 0);
//    }
//
//    @Test
//    public void decreaseStock() throws Exception {
//        CarDTO carDTO = new CarDTO("157875196366160022", 2);
//        productServer.decreaseStock(Arrays.asList(carDTO));
//    }

}