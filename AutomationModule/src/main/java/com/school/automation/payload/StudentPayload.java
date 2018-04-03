package com.school.automation.payload;

import java.util.Objects;

public class StudentPayload {
    private Long id;
    private String name;
    private String gender;
    private String type;    
    private String timestamp;
    
    public StudentPayload() {}

    public StudentPayload(String name, String gender, 
                    String type, String timestamp) {
        this.name   = name;
        this.gender = gender;
        this.type   = type;
        this.timestamp = timestamp;
    }

    public StudentPayload(Long id, 
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
        return "StudentDto{" + "id=" + id 
                + ", name=" + name
                + ", gender=" + gender 
                + ", type=" + type 
                + ", timestamp=" + timestamp + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.gender);
        hash = 53 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final StudentPayload other = (StudentPayload) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }

        return true;
    }
}
