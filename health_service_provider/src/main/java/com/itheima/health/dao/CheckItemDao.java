package com.itheima.health.dao;

import com.github.pagehelper.Page;
import com.itheima.health.pojo.CheckItem;
import org.apache.ibatis.annotations.Param;

/**
 * @Author likepei
 * @Date 2020/3/26 21:56
 * @Version v1.0
 * @Description 检查项的持久层接口
 */
public interface CheckItemDao {

    /**
     * 基于分页插件进行分页查询
     * @param queryString
     * @return
     */
    public Page<CheckItem> selectByCondition(@Param("queryString") String queryString);

    /**
     * 添加检查项
     * @param checkItem
     */
    void add(CheckItem checkItem);
}
