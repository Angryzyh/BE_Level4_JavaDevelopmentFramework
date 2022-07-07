package com.angryzyh;

import com.angryzyh.mapper.EmpMapper;
import com.angryzyh.model.Emp;
import com.angryzyh.model.EmpExample;
import com.angryzyh.utils.SqlSessionUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

//Query By Criteria 按照标准条件查询
public class TestQBC {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
    EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

    //测试QBC查询聚合函数操作
    @Test
    public void testBQC() {
        EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEmpSexEqualTo("男").andEmpAgeBetween(15, 40);
        long l = mapper.countByExample(empExample);
        System.out.println("l = " + l);
    }

    //测试QBC查询全部员工
    //再用分页插件pagehelper
    //  常用的几个属性或方法
    //- pageNum：当前页的页码
    //- pageSize：每页显示的条数
    //- size：当前页显示的真实条数
    //- total：总记录数
    //- pages：总页数
    //- prePage：上一页的页码
    //- nextPage：下一页的页码
    //- isFirstPage/isLastPage：是否为第一页/最后一页
    //- hasPreviousPage/hasNextPage：是否存在上一页/下一页
    //- navigatePages：导航分页的页码数
    //- navigatepageNums：导航分页的页码，\[1,2,3,4,5]

    /*显示查询到的数据在数据库中位置:===================================================
    显示总条数:total = 11
    显示起始行:startRow = 7
    显示结束行:endRow = 9
    ==============================================================================
    当前页面操作方法:================================================================
    显示当前页面的实际数据条数:size = 3
    显示每页显示的数据条数:pageSize = 3
    显示总页数:pages = 4
    获取当前页面的页码:pageNum = 3
    判断是否为第一页:isFirstPage = false
    判断是否为最后一页:isLastPage = false
    判断是否有上一页:hasPreviousPage = true
    获取上一页页码:prePage = 2
    判断是否有下一页:hasNextPage = true
    获取下一页页码:nextPage = 4
    ==============================================================================
    前端页面导航栏操作方法:============================================================
    获取当前导航栏的第一页:navigateFirstPage = 1
    获取当前导航栏的最后一页:navigateLastPage = 4
    获取导航栏展示出的页面数量:navigatePages = 5
    获取当前导航栏的页码数组:navigatepageNums = [1, 2, 3, 4]
    ==============================================================================
    * */
    @Test
    public void testQBC2() {
        List<Emp> emps = mapper.selectByExample(null);
        emps.forEach(System.out::println);
        System.out.println("============================================================================================");
        //开启分页插件,显示当前页,以及每页几条数据
        PageHelper.startPage(3, 3);
        //查询要分页的数据
        List<Emp> emps1 = mapper.selectByExample(null);
        //分页导航,传入集合,前端页面显示5个可以跳转的预览页面按钮
        PageInfo<Emp> empPageInfo = new PageInfo<>(emps1, 5);
        //输出分页empPageInfo对象信息
        System.out.println("==============================================================================");
        System.out.println("empPageInfo对象封装的全部信息:empPageInfo = " + empPageInfo);
        System.out.println("==============================================================================");
        System.out.println("显示当前分页页面的全部数据信息:==============================================================================");
        /*显示当前分页页面的全部用户信息*/
        List<Emp> list = empPageInfo.getList();
        list.forEach(System.out::println);

        System.out.println("==============================================================================");
        System.out.println("显示查询到的数据在数据库中位置:==============================================================================");
        /*显示查询到的数据在数据库中位置*/
        long total = empPageInfo.getTotal();
        System.out.println("显示总条数:total = " + total);
        long startRow = empPageInfo.getStartRow();
        System.out.println("显示起始行:startRow = " + startRow);
        long endRow = empPageInfo.getEndRow();
        System.out.println("显示结束行:endRow = " + endRow);

        System.out.println("==============================================================================");
        System.out.println("当前页面操作方法:==============================================================================");
        /*页面操作方法*/
        int size = empPageInfo.getSize();
        System.out.println("显示当前页面的实际数据条数:size = " + size);
        int pageSize = empPageInfo.getPageSize();
        System.out.println("显示每页显示的数据条数:pageSize = " + pageSize);
        int pages = empPageInfo.getPages();
        System.out.println("显示总页数:pages = " + pages);
        int pageNum = empPageInfo.getPageNum();
        System.out.println("获取当前页面的页码:pageNum = " + pageNum);
        boolean isFirstPage = empPageInfo.isIsFirstPage();
        System.out.println("判断是否为第一页:isFirstPage = " + isFirstPage);
        boolean isLastPage = empPageInfo.isIsLastPage();
        System.out.println("判断是否为最后一页:isLastPage = " + isLastPage);
        boolean hasPreviousPage = empPageInfo.isHasPreviousPage();
        System.out.println("判断是否有上一页:hasPreviousPage = " + hasPreviousPage);
        int prePage = empPageInfo.getPrePage();
        System.out.println("获取上一页页码:prePage = " + prePage);
        boolean hasNextPage = empPageInfo.isHasNextPage();
        System.out.println("判断是否有下一页:hasNextPage = " + hasNextPage);
        int nextPage = empPageInfo.getNextPage();
        System.out.println("获取下一页页码:nextPage = " + nextPage);

        System.out.println("==============================================================================");
        System.out.println("前端页面导航栏操作方法:==============================================================================");
        /*前端页面导航栏操作方法*/
        int navigateFirstPage = empPageInfo.getNavigateFirstPage();
        System.out.println("获取当前导航栏的第一页:navigateFirstPage = " + navigateFirstPage);
        int navigateLastPage = empPageInfo.getNavigateLastPage();
        System.out.println("获取当前导航栏的最后一页:navigateLastPage = " + navigateLastPage);
        int navigatePages = empPageInfo.getNavigatePages();
        System.out.println("获取导航栏展示出的页面数量:navigatePages = " + navigatePages);
        int[] navigatepageNums = empPageInfo.getNavigatepageNums();
        System.out.println("获取当前导航栏的页码数组:navigatepageNums = " + Arrays.toString(navigatepageNums));
        System.out.println("==============================================================================");
    }
}
