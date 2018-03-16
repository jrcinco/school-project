package com.school.web.service.database;

import com.school.registerdb.service.StudentManager;

/**
 * @author jhonny
 */
public class ManagerSingleton {

    private static ManagerSingleton instance;
    private StudentManager studentManager;
    
    private ManagerSingleton(){    
    }

    public StudentManager getStudentManager() {
        return studentManager;
    }

    public void setStudentManager(StudentManager studentManager) {
        this.studentManager = studentManager;
    }
        
    public static ManagerSingleton getInstance(){
        if(instance == null){
            instance = new ManagerSingleton();
        }
        return instance;
    }

    public static void setInstance(ManagerSingleton instance) {
        ManagerSingleton.instance = instance;
    }
}
