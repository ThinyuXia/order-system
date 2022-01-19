package com.xiaxinyu.ordersystem.repository;

import com.xiaxinyu.ordersystem.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
}
