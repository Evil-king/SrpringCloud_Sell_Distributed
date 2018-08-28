package com.hwq.order.server.service;


import com.hwq.order.server.dto.OrderDTO;

/**
 * @author hwq
 * @date 2018/08/05
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);


    /**
     * 完结订单(只能卖家操作)
     * @param orderId
     * @return
     */
    OrderDTO finish(String orderId);
}
