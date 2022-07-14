package com.angryzyh.mapper;

import com.angryzyh.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * User mapper类释义
 *
 * @author Angryzyh
 * @since 2022 -07-09 21:28:24
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * Select my page 函数释义. 自定义分页
     *
     * @param page MP自带page对象,必须第一个c位
     * @param age  sql 根据 年龄查询
     * @return {@link Page} 返回查询后的page对象,里面封装了查询的结果和分页结果
     * @author Angryzyh
     * @since 2022 -07-09 21:28:24
     */
    Page<User> selectMyPage(@Param("page") Page<User> page ,@Param("age") Integer age);
}
