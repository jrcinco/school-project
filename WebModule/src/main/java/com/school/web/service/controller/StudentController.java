
package com.school.web.service.controller;

import com.school.registerdb.model.Student;
import com.school.web.service.util.JsonCommand;
import com.school.web.service.util.MessageCommand;
import com.school.web.service.handler.RestFulRegisterStudentCmd;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jhonny
 */
@RestController
@RequestMapping("/student")
public class StudentController {    
    private final Logger logger;

    public StudentController() {        
        logger = LoggerFactory.getLogger(this.getClass());
    }    

    /**
     * The request param are optional.
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)    
    public List<Student> findStudent(
            @RequestParam(required=false, value = "name") String name,
            @RequestParam(required=false, value = "gender") String gender,
            @RequestParam(required=false, value = "type") String type) {
        logger.info("[StudentController.find] name data: {}", name);
        logger.info("[StudentController.find] name gender: {}", gender);
        logger.info("[StudentController.find] name type : {}", type);
        
        RestFulRegisterStudentCmd responseCmd = new RestFulRegisterStudentCmd();
        return responseCmd.find(name, gender, type);       
    }
    
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)    
    public MessageCommand createStudent(@RequestBody final JsonCommand requestCmd) {
        logger.info("[StudentController.create] json data: {}", requestCmd.getContent());
        
        RestFulRegisterStudentCmd responseCmd = new RestFulRegisterStudentCmd(requestCmd);
        responseCmd.create();
        return responseCmd;
    }
    
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")    
    public MessageCommand updateStudent(
            @RequestBody final JsonCommand requestCmd, 
            @PathVariable Long id) {
        logger.info("[StudentController.update] json data: {}", requestCmd.getContent());
        logger.info("[StudentController.update] id data: {}", id);
        
        RestFulRegisterStudentCmd responseCmd = new RestFulRegisterStudentCmd(requestCmd);
        responseCmd.update(id);
        return responseCmd;
    }
    
    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")    
    public MessageCommand deleteStudent(
            @RequestBody final JsonCommand requestCmd, 
            @PathVariable Long id) {
        logger.info("[StudentController.delete] json data: {}", requestCmd.getContent());
        
        RestFulRegisterStudentCmd responseCmd = new RestFulRegisterStudentCmd(requestCmd);
        responseCmd.delete(id);
        return responseCmd;
    }
}
