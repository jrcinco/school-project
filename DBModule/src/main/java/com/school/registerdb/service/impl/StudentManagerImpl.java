
package com.school.registerdb.service.impl;

import com.school.registerdb.common.Type;
import com.school.registerdb.dao.StudentDao;
import com.school.registerdb.model.Student;
import com.school.registerdb.service.StudentManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jhonny
 */
@Service
public class StudentManagerImpl extends GenericManagerImpl<Student, Long> implements StudentManager {
    
    private StudentDao studentDao;
    
    @Autowired
    public StudentManagerImpl(StudentDao studentDao) {
        super(studentDao);
        this.studentDao = studentDao;
    }

    /**     
     * @return all data of Student table.
     */
    @Override
    public List<Student> findAll() {
        return studentDao.getAll();
    }
    
    /**     
     * Find the student name that is start with <name> and follow by any characters.
     * @param name
     * @return a student list sorted alphabetically 
     */
    @Override
    public List<Student> findStudentsByName(String name) {
        return studentDao.findByName(name);
    }
    
    /**     
     * @param type
     * @return a student list order by ascending date.
     */
    @Override
    public List<Student> findStudentsByType(String type) {
        return studentDao.findByType(Type.valueOf(type));
    }
    
    /**     
     * @param type
     * @param gender
     * @return a student list order by ascending date.
     */
    @Override
    public List<Student> findStudentsByTypeAndGender(String type, String gender) {
        return studentDao.findByTypeAndGender(Type.valueOf(type), gender);
    }
}
