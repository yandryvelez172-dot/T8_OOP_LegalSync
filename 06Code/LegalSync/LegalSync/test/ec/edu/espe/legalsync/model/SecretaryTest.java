package ec.edu.espe.legalsync.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Josselyn Ulcuango, CodeLex, @ESPE
 */
public class SecretaryTest {
    
    public SecretaryTest() {
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
     * Test of getDetails method, of class Secretary.
     */
    @Test
    public void testGetDetails() {
        System.out.println("getDetails");
        Secretary instance = new Secretary();
        String expResult = "";
        String result = instance.getDetails();
        assertEquals(expResult, result);

    }

    /**
     * Test of getSecretaryId method, of class Secretary.
     */
    @Test
    public void testGetSecretaryId() {
        System.out.println("getSecretaryId");
        Secretary instance = new Secretary();
        int expResult = 0;
        int result = instance.getSecretaryId();
        assertEquals(expResult, result);

    }

    /**
     * Test of setSecretaryId method, of class Secretary.
     */
    @Test
    public void testSetSecretaryId() {
        System.out.println("setSecretaryId");
        int secretaryId = 0;
        Secretary instance = new Secretary();
        instance.setSecretaryId(secretaryId);

    }

    /**
     * Test of getName method, of class Secretary.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Secretary instance = new Secretary();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);

    }

    /**
     * Test of setName method, of class Secretary.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Secretary instance = new Secretary();
        instance.setName(name);

    }

    /**
     * Test of getEmail method, of class Secretary.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Secretary instance = new Secretary();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);

    }

    /**
     * Test of setEmail method, of class Secretary.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Secretary instance = new Secretary();
        instance.setEmail(email);

    }

    /**
     * Test of getOfficeArea method, of class Secretary.
     */
    @Test
    public void testGetOfficeArea() {
        System.out.println("getOfficeArea");
        Secretary instance = new Secretary();
        String expResult = "";
        String result = instance.getOfficeArea();
        assertEquals(expResult, result);

    }

    /**
     * Test of setOfficeArea method, of class Secretary.
     */
    @Test
    public void testSetOfficeArea() {
        System.out.println("setOfficeArea");
        String officeArea = "";
        Secretary instance = new Secretary();
        instance.setOfficeArea(officeArea);

    }

    /**
     * Test of toString method, of class Secretary.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Secretary instance = new Secretary();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);

    }
    
}
