package com.itheima.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.health.dao.CheckItemDao;
import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.QueryPageBean;
import com.itheima.health.pojo.CheckItem;
import com.itheima.health.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author likepei
 * @Date 2020/3/26 21:53
 * @Version v1.0
 * @Description 检查项业务接口实现类
 */
@Transactional
@Service
public class CheckItemServiceImpl implements CheckItemService {

    //依赖注入
    @Autowired
    private CheckItemDao checkItemDao;

    //分页查询
    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {

        /**
         * 使用分页插件PageHelper
         * 参数1: 起始页 1
         * 参数2: 每页数量 10
         */
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        //调用dao, 获取检查项数据
        Page<CheckItem> page = checkItemDao.selectByCondition(queryPageBean.getQueryString());
        //创建PageResult结果对象( 检查项的总记录数, 当前页显示需要的10条检查项数据 )
        return new PageResult(page.getTotal(), page.getResult());
    }

    //添加检查项
    @Override
    public void add(CheckItem checkItem) {
        //调用dao中, 添加检查项方法
        checkItemDao.add(checkItem);
    }
}
