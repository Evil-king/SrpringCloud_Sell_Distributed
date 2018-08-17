package com.hwq.order.server.controller;

import com.hwq.product.client.ProductClient;
import com.hwq.product.common.DecreaseStockInput;
import com.hwq.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author hwq
 * @date 2018/08/05
 */
@RestController
@Slf4j
public class ClientController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProdunt")
    public String getProduntMsg() {
        String result = productClient.productMsg();
        log.info("result={}", result);
        return result;
    }

    @GetMapping("/getProduntList")
    public String getProduntList() {
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(Arrays.asList("164103465734242707"));
        log.info("productInfoList={}", productInfoList);
        return "Ok";
    }

    @GetMapping("/productDecreaseStock")
    public String productDeceaseStock() {
        productClient.decreaseStock(Arrays.asList(new DecreaseStockInput("164103465734242707", 3)));
        return "Ok";
    }
}
