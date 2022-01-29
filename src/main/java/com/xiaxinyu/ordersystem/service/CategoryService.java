package com.xiaxinyu.ordersystem.service;

import com.xiaxinyu.ordersystem.dataobject.ProductCategory;
import java.util.*;

public interface CategoryService {
    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    ProductCategory save(ProductCategory productCategory);

}
