package org.example.controller;

import org.example.model.QueryRequest;
import org.example.model.QueryResponse;
import org.example.service.QueryService;
import org.springframework.web.bind.annotation.*;

/**
 * 查询接口控制器
 * <p>
 * 提供 AI 查询相关的 REST API，基础路径为 /api。
 * 允许跨域请求，适用于前后端分离场景。
 * </p>
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class QueryController {

    private final QueryService queryService;

    /**
     * 构造函数，注入查询服务。
     *
     * @param queryService 查询业务逻辑服务
     */
    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    /**
     * 处理用户查询请求。
     * <p>
     * 接收用户输入的查询内容，调用 QueryService 获取响应结果。
     * </p>
     *
     * @param request 包含查询内容的请求体
     * @return 查询结果响应对象
     */
    @PostMapping("/query")
    public QueryResponse query(@RequestBody QueryRequest request) {
        return queryService.query(request.getQuery());
    }

    /**
     * 健康检查接口。
     * <p>
     * 用于确认服务是否正常运行。
     * </p>
     *
     * @return 固定返回 "ok"
     */
    @GetMapping("/health")
    public String health() {
        return "ok";
    }
}