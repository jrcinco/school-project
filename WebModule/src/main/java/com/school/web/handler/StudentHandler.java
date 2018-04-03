
package com.school.web.handler;

import com.school.registerdb.model.Student;
import com.school.registerdb.service.StudentManager;
import com.school.web.dto.StudentDetailDto;
import com.school.web.validation.annotation.FieldValidation;
import com.school.web.validation.rule.StudentRule;
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
    private final Logger logger = LoggerFactory.getLogger(this.getClass()); 
    @Autowired
    private StudentManager studentManager;
    @Autowired
    private StudentRule studentRule;
    
    public List<Student> find(String name, String gender, String type) {        
        List<Student> students;
        if (name != null) {
            students = studentManager.findStudentsByName(name);
        } else if (gender != null && type != null) {
            studentRule.validateFind(type);
            students = studentManager.findStudentsByTypeAndGender(type, gender);
        } else if (type != null) {
            studentRule.validateFind(type);
            students = studentManager.findStudentsByType(type);
        } else { // Return all data.
            students = studentManager.findAll();
        }
        logger.info("[StudentController.find] students: {}", students);
        return students;
    }

    @FieldValidation
    public void create(@Validated StudentDetailDto dto) {
        studentRule.validateCreate(dto, studentManager);
        Student student = new Student(dto.getName(), 
                                    dto.getGender(), 
                                    dto.getType(), 
                                    dto.getTimestamp());
        logger.info("[StudentHandler.create] Student: {}", student);
        studentManager.saveOrUpdate(student);
    }
    
    @FieldValidation
    public void update(Long id, @Validated StudentDetailDto dto) {        
        Student student = studentRule.validateUpdate(id, dto, studentManager);
        logger.info("[StudentController.update] student: {}", student);
        student.setName(dto.getName());            
        student.setGender(dto.getGender());
        student.setType(dto.getType());
        student.setTimestamp(dto.getTimestamp());        
        studentManager.saveOrUpdate(student);
    }
    
    public void delete(Long id) {
        Student student = studentRule.validateDelete(id, studentManager);
        logger.info("[StudentController.delete] student: {}", student);
        studentManager.delete(student);
    }
}
