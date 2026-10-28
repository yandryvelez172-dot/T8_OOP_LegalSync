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
public class DefendantTest {
    
    public DefendantTest() {
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
     * Test of register method, of class Defendant.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        Defendant instance = new Defendant();
        boolean expResult = false;
        boolean result = instance.register();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of update method, of class Defendant.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        String contactInfo = "";
        String address = "";
        Defendant instance = new Defendant();
        boolean expResult = false;
        boolean result = instance.update(contactInfo, address);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getDetails method, of class Defendant.
     */
    @Test
    public void testGetDetails() {
        System.out.println("getDetails");
        Defendant instance = new Defendant();
        String expResult = "";
        String result = instance.getDetails();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getDefendantId method, of class Defendant.
     */
    @Test
    public void testGetDefendantId() {
        System.out.println("getDefendantId");
        Defendant instance = new Defendant();
        int expResult = 0;
        int result = instance.getDefendantId();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setDefendantId method, of class Defendant.
     */
    @Test
    public void testSetDefendantId() {
        System.out.println("setDefendantId");
        int defendantId = 0;
        Defendant instance = new Defendant();
        instance.setDefendantId(defendantId);
        
        
    }

    /**
     * Test of getIdNumber method, of class Defendant.
     */
    @Test
    public void testGetIdNumber() {
        System.out.println("getIdNumber");
        Defendant instance = new Defendant();
        String expResult = "";
        String result = instance.getIdNumber();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setIdNumber method, of class Defendant.
     */
    @Test
    public void testSetIdNumber() {
        System.out.println("setIdNumber");
        String idNumber = "";
        Defendant instance = new Defendant();
        instance.setIdNumber(idNumber);
        
        
    }

    /**
     * Test of getName method, of class Defendant.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Defendant instance = new Defendant();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setName method, of class Defendant.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Defendant instance = new Defendant();
        instance.setName(name);
        
        
    }

    /**
     * Test of getContactInfo method, of class Defendant.
     */
    @Test
    public void testGetContactInfo() {
        System.out.println("getContactInfo");
        Defendant instance = new Defendant();
        String expResult = "";
        String result = instance.getContactInfo();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setContactInfo method, of class Defendant.
     */
    @Test
    public void testSetContactInfo() {
        System.out.println("setContactInfo");
        String contactInfo = "";
        Defendant instance = new Defendant();
        instance.setContactInfo(contactInfo);
        
        
    }

    /**
     * Test of getAddress method, of class Defendant.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Defendant instance = new Defendant();
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setAddress method, of class Defendant.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        Defendant instance = new Defendant();
        instance.setAddress(address);
        
        
    }

    /**
     * Test of toString method, of class Defendant.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Defendant instance = new Defendant();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
    }
    
}
