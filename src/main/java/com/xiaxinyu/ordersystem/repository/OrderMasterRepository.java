package com.xiaxinyu.ordersystem.repository;

import com.xiaxinyu.ordersystem.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);

}
