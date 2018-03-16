
package com.school.web.service.handler;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.school.registerdb.model.Student;
import com.school.registerdb.service.StudentManager;
import com.school.web.service.util.JsonCommand;
import com.school.web.service.util.DateUtil;
import com.school.web.service.database.ManagerSingleton;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jhonny
 */
public class RestFulRegisterStudentCmd extends JsonCommand{
    private final StudentManager studentManager; 
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private JsonCommand cmd;
    
    public RestFulRegisterStudentCmd(){        
        studentManager = ManagerSingleton.getInstance().getStudentManager();
    }
    
    public RestFulRegisterStudentCmd(JsonCommand cmd){  
        studentManager = ManagerSingleton.getInstance().getStudentManager();        
        this.cmd = cmd;
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
    
    public void create() {
        Student student = new Student();
        mapping(student);
        setObservation("The student was created!");
    }
    
    public void update(Long id) {        
        Student student = studentManager.find(id);
        logger.info("[StudentController.update] student: {}", student);
        mapping(student);
        setObservation("The student was updated!");
    }
    
    public void delete(Long id) {        
        Student student = studentManager.find(id);
        studentManager.delete(student);
        setObservation("The student was deleted!");
    }
    
    private void mapping(Student student){
        setCmd(cmd.getCmd());        
        setTimestamp(cmd.getTimestamp());        
        
        ObjectMapper mapper = new ObjectMapper();        
        try {
            JsonNode node = mapper.readTree(cmd.getContent());
            
            // Mapping
            ObjectNode obj  = (ObjectNode) node;
            String name     = obj.get("name").asText();       
            String gender   = obj.get("gender").asText();         
            String type     = obj.get("type").asText();
            String timestamp= DateUtil.getTodayTimestamp();            
            
            student.setName(name);            
            student.setGender(gender);
            student.setType(type);
            student.setTimestamp(timestamp);

            studentManager.saveOrUpdate(student);
            setResult("success");            
        } catch (IOException ex) {
            logger.error("[RestFulRegisterStudentCmd] Given data is wrong formated: ", ex);
            setResult("error");
            setObservation("Given data is wrong formated");
        }                                                        
    }
}
