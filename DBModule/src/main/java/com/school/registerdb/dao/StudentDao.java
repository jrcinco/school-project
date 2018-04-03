
package com.school.registerdb.dao;

import com.school.registerdb.common.Type;
import com.school.registerdb.model.Student;
import java.util.List;

/**
 *
 * @author jhonny
 */
public interface StudentDao extends GenericDao<Student, Long>{
    public List<Student> findByName(String name);
    public List<Student> findByType(Type type);
    public List<Student> findByTypeAndGender(Type type, String gender);
}
