package com.school.registerdb.dao.impl;

import com.school.registerdb.common.Type;
import com.school.registerdb.dao.StudentDao;
import com.school.registerdb.model.Student;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jhonny
 */
@Repository
public class StudentDaoImpl extends GenericDaoImpl<Student, Long> implements StudentDao {
    public StudentDaoImpl() {
        super(Student.class);
    }
        
    @Override
    @Transactional
    public List<Student> findByName(String name) {
        Session session = getSessionFactory().getCurrentSession();   
        List<Student> students = (List<Student>)session.createCriteria(Student.class)
                .addOrder(Order.asc("name"))
                .add(Restrictions.like("name", name+"%"))
                .list();
        
        return students;
    }
    
    @Override
    @Transactional
    public List<Student> findByType(Type type) {
        Session session = getSessionFactory().getCurrentSession();   
        List<Student> students = (List<Student>)session.createCriteria(Student.class)
                .addOrder(Order.asc("timestamp"))
                .add(Restrictions.eq("type", type))
                .list();
        
        return students;
    }
    
    @Override
    @Transactional
    public List<Student> findByTypeAndGender(Type type, String gender) {
        Session session = getSessionFactory().getCurrentSession();   
        List<Student> students = (List<Student>)session.createCriteria(Student.class)
                .addOrder(Order.asc("timestamp"))
                .add(Restrictions.eq("type", type))
                .add(Restrictions.eq("gender", gender))                
                .list();
        
        return students;
    }
}
