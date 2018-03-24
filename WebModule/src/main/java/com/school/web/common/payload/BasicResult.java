package com.school.web.common.payload;

public class BasicResult extends OperationResult {
    private Long id;

    public BasicResult() {
        this.id = 0L;
    }

    public BasicResult(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
