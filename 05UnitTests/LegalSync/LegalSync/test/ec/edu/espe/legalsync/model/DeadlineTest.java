package ec.edu.espe.legalsync.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mateo Unda, CodeLex, @ESPE
 */
public class DeadlineTest {
    
    public DeadlineTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculateRemainingDays method, of class Deadline.
     */
    @Test
    public void testCalculateRemainingDays() {
        System.out.println("calculateRemainingDays");
        Deadline instance = new Deadline();
        int expResult = 0;
        int result = instance.calculateRemainingDays();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of markCompleted method, of class Deadline.
     */
    @Test
    public void testMarkCompleted() {
        System.out.println("markCompleted");
        Deadline instance = new Deadline();
        instance.markCompleted();
        
        
    }

    /**
     * Test of getDetails method, of class Deadline.
     */
    @Test
    public void testGetDetails() {
        System.out.println("getDetails");
        Deadline instance = new Deadline();
        String expResult = "";
        String result = instance.getDetails();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getDeadlineId method, of class Deadline.
     */
    @Test
    public void testGetDeadlineId() {
        System.out.println("getDeadlineId");
        Deadline instance = new Deadline();
        int expResult = 0;
        int result = instance.getDeadlineId();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setDeadlineId method, of class Deadline.
     */
    @Test
    public void testSetDeadlineId() {
        System.out.println("setDeadlineId");
        int deadlineId = 0;
        Deadline instance = new Deadline();
        instance.setDeadlineId(deadlineId);
        
        
    }

    /**
     * Test of getCaseId method, of class Deadline.
     */
    @Test
    public void testGetCaseId() {
        System.out.println("getCaseId");
        Deadline instance = new Deadline();
        int expResult = 0;
        int result = instance.getCaseId();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setCaseId method, of class Deadline.
     */
    @Test
    public void testSetCaseId() {
        System.out.println("setCaseId");
        int caseId = 0;
        Deadline instance = new Deadline();
        instance.setCaseId(caseId);
        
        
    }

    /**
     * Test of getDescription method, of class Deadline.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Deadline instance = new Deadline();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setDescription method, of class Deadline.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Deadline instance = new Deadline();
        instance.setDescription(description);
        
        
    }

    /**
     * Test of getDisposition method, of class Deadline.
     */
    @Test
    public void testGetDisposition() {
        System.out.println("getDisposition");
        Deadline instance = new Deadline();
        String expResult = "";
        String result = instance.getDisposition();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setDisposition method, of class Deadline.
     */
    @Test
    public void testSetDisposition() {
        System.out.println("setDisposition");
        String disposition = "";
        Deadline instance = new Deadline();
        instance.setDisposition(disposition);
        
        
    }

    /**
     * Test of getType method, of class Deadline.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Deadline instance = new Deadline();
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setType method, of class Deadline.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "";
        Deadline instance = new Deadline();
        instance.setType(type);
        
        
    }

    /**
     * Test of getTargetDate method, of class Deadline.
     */
    @Test
    public void testGetTargetDate() {
        System.out.println("getTargetDate");
        Deadline instance = new Deadline();
        String expResult = "";
        String result = instance.getTargetDate();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setTargetDate method, of class Deadline.
     */
    @Test
    public void testSetTargetDate() {
        System.out.println("setTargetDate");
        String targetDate = "";
        Deadline instance = new Deadline();
        instance.setTargetDate(targetDate);
        
        
    }

    /**
     * Test of getAssignedUser method, of class Deadline.
     */
    @Test
    public void testGetAssignedUser() {
        System.out.println("getAssignedUser");
        Deadline instance = new Deadline();
        String expResult = "";
        String result = instance.getAssignedUser();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setAssignedUser method, of class Deadline.
     */
    @Test
    public void testSetAssignedUser() {
        System.out.println("setAssignedUser");
        String assignedUser = "";
        Deadline instance = new Deadline();
        instance.setAssignedUser(assignedUser);
        
        
    }

    /**
     * Test of isCompleted method, of class Deadline.
     */
    @Test
    public void testIsCompleted() {
        System.out.println("isCompleted");
        Deadline instance = new Deadline();
        boolean expResult = false;
        boolean result = instance.isCompleted();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setCompleted method, of class Deadline.
     */
    @Test
    public void testSetCompleted() {
        System.out.println("setCompleted");
        boolean completed = false;
        Deadline instance = new Deadline();
        instance.setCompleted(completed);
        
        
    }

    /**
     * Test of toString method, of class Deadline.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Deadline instance = new Deadline();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
    }
    
}
