package com.angryzyh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.angryzyh.model.Product;
import com.angryzyh.service.ProductService;
import com.angryzyh.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
* @author Angryzyh
* @description 针对表【sbmp_mybatisplus_product】的数据库操作Service实现
* @createDate 2022-07-10 22:13:18
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

}




