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
public class DocumentTest {
    
    public DocumentTest() {
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
     * Test of register method, of class Document.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        Document instance = new Document();
        boolean expResult = false;
        boolean result = instance.register();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getDetails method, of class Document.
     */
    @Test
    public void testGetDetails() {
        System.out.println("getDetails");
        Document instance = new Document();
        String expResult = "";
        String result = instance.getDetails();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getDocumentId method, of class Document.
     */
    @Test
    public void testGetDocumentId() {
        System.out.println("getDocumentId");
        Document instance = new Document();
        int expResult = 0;
        int result = instance.getDocumentId();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setDocumentId method, of class Document.
     */
    @Test
    public void testSetDocumentId() {
        System.out.println("setDocumentId");
        int documentId = 0;
        Document instance = new Document();
        instance.setDocumentId(documentId);
        
        
    }

    /**
     * Test of getName method, of class Document.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Document instance = new Document();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setName method, of class Document.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Document instance = new Document();
        instance.setName(name);
        
        
    }

    /**
     * Test of getType method, of class Document.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Document instance = new Document();
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setType method, of class Document.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "";
        Document instance = new Document();
        instance.setType(type);
        
        
    }

    /**
     * Test of getFilePath method, of class Document.
     */
    @Test
    public void testGetFilePath() {
        System.out.println("getFilePath");
        Document instance = new Document();
        String expResult = "";
        String result = instance.getFilePath();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setFilePath method, of class Document.
     */
    @Test
    public void testSetFilePath() {
        System.out.println("setFilePath");
        String filePath = "";
        Document instance = new Document();
        instance.setFilePath(filePath);
        
        
    }

    /**
     * Test of getUploadDate method, of class Document.
     */
    @Test
    public void testGetUploadDate() {
        System.out.println("getUploadDate");
        Document instance = new Document();
        String expResult = "";
        String result = instance.getUploadDate();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setUploadDate method, of class Document.
     */
    @Test
    public void testSetUploadDate() {
        System.out.println("setUploadDate");
        String uploadDate = "";
        Document instance = new Document();
        instance.setUploadDate(uploadDate);
        
        
    }

    /**
     * Test of toString method, of class Document.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Document instance = new Document();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
    }
    
}
