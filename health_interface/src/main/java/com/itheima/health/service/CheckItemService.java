package com.itheima.health.service;

import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.QueryPageBean;
import com.itheima.health.pojo.CheckItem;

/**
 * @Author likepei
 * @Date 2020/3/26 21:47
 * @Version v1.0
 * @Description 检查项业务接口
 */
public interface CheckItemService {

    /**
     * 分页查询
     * @param queryPageBean 中有三个属性
     * 属性一 currentPage: 当前页码
     * 属性二 pageSize: 每页显示记录数
     * 属性三 queryString: 查询条件
     */
    PageResult pageQuery(QueryPageBean queryPageBean);

    /**
     * 添加检查项
     * @param checkItem
     */
    void add(CheckItem checkItem);
}
