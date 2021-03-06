package com.cestc.vspace.service.impl;

import com.cestc.vspace.dto.Condition;
import com.cestc.vspace.dto.PageResult;
import com.cestc.vspace.pojo.ClothesWithBLOBS;
import com.cestc.vspace.service.SearchService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhong
 * @Edition: V1.0
 * CreateDate: 2021/7/15 10:45
 * Description:
 */

@Service
public class SearchServiceImp implements SearchService {
    //通过springIOC容器自动装配一个solrClient对象
    //集群环境下使用该对象
//    @Autowired
//    private CloudSolrClient cloudSolrClient;

    @Autowired
    private SolrClient solrClient;

    @Override
    public PageResult searchPageTest(Condition condition) {
        SolrQuery query = new SolrQuery();
        System.out.println("Solr establish");
        query.set("q","cloth_keywords:" + condition.getSearchString() + "");
        System.out.println("keywords set");
        query.addFilterQuery("cloth_price:[" + condition.getMinPrice() + " TO " + condition.getMaxPrice() + "]");
        System.out.println("price set");

        PageResult pageResult = new PageResult();
        pageResult.setPages(condition.getPageSize());
        return pageResult;
    }
    //在搜索服务中注入服装服务模块clothesService,通过调用服装服务模块的方法从数据库查询到商品信息,
    //然后通过search-service中的addSolrDoc(List list)将数据写入到solr索引库中,
    //此时search-service即是服务的提供者也是消费者
    @Override
    public PageResult searchPage(Condition condition) {
        //设置默认的集合: 集群环境下设置
        //cloudSolrClient.setDefaultCollection("collection-vspace");
        //创建一个查询对象
        SolrQuery query = new SolrQuery();
        //通过查询对象设置查询条件
        //备注: 此处getSeachString()获取到的搜索字符串会被ik分词器拆分之后再进行搜索
        query.set("q","cloth_keywords:" + condition.getSearchString() + "");
        //设置fq多条件过滤查询: 多条件之间使用and | or 关键字连接
//        if (condition.getCategoryIdList() != null) {
//            String categoryIdCondition = "(";
//            for (Integer integer : condition.getCategoryIdList()) {
//                categoryIdCondition += integer + " ";
//            }
//            categoryIdCondition = categoryIdCondition.substring(0,categoryIdCondition.length() - 1);
//            categoryIdCondition += ")";
//            //设置根据类型查询的查询条件
//            query.setFilterQueries("goods_category_id:" + categoryIdCondition);
//        }

        //添加商品价格过滤
        query.addFilterQuery("cloth_price:[" + condition.getMinPrice() + " TO " + condition.getMaxPrice() + "]");

        //设置分页相关参数
        //①: 设置偏移量
        query.setStart((condition.getPageNo() - 1) * condition.getPageSize());
        //②: 设置每页显示条数
        query.setRows(condition.getPageSize());

        //设置回显的字段(也就是查询哪些字段进行前端展示)
        query.setFields("cloth_id","cloth_name","cloth_price");

        //排序设置: 本案例设置按照价格升序排列,再按照编号升序(相同价格的情况)
        query.addSort("cloth_price", SolrQuery.ORDER.asc);
        query.addSort("cloth_id", ORDER.asc);

        //设置查询高亮结果显示
        //①: 打开高亮
        query.setHighlight(true);
        //②: 设置高亮显示的字段
        query.addHighlightField("cloth_name");
        //③: 设置高亮前缀
        query.setHighlightSimplePre("<font color='red'>");
        //④: 设置高亮后缀
        query.setHighlightSimplePost("</font>");


        System.out.println("solr查询语句是: " + query.getQuery());
        System.out.println("solr过滤查询语句是: " + Arrays.toString(query.getFilterQueries()));

        //执行查询命令得到查询结果
        List<ClothesWithBLOBS> clothesList = null;
        long totalItems = 0;
        int pages = 0;
        try {
            QueryResponse queryResponse = solrClient.query(query);
            //将查询结果映射成实体集合(注意该实体属性需要通过solr提供的@Field进行注解)
            clothesList = queryResponse.getBeans(ClothesWithBLOBS.class);
            //获取数据总记录数
            SolrDocumentList results = queryResponse.getResults();
            totalItems = results.getNumFound();
            /*特别注意: 查询数据结果和高亮结果是分开的*/
            //判断如果查询关键字不是*号,则查询高亮显示
            if (!condition.getSearchString().equals("*")) {
                //获取高亮结果(该结果为所有高亮信息的集合)
                Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
                if (highlighting != null) {
                    //将高亮结果循环绑定给返回结果集合
                    for (ClothesWithBLOBS goods : clothesList) {
                        //根据商品编号获取高集合(该集合的长度由指定的高亮字段的数量决定)
                        //注意key是String类型,goodsId是Long类型,通过拼接转化成String(否则获取不了数据)
                        Map<String, List<String>> highMap = highlighting.get(goods.getCid() + "");
                        if (highMap != null) {
                            if (highMap.get("cloth_name") != null) {
                                goods.setCname(highMap.get("cloth_name").get(0));
                            }
                        }
                    }
                }
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //根据总记录数 和 每页显示记录数据计算总页数
        if (totalItems % condition.getPageSize() == 0) {
            pages = (int)(totalItems / condition.getPageSize());
        }else{
            pages = (int)(totalItems / condition.getPageSize()) + 1;
        }
        //创建一个PageResult对象返回给调用者
        PageResult pageResult = new PageResult();
        pageResult.setPages(pages);
        pageResult.setTotalItems(totalItems);
        pageResult.setDataList(clothesList);
        return pageResult;
    }

    @Override
    public void addSolrDoc(List list) {
        try {
            UpdateResponse updateResponse = solrClient.addBeans(list);
            //如果没有异常则提交事务
            solrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSolrDoc(Condition condition) {

    }

}

