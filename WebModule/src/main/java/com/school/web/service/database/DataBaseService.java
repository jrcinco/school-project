
package com.school.web.service.database;

import com.school.registerdb.service.StudentManager;

/**
 * @author jhonny
 */
public class DataBaseService {    
    public void setStudentManager(StudentManager studentManager) {
        ManagerSingleton.getInstance().setStudentManager(studentManager);
    }
}
