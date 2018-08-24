package com.hwq.product.server.server.impl;

import com.hwq.product.server.dataobject.ProductInfo;
import com.hwq.product.server.dto.CarDTO;
import com.hwq.product.server.enums.ProductStatusEnum;
import com.hwq.product.server.enums.ResultEnum;
import com.hwq.product.server.exception.ProductException;
import com.hwq.product.server.repository.ProductInfoRepository;
import com.hwq.product.server.server.ProductServer;
import com.hwq.product.server.utils.JsonUtil;
import com.rabbitmq.tools.json.JSONUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author hwq
 * @date 2018/08/03
 */
@Service
public class ProductServerImpl implements ProductServer {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfo> findUp() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findByProductIdIn(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CarDTO> carDTOList) {
        for (CarDTO carDTO : carDTOList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(carDTO.getProductId());
            //判断商品是否存在
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_BIT_EXIT);
            }

            ProductInfo productInfo = productInfoOptional.get();
            //库存是否足够
            Integer result = productInfo.getProductStock() - carDTO.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROP);
            }

            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);

            //发送队列消息
            amqpTemplate.convertAndSend("productInfo",JsonUtil.toJson(productInfo));
        }
    }
}
