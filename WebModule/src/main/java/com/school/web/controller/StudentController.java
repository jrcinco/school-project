
package com.school.web.controller;

import com.school.registerdb.model.Student;
import com.school.web.dto.StudentDetailDto;
import com.school.web.util.ResponseUtil;
import com.school.web.handler.StudentHandler;
import com.school.web.common.payload.OperationResult;
import com.school.web.common.payload.EmptyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jhonny
 */
@RestController
@RequestMapping("/student")
@Api(value="school", description="Operations to create students in School")
public class StudentController {    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StudentHandler studentHandler;

    /**
     * The request param are optional.
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "View a list of available students", response = Student.class, responseContainer="List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Server Error: Application exception. Please contact your administrative personnel for technical support")
    })
    public List<Student> findStudent(
            @RequestParam(required=false, value = "name") String name,
            @RequestParam(required=false, value = "gender") String gender,
            @RequestParam(required=false, value = "type") String type) {
        logger.info("[StudentController.find] name data: {}", name);
        logger.info("[StudentController.find] name gender: {}", gender);
        logger.info("[StudentController.find] name type : {}", type);        
        return studentHandler.find(name, gender, type);        
    }    
    
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Create students", response = OperationResult.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Server Error: Application exception. Please contact your administrative personnel for technical support")
    })
    public OperationResult createStudent(@RequestBody final StudentDetailDto payload) {
        logger.info("[StudentController.create] json data: {}", payload);
        logger.info("[StudentController.create] Handler: {}", studentHandler);
        studentHandler.create(payload);
        return ResponseUtil.ok();
    }    

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    @ApiOperation(value = "Update students", response = OperationResult.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Server Error: Application exception. Please contact your administrative personnel for technical support")
    })    
    public OperationResult updateStudent(
            @RequestBody final StudentDetailDto payload, 
            @PathVariable Long id) {
        logger.info("[StudentController.update] json data: {}", payload);
        logger.info("[StudentController.update] id data: {}", id);        
        studentHandler.update(id, payload);
        return ResponseUtil.ok();
    }    

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ApiOperation(value = "Delete students", response = OperationResult.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Server Error: Application exception. Please contact your administrative personnel for technical support")
    })
    public OperationResult deleteStudent(@PathVariable Long id) {
        logger.info("[StudentController.delete] ID: {}", id);                
        studentHandler.delete(id);
        return ResponseUtil.ok();
    }
}
