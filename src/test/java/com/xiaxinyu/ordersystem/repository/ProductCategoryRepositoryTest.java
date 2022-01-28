package com.xiaxinyu.ordersystem.repository;

import com.xiaxinyu.ordersystem.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.getById(1);
        System.out.println(productCategory.toString());
    }

//    @Test
//    public void saveTest(){
//        ProductCategory productCategory = new ProductCategory("女生最爱",12);
//        ProductCategory result = repository.save(productCategory);
//        Assert.assertNotNull(result);
//    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(2,4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
        System.out.println(result.size());
    }
}