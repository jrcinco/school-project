
package com.school.web.handler;

import com.school.registerdb.model.Student;
import com.school.registerdb.service.StudentManager;
import com.school.web.util.DateUtil;
import com.school.web.dto.StudentDetailDto;
import com.school.web.validation.annotation.ApplicationValidation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jhonny
 */
@Service
@Transactional
public class StudentHandler {    
    @Autowired
    private StudentManager studentManager;
    private final Logger logger;
    
    public StudentHandler() {
        logger = LoggerFactory.getLogger(this.getClass());
    }        

    public List<Student> find(String name, String gender, String type) {
        List<Student> students;
        if (name != null) {
            students = studentManager.findStudentsByName(name);
        } else if (gender != null && type != null) {
            students = studentManager.findStudentsByTypeAndGender(type, gender);
        } else if (type != null) {
            students = studentManager.findStudentsByType(type);
        } else { // Return all data.
            students = studentManager.findAll();
        }
        logger.info("[StudentController.find] students: {}", students);
        return students;
    }

    @ApplicationValidation
    public void create(@Validated StudentDetailDto dto) {
        Student student = new Student(dto.getName(), 
                                    dto.getGender(), 
                                    dto.getType(), 
                                    dto.getTimestamp());
        logger.info("[StudentHandler.create] Student: {}", student);
        studentManager.saveOrUpdate(student);
    }
    
    public void update(Long id, StudentDetailDto dto) {        
        Student student = studentManager.find(id);
        logger.info("[StudentController.update] student: {}", student);
        student.setName(dto.getName());            
        student.setGender(dto.getGender());
        student.setType(dto.getType());
        student.setTimestamp(dto.getTimestamp());        
        studentManager.saveOrUpdate(student);
    }
    
    public void delete(Long id) {        
        Student student = studentManager.find(id);
        logger.info("[StudentController.delete] student: {}", student);
        studentManager.delete(student);  
    }
}
