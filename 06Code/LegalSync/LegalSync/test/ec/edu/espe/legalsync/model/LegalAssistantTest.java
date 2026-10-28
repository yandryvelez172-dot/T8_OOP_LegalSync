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
public class LegalAssistantTest {
    
    public LegalAssistantTest() {
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
     * Test of getDetails method, of class LegalAssistant.
     */
    @Test
    public void testGetDetails() {
        System.out.println("getDetails");
        LegalAssistant instance = new LegalAssistant();
        String expResult = "";
        String result = instance.getDetails();
        assertEquals(expResult, result);

    }

    /**
     * Test of getAssistantId method, of class LegalAssistant.
     */
    @Test
    public void testGetAssistantId() {
        System.out.println("getAssistantId");
        LegalAssistant instance = new LegalAssistant();
        int expResult = 0;
        int result = instance.getAssistantId();
        assertEquals(expResult, result);

    }

    /**
     * Test of setAssistantId method, of class LegalAssistant.
     */
    @Test
    public void testSetAssistantId() {
        System.out.println("setAssistantId");
        int assistantId = 0;
        LegalAssistant instance = new LegalAssistant();
        instance.setAssistantId(assistantId);

    }

    /**
     * Test of getName method, of class LegalAssistant.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        LegalAssistant instance = new LegalAssistant();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);

    }

    /**
     * Test of setName method, of class LegalAssistant.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        LegalAssistant instance = new LegalAssistant();
        instance.setName(name);

    }

    /**
     * Test of getEmail method, of class LegalAssistant.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        LegalAssistant instance = new LegalAssistant();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);

    }

    /**
     * Test of setEmail method, of class LegalAssistant.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        LegalAssistant instance = new LegalAssistant();
        instance.setEmail(email);

    }

    /**
     * Test of getJudicialUnit method, of class LegalAssistant.
     */
    @Test
    public void testGetJudicialUnit() {
        System.out.println("getJudicialUnit");
        LegalAssistant instance = new LegalAssistant();
        String expResult = "";
        String result = instance.getJudicialUnit();
        assertEquals(expResult, result);

    }

    /**
     * Test of setJudicialUnit method, of class LegalAssistant.
     */
    @Test
    public void testSetJudicialUnit() {
        System.out.println("setJudicialUnit");
        String judicialUnit = "";
        LegalAssistant instance = new LegalAssistant();
        instance.setJudicialUnit(judicialUnit);

    }

    /**
     * Test of toString method, of class LegalAssistant.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        LegalAssistant instance = new LegalAssistant();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);

    }
    
}
