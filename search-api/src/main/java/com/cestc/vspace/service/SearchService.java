package com.cestc.vspace.service;

import com.cestc.vspace.dto.Condition;
import com.cestc.vspace.dto.PageResult;
import java.util.List;

/**
 * @Author: zhong
 * @Edition: V1.0
 * CreateDate: 2021/7/15 9:22
 * Description:  搜索服务
 */

public interface SearchService {
    //创建方法: 按关键字搜索[并分页][排序]显示
    //①: 将关键字、分页信息、查询条件等信息都封装到Condition中
    //②: 将查询结果封装到PageResult实体中
    PageResult searchPage(Condition condition);
    PageResult searchPageTest(Condition condition);
    //将集合数据写入sorl索引库(修改相同: 如果存在就修改,如果不存在就增加)
    void addSolrDoc(List list);
    //根据条件删除sorl索引库数据
    void deleteSolrDoc(Condition condition);
}
