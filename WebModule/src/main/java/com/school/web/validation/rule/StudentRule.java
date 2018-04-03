package com.school.web.validation.rule;

import com.school.registerdb.common.Type;
import com.school.registerdb.model.Student;
import com.school.registerdb.service.StudentManager;
import com.school.web.dto.StudentDetailDto;
import com.school.web.common.exception.ApplicationException;
import com.school.web.common.exception.ClientErrorException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Iterator;
import java.util.List;

/**
 * @author jhonny
 */
@Service
@Transactional
public class StudentRule {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());    
    private String badCode;

    /**
     * @description Logic Validation 
     * 
     * @param Type
     * @return void
     */
    public void validateFind(String type) {
        badCode = "";

        if (!Type.isValid(type)) {
            badCode = "ST011"; // ST011=Type value should be ELEMENTARY, KINDER or HIGH.
            throwException(new ClientErrorException(badCode), badCode);
        }
    }
    
    /**
     * @description Logic Validation 
     * 
     * @param StudentManager  
     * @param StudentDetailDto
     * @return void
     */
    public void validateCreate(StudentDetailDto dto, StudentManager studentManager) {
        badCode = "";

        if (!Type.isValid(dto.getType())) {
            badCode = "ST011"; // ST011=Type value should be ELEMENTARY, KINDER or HIGH.
            throwException(new ClientErrorException(badCode), badCode);
        } else {
            List<Student> students = studentManager.findStudentsByName(dto.getName());
            if (!students.isEmpty()) {
                badCode = "ST009"; // ST009=A Student by this name already exists.
                throwException(new ApplicationException(badCode), badCode);
            }
        }         
    }

    /**
     * @description Logic Validation 
     * 
     * @param StudentManager
     * @param StudentDetailDto
     * @return Student
     */
    public Student validateUpdate(Long id, StudentDetailDto dto, StudentManager studentManager) {
        badCode = "";
        Student student = null;

        if (!Type.isValid(dto.getType())) {
            badCode = "ST011"; // ST011=Type value should be ELEMENTARY, KINDER or HIGH.
            throwException(new ClientErrorException(badCode), badCode);
        } else {
            student = studentManager.find(id);
                
            if (student == null) {
                badCode = "ST010"; // ST010=Some supplied data does not exist in the database.
                throwException(new ApplicationException(badCode), badCode);
            } else {
                List<Student> students = studentManager.findStudentsByName(dto.getName());       
                Iterator<Student> iter = students.iterator();
                Student next;
                boolean flag = true;
                while(flag && iter.hasNext()){
                    next = iter.next();
                    if(next.getName().equalsIgnoreCase(dto.getName()) && 
                            next.getId() != id){
                        flag = false;
                        badCode = "ST009"; // ST009=A student by this name already exists.
                        throwException(new ApplicationException(badCode), badCode);
                    }                
                }
            }
        }
                        
        return student;
    }
    
    /**
     * @description Logic Validation 
     * 
     * @param StudentManager
     * @param Long  
     * @return Student
     */
    public Student validateDelete(Long id, StudentManager studentManager) {
        badCode = "";
        Student student = studentManager.find(id);
            
        if (student == null) {
            badCode = "ST010"; // ST010=Some supplied data does not exist in the database.
            throwException(new ApplicationException(badCode), badCode);
        }
                        
        return student;
    }    
    
    private void throwException(RuntimeException exception, String badCode){
        logger.info("[StudentRule].[validate] bad code: {}", badCode);
        throw exception;
    }    
}
