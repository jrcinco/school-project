
package com.school.registerdb.service;

import com.school.registerdb.model.Student;
import java.util.List;

/**
 *
 * @author jhonny
 */
public interface StudentManager extends GenericManager<Student, Long>{
    public List<Student> findAll();
    public List<Student> findStudentsByName(String name);
    public List<Student> findStudentsByType(String type);
    public List<Student> findStudentsByTypeAndGender(String type, String gender);    
}
