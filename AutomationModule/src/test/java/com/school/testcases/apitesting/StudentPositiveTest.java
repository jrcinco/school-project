package com.school.testcases.apitesting;

import com.school.registerdb.util.Constants;
import com.school.automation.dto.StudentDto;
import com.school.automation.util.MapperUtil;
import com.school.automation.util.DataBaseUtil;
import com.school.automation.util.RequestUtil;
import com.school.automation.common.DataPath;
import com.school.automation.common.EndpointPath;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(JUnitParamsRunner.class)
public class StudentPositiveTest {    
    private final static Logger logger = LoggerFactory.getLogger(StudentPositiveTest.class);
    private static List<StudentDto> expectedResults = new ArrayList<>();

    /**
     * This test method is invoked once before any test method found from this class
     * or from the inner classes is invoked.
     */
    @BeforeClass
    public static void setUpClass() {
        // Database
        DataBaseUtil.cleanup();

        logger.info("Invoked once before all test methods");
        MapperUtil<StudentDto> mapper = new MapperUtil<>();
        expectedResults = mapper.getJsonListFunctionality(StudentDto.class, DataPath.STUDENT_LIST_PATH);
        logger.info("[StudentPositiveTest][setUpClass] Json List: " + expectedResults);
    }

    /**
     * This method is invoked before a test method found from this class or
     * from the inner classes is invoked.
     */
    @Before
    public void setUp() {
        logger.info("Invoked before each test method");        
    }

    /**
     * This method is invoked after a test method found from this class or
     * from the inner classes is invoked.
     */
    @After
    public void tearDown() {
        logger.info("Invoked after each test method");                        
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
            "Jhonny, M, Kinder, 20180328142530",
            "Jhoselin, F, Kinder, 20180328152530",
            "Elvis, M, Kinder, 20180328162530",
            "Wendy, F, Kinder, 20180328172530"
    })
    public void test1PostStudent(String name, String gender, 
                                String type, String timestamp) {
        logger.info("StudentPositiveTest: API Testing: POST");
 
        StudentDto dto = new StudentDto(name, gender, type, timestamp);
        Response response = RequestUtil.postRequest(EndpointPath.STUDENT_PATH, dto); 
        
        logger.info("Status Code: {}", response.getStatus());
        if(response.getStatus() == Constants.OK_STATUS_CODE) {
            assertTrue(true);  //Check that a condition is true
        } else {                        
            assertTrue(false); //Check that a condition is false
        }
    }    
}
