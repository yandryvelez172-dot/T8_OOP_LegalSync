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
public class ClientTest {
    
    public ClientTest() {
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
     * Test of register method, of class Client.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        Client instance = new Client();
        boolean expResult = false;
        boolean result = instance.register();
        assertEquals(expResult, result);

    }

    /**
     * Test of update method, of class Client.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        String phone = "";
        String email = "";
        String address = "";
        Client instance = new Client();
        boolean expResult = false;
        boolean result = instance.update(phone, email, address);
        assertEquals(expResult, result);

    }

    /**
     * Test of getDetails method, of class Client.
     */
    @Test
    public void testGetDetails() {
        System.out.println("getDetails");
        Client instance = new Client();
        String expResult = "";
        String result = instance.getDetails();
        assertEquals(expResult, result);

    }

    /**
     * Test of getClientId method, of class Client.
     */
    @Test
    public void testGetClientId() {
        System.out.println("getClientId");
        Client instance = new Client();
        int expResult = 0;
        int result = instance.getClientId();
        assertEquals(expResult, result);

    }

    /**
     * Test of setClientId method, of class Client.
     */
    @Test
    public void testSetClientId() {
        System.out.println("setClientId");
        int clientId = 0;
        Client instance = new Client();
        instance.setClientId(clientId);

    }

    /**
     * Test of getIdNumber method, of class Client.
     */
    @Test
    public void testGetIdNumber() {
        System.out.println("getIdNumber");
        Client instance = new Client();
        String expResult = "";
        String result = instance.getIdNumber();
        assertEquals(expResult, result);

    }

    /**
     * Test of setIdNumber method, of class Client.
     */
    @Test
    public void testSetIdNumber() {
        System.out.println("setIdNumber");
        String idNumber = "";
        Client instance = new Client();
        instance.setIdNumber(idNumber);

    }

    /**
     * Test of getName method, of class Client.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Client instance = new Client();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);

    }

    /**
     * Test of setName method, of class Client.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Client instance = new Client();
        instance.setName(name);

    }

    /**
     * Test of getPhone method, of class Client.
     */
    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        Client instance = new Client();
        String expResult = "";
        String result = instance.getPhone();
        assertEquals(expResult, result);

    }

    /**
     * Test of setPhone method, of class Client.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        String phone = "";
        Client instance = new Client();
        instance.setPhone(phone);

    }

    /**
     * Test of getEmail method, of class Client.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Client instance = new Client();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);

    }

    /**
     * Test of setEmail method, of class Client.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Client instance = new Client();
        instance.setEmail(email);

    }

    /**
     * Test of getAddress method, of class Client.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Client instance = new Client();
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);

    }

    /**
     * Test of setAddress method, of class Client.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        Client instance = new Client();
        instance.setAddress(address);

    }

    /**
     * Test of toString method, of class Client.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Client instance = new Client();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);

    }
    
}
