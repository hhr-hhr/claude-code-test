package org.example.model;

import java.util.List;

public class QueryResponse {

    private boolean success;
    private String query;
    private int total;
    private long costMs;
    private List<ResultItem> results;
    private String message;

    public QueryResponse() {}

    public static QueryResponse ok(String query, List<ResultItem> results, long costMs) {
        QueryResponse r = new QueryResponse();
        r.success = true;
        r.query = query;
        r.results = results;
        r.total = results == null ? 0 : results.size();
        r.costMs = costMs;
        r.message = "查询成功";
        return r;
    }

    public static QueryResponse error(String query, String message) {
        QueryResponse r = new QueryResponse();
        r.success = false;
        r.query = query;
        r.message = message;
        r.total = 0;
        r.costMs = 0;
        return r;
    }

    // ---- getters ----

    public boolean isSuccess() { return success; }
    public String getQuery() { return query; }
    public int getTotal() { return total; }
    public long getCostMs() { return costMs; }
    public List<ResultItem> getResults() { return results; }
    public String getMessage() { return message; }

    // ---- inner class ----

    public static class ResultItem {
        private String id;
        private String title;
        private String description;
        private String tag;

        public ResultItem(String id, String title, String description, String tag) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.tag = tag;
        }

        public String getId() { return id; }
        public String getTitle() { return title; }
        public String getDescription() { return description; }
        public String getTag() { return tag; }
    }
}