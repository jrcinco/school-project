package com.school.testcases.apitesting;

import com.school.registerdb.util.Constants;
import com.school.automation.payload.StudentPayload;
import com.school.automation.util.MapperUtil;
import com.school.automation.util.DataBaseUtil;
import com.school.automation.util.RequestUtil;
import com.school.automation.common.DataPath;
import com.school.automation.common.EndpointPath;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import static org.junit.Assert.*;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(JUnitParamsRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentPositiveTest {    
    private final static Logger logger = LoggerFactory.getLogger(StudentPositiveTest.class);
    private static List<StudentPayload> expectedResults = new ArrayList<>();

    /**
     * This test method is invoked once before any test method found from this class
     * or from the inner classes is invoked.
     */
    @BeforeClass
    public static void setUpClass() {
        logger.info("Invoked once before all test methods");        
        DataBaseUtil.cleanup(); // Clean Database.
        
        MapperUtil<StudentPayload> mapper = new MapperUtil<>();
        expectedResults = mapper.getJsonListFunctionality(StudentPayload.class, DataPath.STUDENT_LIST_PATH);
        logger.info("[StudentPositiveTest][setUpClass] Json List: " + expectedResults);
    }
    
    /**
     * This test method is invoked once after all test methods found from this class
     * or from the inner classes have been invoked.
     */
    @AfterClass
    public static void tearDownClass() {
        logger.info("Invoked once after all test methods");        
    }

    @Test
    @Parameters({
            "Jhonny, M, KINDER, 20180328142530",
            "Jhoselin, F, KINDER, 20180328152530",
            "Elvis, M, KINDER, 20180328162530",
            "Wendy, F, KINDER, 20180328172530"
    })
    public void test1PostStudent(String name, String gender, 
                                String type, String timestamp) {
        logger.info("StudentPositiveTest: API Testing: POST");
 
        StudentPayload dto = new StudentPayload(name, gender, type, timestamp);
        Response response = RequestUtil.postRequest(EndpointPath.STUDENT_PATH, dto); 
        
        logger.info("Status Code: {}", response.getStatus());
        if (response.getStatus() == Constants.OK_STATUS_CODE) {
            assertTrue(true);  // Check that a condition is true.
        } else {                        
            assertTrue(false); // Check that a condition is false.
        }
    }

    @Test
    public void test2GetStudent() {
        logger.info("StudentPositiveTest: API Testing: GET");
        
        Response response = RequestUtil.getRequest(EndpointPath.STUDENT_PATH);        
        
        if (response.getStatus() == Constants.OK_STATUS_CODE) {            
            List<StudentPayload> actualResult = response 
                    .readEntity(new GenericType<List<StudentPayload>>() {});
            logger.info("Display actual result: {}", actualResult);
            
            //Check whether are equal to each other.        
            assertThat(actualResult, containsInAnyOrder(
                                        expectedResults.get(0),    // Jhonny
                                        expectedResults.get(1),    // Jhoselin
                                        expectedResults.get(2),    // Elvis
                                        expectedResults.get(3)));  // Wendy
        } else {
            logger.error("Status Code: {}", response.getStatus());                    
            assertTrue(false); // Check that a condition is false.
        }                 
    }

    @Test
    @Parameters({
        "4, Wendy Lala, F, KINDER, 20180328182530"            
    })
    public void test3PutStudent(Long id, String name, String gender, 
                                String type, String timestamp) {
        logger.info("StudentPositiveTest: API Testing: PUT");
                 
        StudentPayload dto = new StudentPayload(name, gender, type, timestamp);       
        Map<String, Object> pathParams = new HashMap<>();                                                                        
        pathParams.put("id", id);        
        
        Response response = RequestUtil.putRequest(EndpointPath.STUDENT_ID_PATH, pathParams, dto); 
        
        if (response.getStatus() == Constants.OK_STATUS_CODE) {
            assertTrue(true);  // Check that a condition is true.
        } else {
            logger.error("Status Code: " + response.getStatus());                              
            assertTrue(false); // Check that a condition is false.
        }  
    }

    @Test
    @Parameters({
        "3"            // Delete the student Elvis.
    })
    public void test4DeleteStudent(Long id) {
        logger.info("StudentPositiveTest: API Testing: DELETE");       
        
        Map<String, Object> pathParams = new HashMap<>();                                                                        
        pathParams.put("id", id);        
        
        Response response = RequestUtil.deleteRequest(EndpointPath.STUDENT_ID_PATH, pathParams); 
        
        if (response.getStatus() == Constants.OK_STATUS_CODE) {
            assertTrue(true);  // Check that a condition is true.
        } else {
            logger.error("Status Code: " + response.getStatus());                              
            assertTrue(false); // Check that a condition is false.
        }       
    }
}
