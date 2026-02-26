# claude-test

基于 Spring Boot 的关键词查询演示项目，提供 REST API 接口，支持对模拟数据（用户、订单、商品、日志）进行关键词检索。

## 技术栈

- Java 8
- Spring Boot 2.7.18
- Maven

## 项目结构

```
src/main/java/org/example/
├── Application.java          # 启动类
├── controller/
│   └── QueryController.java  # REST 接口层
├── service/
│   └── QueryService.java     # 业务逻辑层（含模拟数据）
└── model/
    ├── QueryRequest.java     # 请求模型
    └── QueryResponse.java    # 响应模型
src/main/resources/
├── application.properties    # 应用配置
└── static/index.html         # 前端页面
```

## 快速启动

```bash
mvn spring-boot:run
```

服务启动后访问：`http://localhost:8080`

## API 接口

### 查询

**POST** `/api/query`

请求体：
```json
{
  "query": "张三"
}
```

响应示例：
```json
{
  "keyword": "张三",
  "results": [
    {
      "id": "U001",
      "title": "张三",
      "description": "部门：研发中心 | 职位：高级工程师 | 状态：在职",
      "tag": "用户"
    }
  ],
  "total": 1,
  "cost": 2
}
```

### 健康检查

**GET** `/api/health`

响应：`ok`

## 数据说明

系统内置以下模拟数据，支持按 ID、标题、描述、标签进行关键词匹配：

| 类型 | 数据条数 | 示例关键词 |
|------|----------|------------|
| 用户 | 3 条 | 张三、研发中心、离职 |
| 订单 | 3 条 | MacBook、待发货 |
| 商品 | 3 条 | Spring Boot、Redis |
| 日志 | 3 条 | 系统登录、权限变更 |