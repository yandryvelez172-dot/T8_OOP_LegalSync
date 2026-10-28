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
public class ExpenseTest {
    
    public ExpenseTest() {
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
     * Test of markAsPaid method, of class Expense.
     */
    @Test
    public void testMarkAsPaid() {
        System.out.println("markAsPaid");
        Expense instance = new Expense();
        instance.markAsPaid();
        
        
    }

    /**
     * Test of getDetails method, of class Expense.
     */
    @Test
    public void testGetDetails() {
        System.out.println("getDetails");
        Expense instance = new Expense();
        String expResult = "";
        String result = instance.getDetails();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getExpenseId method, of class Expense.
     */
    @Test
    public void testGetExpenseId() {
        System.out.println("getExpenseId");
        Expense instance = new Expense();
        int expResult = 0;
        int result = instance.getExpenseId();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setExpenseId method, of class Expense.
     */
    @Test
    public void testSetExpenseId() {
        System.out.println("setExpenseId");
        int expenseId = 0;
        Expense instance = new Expense();
        instance.setExpenseId(expenseId);
        
        
    }

    /**
     * Test of getCaseId method, of class Expense.
     */
    @Test
    public void testGetCaseId() {
        System.out.println("getCaseId");
        Expense instance = new Expense();
        int expResult = 0;
        int result = instance.getCaseId();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setCaseId method, of class Expense.
     */
    @Test
    public void testSetCaseId() {
        System.out.println("setCaseId");
        int caseId = 0;
        Expense instance = new Expense();
        instance.setCaseId(caseId);
        
        
    }

    /**
     * Test of getDescription method, of class Expense.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Expense instance = new Expense();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setDescription method, of class Expense.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Expense instance = new Expense();
        instance.setDescription(description);
        
        
    }

    /**
     * Test of getAmount method, of class Expense.
     */
    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        Expense instance = new Expense();
        double expResult = 0.0;
        double result = instance.getAmount();
        assertEquals(expResult, result, 0);
        
        
    }

    /**
     * Test of setAmount method, of class Expense.
     */
    @Test
    public void testSetAmount() {
        System.out.println("setAmount");
        double amount = 0.0;
        Expense instance = new Expense();
        instance.setAmount(amount);
        
        
    }

    /**
     * Test of getExpenseDate method, of class Expense.
     */
    @Test
    public void testGetExpenseDate() {
        System.out.println("getExpenseDate");
        Expense instance = new Expense();
        String expResult = "";
        String result = instance.getExpenseDate();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setExpenseDate method, of class Expense.
     */
    @Test
    public void testSetExpenseDate() {
        System.out.println("setExpenseDate");
        String expenseDate = "";
        Expense instance = new Expense();
        instance.setExpenseDate(expenseDate);
        
        
    }

    /**
     * Test of isPaid method, of class Expense.
     */
    @Test
    public void testIsPaid() {
        System.out.println("isPaid");
        Expense instance = new Expense();
        boolean expResult = false;
        boolean result = instance.isPaid();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setPaid method, of class Expense.
     */
    @Test
    public void testSetPaid() {
        System.out.println("setPaid");
        boolean paid = false;
        Expense instance = new Expense();
        instance.setPaid(paid);
        
        
    }

    /**
     * Test of toString method, of class Expense.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Expense instance = new Expense();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
    }
    
}
