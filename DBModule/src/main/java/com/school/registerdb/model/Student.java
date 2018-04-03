package com.school.registerdb.model;

import com.school.registerdb.common.Type;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Student
 */
@Entity
@Table(name = "student", catalog = "register_db")
public class Student implements java.io.Serializable {

    private Long id;
    private String name;
    private String gender;
    private Type type;
    private String timestamp;

    public Student() {}

    public Student(String name, String gender, String type, String timestamp) {        
        this.name   = name;
        this.gender = gender;
        this.type   = Type.valueOf(type);
        this.timestamp = timestamp;
    }

    public Student(Long id, String name, String gender, Type type, String timestamp) {
        this.id     = id;
        this.name   = name;        
        this.gender = gender;
        this.type   = type;
        this.timestamp = timestamp;
    }    

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "gender", length = 5)
    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 20)
    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setType(String type) {
        this.type = Type.valueOf(type);
    }

    @Column(name = "timestamp", length = 20)
    public String getTimestamp() {
        return this.timestamp;
    }    

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id 
                + ", name=" + name 
                + ", gender=" + gender 
                + ", type=" + type 
                + ", timestamp=" + timestamp + '}';
    }
}
