package ec.edu.espe.legalsync.utils;

import ec.edu.espe.legalsync.model.AuditEntry;
import ec.edu.espe.legalsync.model.CaseFile;
import ec.edu.espe.legalsync.model.Client;
import ec.edu.espe.legalsync.model.User;
import java.util.List;
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
public class FileManagerTest {
    
    public FileManagerTest() {
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
     * Test of ensureDirectories method, of class FileManager.
     */
    @Test
    public void testEnsureDirectories() {
        System.out.println("ensureDirectories");
        FileManager.ensureDirectories();

    }

    /**
     * Test of saveUsersToJson method, of class FileManager.
     */
    @Test
    public void testSaveUsersToJson() {
        System.out.println("saveUsersToJson");
        List<User> users = null;
        FileManager.saveUsersToJson(users);

    }

    /**
     * Test of loadUsersFromJson method, of class FileManager.
     */
    @Test
    public void testLoadUsersFromJson() {
        System.out.println("loadUsersFromJson");
        List<User> expResult = null;
        List<User> result = FileManager.loadUsersFromJson();
        assertEquals(expResult, result);

    }

    /**
     * Test of saveClientsToJson method, of class FileManager.
     */
    @Test
    public void testSaveClientsToJson() {
        System.out.println("saveClientsToJson");
        List<Client> clients = null;
        FileManager.saveClientsToJson(clients);

    }

    /**
     * Test of loadClientsFromJson method, of class FileManager.
     */
    @Test
    public void testLoadClientsFromJson() {
        System.out.println("loadClientsFromJson");
        List<Client> expResult = null;
        List<Client> result = FileManager.loadClientsFromJson();
        assertEquals(expResult, result);

    }

    /**
     * Test of saveAuditToJson method, of class FileManager.
     */
    @Test
    public void testSaveAuditToJson() {
        System.out.println("saveAuditToJson");
        List<AuditEntry> entries = null;
        FileManager.saveAuditToJson(entries);

    }

    /**
     * Test of loadAuditFromJson method, of class FileManager.
     */
    @Test
    public void testLoadAuditFromJson() {
        System.out.println("loadAuditFromJson");
        List<AuditEntry> expResult = null;
        List<AuditEntry> result = FileManager.loadAuditFromJson();
        assertEquals(expResult, result);

    }

    /**
     * Test of saveCasesToJson method, of class FileManager.
     */
    @Test
    public void testSaveCasesToJson() {
        System.out.println("saveCasesToJson");
        List<CaseFile> cases = null;
        FileManager.saveCasesToJson(cases);

    }

    /**
     * Test of loadCasesFromJson method, of class FileManager.
     */
    @Test
    public void testLoadCasesFromJson() {
        System.out.println("loadCasesFromJson");
        List<Client> knownClients = null;
        List<CaseFile> expResult = null;
        List<CaseFile> result = FileManager.loadCasesFromJson(knownClients);
        assertEquals(expResult, result);

    }

    /**
     * Test of generateCsvReports method, of class FileManager.
     */
    @Test
    public void testGenerateCsvReports() {
        System.out.println("generateCsvReports");
        List<CaseFile> cases = null;
        boolean expResult = false;
        boolean result = FileManager.generateCsvReports(cases);
        assertEquals(expResult, result);

    }
    
}
