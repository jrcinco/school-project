package com.school.testcases.apitesting;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentPositiveTest {    
    private final static Logger logger = LoggerFactory.getLogger(StudentPositiveTest.class);

    /**
     * This test method is invoked once before any test method found from this class
     * or from the inner classes is invoked.
     */
    @BeforeClass
    public static void setUpClass() {
        logger.info("Invoked once before all test methods");        
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
    public void test1PostStudent() {
        logger.info("StudentPositiveTest: API Testing: POST");                                                      
    }    
}
