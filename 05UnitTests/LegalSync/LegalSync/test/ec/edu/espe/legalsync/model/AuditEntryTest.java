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
public class AuditEntryTest {
    
    public AuditEntryTest() {
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
     * Test of toLogLine method, of class AuditEntry.
     */
    @Test
    public void testToLogLine() {
        System.out.println("toLogLine");
        AuditEntry instance = new AuditEntry();
        String expResult = "";
        String result = instance.toLogLine();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getDateTime method, of class AuditEntry.
     */
    @Test
    public void testGetDateTime() {
        System.out.println("getDateTime");
        AuditEntry instance = new AuditEntry();
        String expResult = "";
        String result = instance.getDateTime();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setDateTime method, of class AuditEntry.
     */
    @Test
    public void testSetDateTime() {
        System.out.println("setDateTime");
        String dateTime = "";
        AuditEntry instance = new AuditEntry();
        instance.setDateTime(dateTime);
        
        
    }

    /**
     * Test of getUserEmail method, of class AuditEntry.
     */
    @Test
    public void testGetUserEmail() {
        System.out.println("getUserEmail");
        AuditEntry instance = new AuditEntry();
        String expResult = "";
        String result = instance.getUserEmail();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setUserEmail method, of class AuditEntry.
     */
    @Test
    public void testSetUserEmail() {
        System.out.println("setUserEmail");
        String userEmail = "";
        AuditEntry instance = new AuditEntry();
        instance.setUserEmail(userEmail);
        
        
    }

    /**
     * Test of getRole method, of class AuditEntry.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        AuditEntry instance = new AuditEntry();
        String expResult = "";
        String result = instance.getRole();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setRole method, of class AuditEntry.
     */
    @Test
    public void testSetRole() {
        System.out.println("setRole");
        String role = "";
        AuditEntry instance = new AuditEntry();
        instance.setRole(role);
        
        
    }

    /**
     * Test of getAction method, of class AuditEntry.
     */
    @Test
    public void testGetAction() {
        System.out.println("getAction");
        AuditEntry instance = new AuditEntry();
        String expResult = "";
        String result = instance.getAction();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setAction method, of class AuditEntry.
     */
    @Test
    public void testSetAction() {
        System.out.println("setAction");
        String action = "";
        AuditEntry instance = new AuditEntry();
        instance.setAction(action);
        
        
    }

    /**
     * Test of getDocketNumber method, of class AuditEntry.
     */
    @Test
    public void testGetDocketNumber() {
        System.out.println("getDocketNumber");
        AuditEntry instance = new AuditEntry();
        String expResult = "";
        String result = instance.getDocketNumber();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setDocketNumber method, of class AuditEntry.
     */
    @Test
    public void testSetDocketNumber() {
        System.out.println("setDocketNumber");
        String docketNumber = "";
        AuditEntry instance = new AuditEntry();
        instance.setDocketNumber(docketNumber);
        
        
    }

    /**
     * Test of toString method, of class AuditEntry.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        AuditEntry instance = new AuditEntry();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
    }
    
}
