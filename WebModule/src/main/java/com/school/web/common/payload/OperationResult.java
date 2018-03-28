package com.school.web.common.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class OperationResult implements Serializable {
}
