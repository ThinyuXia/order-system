package com.xiaxinyu.ordersystem.repository;

import com.xiaxinyu.ordersystem.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    //通过类目的编号来查找对应的类目
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
