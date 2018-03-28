package com.school.web.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentDetailDto {
    @NotNull(message = "ST001")
    @Size(min = 2, max = 50, message = "ST002")
    @ApiModelProperty(required = true, notes = "Size(min = 2, max = 50)")
    private String name;
    @NotNull(message = "ST003")
    @Size(min = 1, max = 1, message = "ST004")
    @ApiModelProperty(required = true, notes = "Size(min = 1, max = 1)")
    private String gender;
    @NotNull(message = "ST005")
    @Size(min = 2, max = 20, message = "ST006")
    @ApiModelProperty(required = true, notes = "Size(min = 2, max = 20)")
    private String type;
    @NotNull(message = "ST007")
    @Size(min = 14, max = 20, message = "ST008")
    @ApiModelProperty(required = true, notes = "Size(min = 14, max = 20)")
    private String timestamp;
    
    public StudentDetailDto() {}

    public StudentDetailDto(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "StudentDetailDto{" + "name=" + name 
                + ", gender=" + gender 
                + ", type=" + type 
                + ", timestamp=" + timestamp + '}';
    }
}
