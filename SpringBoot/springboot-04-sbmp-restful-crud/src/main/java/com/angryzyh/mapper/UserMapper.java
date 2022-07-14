package com.angryzyh.mapper;

import com.angryzyh.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author Angryzyh
* @description 针对表【sbmp_mybatisplus_user】的数据库操作Mapper
* @createDate 2022-07-10 16:55:02
* @Entity com.angryzyh.model.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

}




