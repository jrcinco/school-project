package com.school.web.common.payload;

import com.school.web.validation.ValidationDetail;
import java.util.List;

public class DetailError extends OperationError {
    private List<ValidationDetail> details;

    public DetailError(String code, String message, List<ValidationDetail> details) {
        super(code, message);
        this.details = details;   
    }

    public List<ValidationDetail> getDetails() {
        return this.details;
    }

    public void setDetails(List<ValidationDetail> details) {
        this.details = details;
    }
}
