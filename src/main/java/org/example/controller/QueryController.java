package org.example.controller;

import org.example.model.QueryRequest;
import org.example.model.QueryResponse;
import org.example.service.QueryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class QueryController {

    private final QueryService queryService;

    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    @PostMapping("/query")
    public QueryResponse query(@RequestBody QueryRequest request) {
        return queryService.query(request.getQuery());
    }

    @GetMapping("/health")
    public String health() {
        return "ok";
    }
}