package com.angryzyh.lock;

import com.angryzyh.mapper.ProductMapper;
import com.angryzyh.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestOptimisticLock {
    @Autowired
    private ProductMapper productMapper;

    //模拟冲突，脏读
    @Test
    public void test01() {
        Product product1 = productMapper.selectById(1);
        System.out.println("第一个人查询的结果 = " + product1.getPrice());
        Product product2 = productMapper.selectById(1);
        System.out.println("第二个人查询的结果 = " + product2.getPrice());
        //第一个人将商品价格加50
        product1.setPrice(product1.getPrice() + 50);
        productMapper.updateById(product1);
        //第二个人将商品价格减30
        product2.setPrice(product2.getPrice() - 30);
        productMapper.updateById(product2);
        //老板查询结果
        Product product3 = productMapper.selectById(1);
        System.out.println("老板查询结果 = " + product3.getPrice());
        //最终结果70
        /*
        * 实体类添加@Version注解后
        * MybatisPlusInterceptor添加乐观锁插件后
        * */
        //添加乐观锁后结果150,因为没有自旋,所以不是120
    }

    //优化 自旋版本
    @Test
    public void test02() {
        Product product1 = productMapper.selectById(1);
        System.out.println("第一个人查询的结果 = " + product1.getPrice());
        Product product2 = productMapper.selectById(1);
        System.out.println("第二个人查询的结果 = " + product2.getPrice());
        //第一个人将商品价格加50
        product1.setPrice(product1.getPrice() + 50);
        productMapper.updateById(product1);
        //第二个人将商品价格减30
        product2.setPrice(product2.getPrice() - 30);
        int result = productMapper.updateById(product2);
        if (result == 0) {
            //操作失败,重新操作
            Product productNew = productMapper.selectById(1);
            productNew.setPrice(productNew.getPrice()-30);
            productMapper.updateById(productNew);
        }
        //老板查询结果
        Product product3 = productMapper.selectById(1);
        System.out.println("老板查询结果 = " + product3.getPrice());
    }


}
