package ec.edu.espe.legalsync.model;

import java.util.List;
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
public class CaseFileTest {
    
    public CaseFileTest() {
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
     * Test of isValidValue method, of class CaseFile.
     */
    @Test
    public void testIsValidValue() {
        System.out.println("isValidValue");
        String value = "";
        String[] allowedValues = null;
        boolean expResult = false;
        boolean result = CaseFile.isValidValue(value, allowedValues);
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of validateMandatoryFields method, of class CaseFile.
     */
    @Test
    public void testValidateMandatoryFields() {
        System.out.println("validateMandatoryFields");
        CaseFile instance = new CaseFile();
        boolean expResult = false;
        boolean result = instance.validateMandatoryFields();
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of addDocument method, of class CaseFile.
     */
    @Test
    public void testAddDocument() {
        System.out.println("addDocument");
        Document document = null;
        CaseFile instance = new CaseFile();
        instance.addDocument(document);
        
      
    }

    /**
     * Test of addDeadline method, of class CaseFile.
     */
    @Test
    public void testAddDeadline() {
        System.out.println("addDeadline");
        Deadline deadline = null;
        CaseFile instance = new CaseFile();
        instance.addDeadline(deadline);
        
      
    }

    /**
     * Test of addExpense method, of class CaseFile.
     */
    @Test
    public void testAddExpense() {
        System.out.println("addExpense");
        Expense expense = null;
        CaseFile instance = new CaseFile();
        instance.addExpense(expense);
        
      
    }

    /**
     * Test of calculateTotalBilled method, of class CaseFile.
     */
    @Test
    public void testCalculateTotalBilled() {
        System.out.println("calculateTotalBilled");
        CaseFile instance = new CaseFile();
        double expResult = 0.0;
        double result = instance.calculateTotalBilled();
        assertEquals(expResult, result, 0);
        
      
    }

    /**
     * Test of calculateTotalDebt method, of class CaseFile.
     */
    @Test
    public void testCalculateTotalDebt() {
        System.out.println("calculateTotalDebt");
        CaseFile instance = new CaseFile();
        double expResult = 0.0;
        double result = instance.calculateTotalDebt();
        assertEquals(expResult, result, 0);
        
      
    }

    /**
     * Test of isPaidInFull method, of class CaseFile.
     */
    @Test
    public void testIsPaidInFull() {
        System.out.println("isPaidInFull");
        CaseFile instance = new CaseFile();
        boolean expResult = false;
        boolean result = instance.isPaidInFull();
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of getSummary method, of class CaseFile.
     */
    @Test
    public void testGetSummary() {
        System.out.println("getSummary");
        CaseFile instance = new CaseFile();
        String expResult = "";
        String result = instance.getSummary();
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of getCaseId method, of class CaseFile.
     */
    @Test
    public void testGetCaseId() {
        System.out.println("getCaseId");
        CaseFile instance = new CaseFile();
        int expResult = 0;
        int result = instance.getCaseId();
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of setCaseId method, of class CaseFile.
     */
    @Test
    public void testSetCaseId() {
        System.out.println("setCaseId");
        int caseId = 0;
        CaseFile instance = new CaseFile();
        instance.setCaseId(caseId);
        
      
    }

    /**
     * Test of getDocketNumber method, of class CaseFile.
     */
    @Test
    public void testGetDocketNumber() {
        System.out.println("getDocketNumber");
        CaseFile instance = new CaseFile();
        String expResult = "";
        String result = instance.getDocketNumber();
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of setDocketNumber method, of class CaseFile.
     */
    @Test
    public void testSetDocketNumber() {
        System.out.println("setDocketNumber");
        String docketNumber = "";
        CaseFile instance = new CaseFile();
        instance.setDocketNumber(docketNumber);
        
      
    }

    /**
     * Test of getTitle method, of class CaseFile.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        CaseFile instance = new CaseFile();
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of setTitle method, of class CaseFile.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        CaseFile instance = new CaseFile();
        instance.setTitle(title);
        
      
    }

    /**
     * Test of getProcessClass method, of class CaseFile.
     */
    @Test
    public void testGetProcessClass() {
        System.out.println("getProcessClass");
        CaseFile instance = new CaseFile();
        String expResult = "";
        String result = instance.getProcessClass();
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of setProcessClass method, of class CaseFile.
     */
    @Test
    public void testSetProcessClass() {
        System.out.println("setProcessClass");
        String processClass = "";
        CaseFile instance = new CaseFile();
        instance.setProcessClass(processClass);
        
      
    }

    /**
     * Test of getCategory method, of class CaseFile.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        CaseFile instance = new CaseFile();
        String expResult = "";
        String result = instance.getCategory();
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of setCategory method, of class CaseFile.
     */
    @Test
    public void testSetCategory() {
        System.out.println("setCategory");
        String category = "";
        CaseFile instance = new CaseFile();
        instance.setCategory(category);
        
      
    }

    /**
     * Test of getPriority method, of class CaseFile.
     */
    @Test
    public void testGetPriority() {
        System.out.println("getPriority");
        CaseFile instance = new CaseFile();
        String expResult = "";
        String result = instance.getPriority();
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of setPriority method, of class CaseFile.
     */
    @Test
    public void testSetPriority() {
        System.out.println("setPriority");
        String priority = "";
        CaseFile instance = new CaseFile();
        instance.setPriority(priority);
        
      
    }

    /**
     * Test of getJudicialUnit method, of class CaseFile.
     */
    @Test
    public void testGetJudicialUnit() {
        System.out.println("getJudicialUnit");
        CaseFile instance = new CaseFile();
        String expResult = "";
        String result = instance.getJudicialUnit();
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of setJudicialUnit method, of class CaseFile.
     */
    @Test
    public void testSetJudicialUnit() {
        System.out.println("setJudicialUnit");
        String judicialUnit = "";
        CaseFile instance = new CaseFile();
        instance.setJudicialUnit(judicialUnit);
        
      
    }

    /**
     * Test of getStatus method, of class CaseFile.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        CaseFile instance = new CaseFile();
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of setStatus method, of class CaseFile.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "";
        CaseFile instance = new CaseFile();
        instance.setStatus(status);
        
      
    }

    /**
     * Test of getOpeningDate method, of class CaseFile.
     */
    @Test
    public void testGetOpeningDate() {
        System.out.println("getOpeningDate");
        CaseFile instance = new CaseFile();
        String expResult = "";
        String result = instance.getOpeningDate();
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of setOpeningDate method, of class CaseFile.
     */
    @Test
    public void testSetOpeningDate() {
        System.out.println("setOpeningDate");
        String openingDate = "";
        CaseFile instance = new CaseFile();
        instance.setOpeningDate(openingDate);
        
      
    }

    /**
     * Test of getClient method, of class CaseFile.
     */
    @Test
    public void testGetClient() {
        System.out.println("getClient");
        CaseFile instance = new CaseFile();
        Client expResult = null;
        Client result = instance.getClient();
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of setClient method, of class CaseFile.
     */
    @Test
    public void testSetClient() {
        System.out.println("setClient");
        Client client = null;
        CaseFile instance = new CaseFile();
        instance.setClient(client);
        
      
    }

    /**
     * Test of getDefendant method, of class CaseFile.
     */
    @Test
    public void testGetDefendant() {
        System.out.println("getDefendant");
        CaseFile instance = new CaseFile();
        Defendant expResult = null;
        Defendant result = instance.getDefendant();
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of setDefendant method, of class CaseFile.
     */
    @Test
    public void testSetDefendant() {
        System.out.println("setDefendant");
        Defendant defendant = null;
        CaseFile instance = new CaseFile();
        instance.setDefendant(defendant);
        
      
    }

    /**
     * Test of getAssignedLawyer method, of class CaseFile.
     */
    @Test
    public void testGetAssignedLawyer() {
        System.out.println("getAssignedLawyer");
        CaseFile instance = new CaseFile();
        Lawyer expResult = null;
        Lawyer result = instance.getAssignedLawyer();
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of setAssignedLawyer method, of class CaseFile.
     */
    @Test
    public void testSetAssignedLawyer() {
        System.out.println("setAssignedLawyer");
        Lawyer assignedLawyer = null;
        CaseFile instance = new CaseFile();
        instance.setAssignedLawyer(assignedLawyer);
        
      
    }

    /**
     * Test of getDocuments method, of class CaseFile.
     */
    @Test
    public void testGetDocuments() {
        System.out.println("getDocuments");
        CaseFile instance = new CaseFile();
        List<Document> expResult = null;
        List<Document> result = instance.getDocuments();
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of setDocuments method, of class CaseFile.
     */
    @Test
    public void testSetDocuments() {
        System.out.println("setDocuments");
        List<Document> documents = null;
        CaseFile instance = new CaseFile();
        instance.setDocuments(documents);
        
      
    }

    /**
     * Test of getDeadlines method, of class CaseFile.
     */
    @Test
    public void testGetDeadlines() {
        System.out.println("getDeadlines");
        CaseFile instance = new CaseFile();
        List<Deadline> expResult = null;
        List<Deadline> result = instance.getDeadlines();
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of setDeadlines method, of class CaseFile.
     */
    @Test
    public void testSetDeadlines() {
        System.out.println("setDeadlines");
        List<Deadline> deadlines = null;
        CaseFile instance = new CaseFile();
        instance.setDeadlines(deadlines);
        
      
    }

    /**
     * Test of getExpenses method, of class CaseFile.
     */
    @Test
    public void testGetExpenses() {
        System.out.println("getExpenses");
        CaseFile instance = new CaseFile();
        List<Expense> expResult = null;
        List<Expense> result = instance.getExpenses();
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of setExpenses method, of class CaseFile.
     */
    @Test
    public void testSetExpenses() {
        System.out.println("setExpenses");
        List<Expense> expenses = null;
        CaseFile instance = new CaseFile();
        instance.setExpenses(expenses);
        
      
    }

    /**
     * Test of toString method, of class CaseFile.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        CaseFile instance = new CaseFile();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
      
    }
    
}
