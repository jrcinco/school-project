package com.school.automation.dto;

public class StudentDto {
    private Long id;
    private String name;
    private String gender;
    private String type;    
    private String timestamp;
    
    public StudentDto() {}

    public StudentDto(Long id, 
            String name, String gender, 
            String type, String timestamp) {
        this.id     = id;
        this.name   = name;
        this.gender = gender;
        this.type   = type;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "StudentDto{" + "name=" + name 
                + ", gender=" + gender 
                + ", type=" + type 
                + ", timestamp=" + timestamp + '}';
    }
}
