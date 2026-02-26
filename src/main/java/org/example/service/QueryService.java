package org.example.service;

import org.example.model.QueryResponse;
import org.example.model.QueryResponse.ResultItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class QueryService {

    // 模拟数据库
    private static final List<ResultItem> DATA_SOURCE = Arrays.asList(
            new ResultItem("U001", "张三", "部门：研发中心 | 职位：高级工程师 | 状态：在职", "用户"),
            new ResultItem("U002", "李四", "部门：产品部 | 职位：产品经理 | 状态：在职", "用户"),
            new ResultItem("U003", "王五", "部门：运营部 | 职位：运营专员 | 状态：离职", "用户"),
            new ResultItem("O001", "订单 #20240101", "商品：MacBook Pro | 金额：¥18,999 | 状态：已完成", "订单"),
            new ResultItem("O002", "订单 #20240215", "商品：iPhone 15 | 金额：¥6,999 | 状态：待发货", "订单"),
            new ResultItem("O003", "订单 #20240320", "商品：iPad Air | 金额：¥4,799 | 状态：已取消", "订单"),
            new ResultItem("P001", "Spring Boot 实战", "作者：丁雪丰 | 分类：技术 | 库存：52 本", "商品"),
            new ResultItem("P002", "Redis 设计与实现", "作者：黄健宏 | 分类：技术 | 库存：18 本", "商品"),
            new ResultItem("P003", "深入理解 Java 虚拟机", "作者：周志明 | 分类：技术 | 库存：30 本", "商品"),
            new ResultItem("L001", "系统登录", "IP：192.168.1.100 | 时间：2024-03-01 09:00 | 结果：成功", "日志"),
            new ResultItem("L002", "数据导出", "IP：192.168.1.101 | 时间：2024-03-01 10:30 | 结果：成功", "日志"),
            new ResultItem("L003", "权限变更", "IP：192.168.1.102 | 时间：2024-03-01 14:00 | 结果：失败", "日志")
    );

    public QueryResponse query(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return QueryResponse.error("", "查询关键词不能为空");
        }

        long start = System.currentTimeMillis();

        String kw = keyword.trim().toLowerCase();
        List<ResultItem> matched = new ArrayList<>();

        for (ResultItem item : DATA_SOURCE) {
            if (item.getTitle().toLowerCase().contains(kw)
                    || item.getDescription().toLowerCase().contains(kw)
                    || item.getTag().toLowerCase().contains(kw)
                    || item.getId().toLowerCase().contains(kw)) {
                matched.add(item);
            }
        }

        long cost = System.currentTimeMillis() - start;
        return QueryResponse.ok(keyword, matched, cost);
    }
}