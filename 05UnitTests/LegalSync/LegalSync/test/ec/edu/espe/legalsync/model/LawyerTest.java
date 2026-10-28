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
public class LawyerTest {
    
    public LawyerTest() {
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
     * Test of isDirector method, of class Lawyer.
     */
    @Test
    public void testIsDirector() {
        System.out.println("isDirector");
        Lawyer instance = new Lawyer();
        boolean expResult = false;
        boolean result = instance.isDirector();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of assignUserRole method, of class Lawyer.
     */
    @Test
    public void testAssignUserRole() {
        System.out.println("assignUserRole");
        User targetUser = null;
        String newRole = "";
        Lawyer instance = new Lawyer();
        boolean expResult = false;
        boolean result = instance.assignUserRole(targetUser, newRole);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of restrictUserAccess method, of class Lawyer.
     */
    @Test
    public void testRestrictUserAccess() {
        System.out.println("restrictUserAccess");
        User targetUser = null;
        Lawyer instance = new Lawyer();
        instance.restrictUserAccess(targetUser);
        
        
    }

    /**
     * Test of getDetails method, of class Lawyer.
     */
    @Test
    public void testGetDetails() {
        System.out.println("getDetails");
        Lawyer instance = new Lawyer();
        String expResult = "";
        String result = instance.getDetails();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getLawyerId method, of class Lawyer.
     */
    @Test
    public void testGetLawyerId() {
        System.out.println("getLawyerId");
        Lawyer instance = new Lawyer();
        int expResult = 0;
        int result = instance.getLawyerId();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setLawyerId method, of class Lawyer.
     */
    @Test
    public void testSetLawyerId() {
        System.out.println("setLawyerId");
        int lawyerId = 0;
        Lawyer instance = new Lawyer();
        instance.setLawyerId(lawyerId);
        
        
    }

    /**
     * Test of getName method, of class Lawyer.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Lawyer instance = new Lawyer();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setName method, of class Lawyer.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Lawyer instance = new Lawyer();
        instance.setName(name);
        
        
    }

    /**
     * Test of getEmail method, of class Lawyer.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Lawyer instance = new Lawyer();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setEmail method, of class Lawyer.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Lawyer instance = new Lawyer();
        instance.setEmail(email);
        
        
    }

    /**
     * Test of getPosition method, of class Lawyer.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        Lawyer instance = new Lawyer();
        String expResult = "";
        String result = instance.getPosition();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setPosition method, of class Lawyer.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        String position = "";
        Lawyer instance = new Lawyer();
        instance.setPosition(position);
        
        
    }

    /**
     * Test of getLicenseNumber method, of class Lawyer.
     */
    @Test
    public void testGetLicenseNumber() {
        System.out.println("getLicenseNumber");
        Lawyer instance = new Lawyer();
        String expResult = "";
        String result = instance.getLicenseNumber();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setLicenseNumber method, of class Lawyer.
     */
    @Test
    public void testSetLicenseNumber() {
        System.out.println("setLicenseNumber");
        String licenseNumber = "";
        Lawyer instance = new Lawyer();
        instance.setLicenseNumber(licenseNumber);
        
        
    }

    /**
     * Test of toString method, of class Lawyer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Lawyer instance = new Lawyer();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
    }
    
}
