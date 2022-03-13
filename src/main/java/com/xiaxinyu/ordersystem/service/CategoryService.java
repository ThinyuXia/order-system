package com.xiaxinyu.ordersystem.service;

import com.xiaxinyu.ordersystem.dataobject.ProductCategory;
import java.util.*;

public interface CategoryService {
    ProductCategory findOne(Integer categoryId);
    // 用于后台管理查询所有类目
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    // 新增/更新类目
    ProductCategory save(ProductCategory productCategory);

}
