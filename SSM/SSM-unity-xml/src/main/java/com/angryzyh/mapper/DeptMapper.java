package com.angryzyh.mapper;

import com.angryzyh.model.Dept;
import com.angryzyh.model.DeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssm_mybatis_department
     *
     * @mbg.generated Thu Jul 07 16:58:50 CST 2022
     */
    long countByExample(DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssm_mybatis_department
     *
     * @mbg.generated Thu Jul 07 16:58:50 CST 2022
     */
    int deleteByExample(DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssm_mybatis_department
     *
     * @mbg.generated Thu Jul 07 16:58:50 CST 2022
     */
    int deleteByPrimaryKey(Integer deptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssm_mybatis_department
     *
     * @mbg.generated Thu Jul 07 16:58:50 CST 2022
     */
    int insert(Dept row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssm_mybatis_department
     *
     * @mbg.generated Thu Jul 07 16:58:50 CST 2022
     */
    int insertSelective(Dept row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssm_mybatis_department
     *
     * @mbg.generated Thu Jul 07 16:58:50 CST 2022
     */
    List<Dept> selectByExample(DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssm_mybatis_department
     *
     * @mbg.generated Thu Jul 07 16:58:50 CST 2022
     */
    Dept selectByPrimaryKey(Integer deptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssm_mybatis_department
     *
     * @mbg.generated Thu Jul 07 16:58:50 CST 2022
     */
    int updateByExampleSelective(@Param("row") Dept row, @Param("example") DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssm_mybatis_department
     *
     * @mbg.generated Thu Jul 07 16:58:50 CST 2022
     */
    int updateByExample(@Param("row") Dept row, @Param("example") DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssm_mybatis_department
     *
     * @mbg.generated Thu Jul 07 16:58:50 CST 2022
     */
    int updateByPrimaryKeySelective(Dept row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssm_mybatis_department
     *
     * @mbg.generated Thu Jul 07 16:58:50 CST 2022
     */
    int updateByPrimaryKey(Dept row);
}