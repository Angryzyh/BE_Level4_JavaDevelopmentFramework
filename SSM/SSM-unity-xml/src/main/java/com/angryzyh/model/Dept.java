package com.angryzyh.model;

public class Dept {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_mybatis_department.dept_id
     *
     * @mbg.generated Thu Jul 07 16:58:50 CST 2022
     */
    private Integer deptId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ssm_mybatis_department.dept_name
     *
     * @mbg.generated Thu Jul 07 16:58:50 CST 2022
     */
    private String deptName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_mybatis_department.dept_id
     *
     * @return the value of ssm_mybatis_department.dept_id
     *
     * @mbg.generated Thu Jul 07 16:58:50 CST 2022
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_mybatis_department.dept_id
     *
     * @param deptId the value for ssm_mybatis_department.dept_id
     *
     * @mbg.generated Thu Jul 07 16:58:50 CST 2022
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ssm_mybatis_department.dept_name
     *
     * @return the value of ssm_mybatis_department.dept_name
     *
     * @mbg.generated Thu Jul 07 16:58:50 CST 2022
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ssm_mybatis_department.dept_name
     *
     * @param deptName the value for ssm_mybatis_department.dept_name
     *
     * @mbg.generated Thu Jul 07 16:58:50 CST 2022
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }
}