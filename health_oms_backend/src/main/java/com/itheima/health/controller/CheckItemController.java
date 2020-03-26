package com.itheima.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.QueryPageBean;
import com.itheima.health.service.CheckItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author likepei
 * @Date 2020/3/26 21:41
 * @Version v1.0
 * @Description 检查项业务控制器
 */
@RestController
@RequestMapping("/checkitem")
@Slf4j
public class CheckItemController {

    //依赖注入
    @Reference
    private CheckItemService checkItemService;

    /**
     * 查询分页数据
     * 1.调用Service获取分页结果数据
     * 2.成功，直接返回有内容的结果
     * 3.失败，返回初始化结果，记录为0，数据为空
     *
     * @param queryPageBean 页面传过来的数据( 当前页, 每条记录数, 查询条件)
     * @return 分页数据( 总记录数, 当前页要显示的10个检查项的集合对象)
     */
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        //日志打印
        log.debug("queryPageBean ===currentPage:{}===pageSize:{}====queryString:{}", queryPageBean.getCurrentPage(), queryPageBean.getPageSize(), queryPageBean.getQueryString());

        try {
            //调用Service获取分页结果数据
            PageResult pageResult = checkItemService.pageQuery(queryPageBean);
            //成功，直接返回有内容的结果
            return pageResult;
        } catch (Exception e) {
            e.printStackTrace();
            //失败，返回初始化结果，记录为0，数据为空
            return new PageResult(0L, null);
        }
    }
}
