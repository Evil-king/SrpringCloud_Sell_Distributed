package com.hwq.order.server.repository;


import com.hwq.order.server.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author hwq
 * @date 2018/08/05
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
