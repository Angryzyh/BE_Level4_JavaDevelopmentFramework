package com.angryzyh.service.impl;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional //在测试类里面自动回滚 不保存数据
@Rollback(true) //默认回滚
public class TestServiceImpl {
}
