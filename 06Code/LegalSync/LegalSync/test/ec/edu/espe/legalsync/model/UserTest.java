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
public class UserTest {
    
    public UserTest() {
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
     * Test of isValidRole method, of class User.
     */
    @Test
    public void testIsValidRole() {
        System.out.println("isValidRole");
        String roleToCheck = "";
        boolean expResult = false;
        boolean result = User.isValidRole(roleToCheck);
        assertEquals(expResult, result);

    }

    /**
     * Test of login method, of class User.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String inputEmail = "";
        String inputPassword = "";
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.login(inputEmail, inputPassword);
        assertEquals(expResult, result);

    }

    /**
     * Test of logout method, of class User.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        User instance = new User();
        instance.logout();

    }

    /**
     * Test of changePassword method, of class User.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        String oldPass = "";
        String newPass = "";
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.changePassword(oldPass, newPass);
        assertEquals(expResult, result);

    }

    /**
     * Test of hasPermission method, of class User.
     */
    @Test
    public void testHasPermission() {
        System.out.println("hasPermission");
        String operationType = "";
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.hasPermission(operationType);
        assertEquals(expResult, result);

    }

    /**
     * Test of getUserId method, of class User.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        User instance = new User();
        int expResult = 0;
        int result = instance.getUserId();
        assertEquals(expResult, result);

    }

    /**
     * Test of setUserId method, of class User.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        int userId = 0;
        User instance = new User();
        instance.setUserId(userId);

    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        User instance = new User();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);

    }

    /**
     * Test of setName method, of class User.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        User instance = new User();
        instance.setName(name);

    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        User instance = new User();
        instance.setEmail(email);

    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = new User();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);

    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        User instance = new User();
        instance.setPassword(password);

    }

    /**
     * Test of getRole method, of class User.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        User instance = new User();
        String expResult = "";
        String result = instance.getRole();
        assertEquals(expResult, result);

    }

    /**
     * Test of setRole method, of class User.
     */
    @Test
    public void testSetRole() {
        System.out.println("setRole");
        String role = "";
        User instance = new User();
        instance.setRole(role);

    }

    /**
     * Test of isActive method, of class User.
     */
    @Test
    public void testIsActive() {
        System.out.println("isActive");
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.isActive();
        assertEquals(expResult, result);

    }

    /**
     * Test of setActive method, of class User.
     */
    @Test
    public void testSetActive() {
        System.out.println("setActive");
        boolean active = false;
        User instance = new User();
        instance.setActive(active);

    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        User instance = new User();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);

    }
    
}
