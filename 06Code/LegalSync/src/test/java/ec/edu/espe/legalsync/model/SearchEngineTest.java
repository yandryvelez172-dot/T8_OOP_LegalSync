/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.legalsync.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author CodeLex, @ESPE
 */
public class SearchEngineTest {

    private List<CaseFile> caseFiles;

    public SearchEngineTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        Lawyer lawyer = new Lawyer(2, "Carlos Mena", "cmena", "lawyer123", Role.LAWYER, "Lawyer", "LIC-0102");
        Client maria = new Client(1, "Maria Fernanda Lopez", "1712345678", "", "", "");
        Client pedro = new Client(2, "Pedro Andrade", "1709876543", "", "", "");
        Defendant defendant = new Defendant(1, "Jorge Salazar", "", "", "");
        caseFiles = new ArrayList<>();
        caseFiles.add(new CaseFile(1, "17230-2026-00101", "Lease contract", maria, defendant, lawyer));
        caseFiles.add(new CaseFile(2, "17204-2026-00230", "Wrongful dismissal", pedro, defendant, lawyer));
        caseFiles.add(new CaseFile(3, "17230-2026-00312", "Child support", maria, defendant, lawyer));
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of searchByClientName method, of class SearchEngine.
     */
    @Test
    public void testSearchByClientName() {
        System.out.println("searchByClientName");
        String clientName = "LOPEZ";
        SearchEngine instance = new SearchEngine();
        instance.loadData(caseFiles);
        int expResult = 2;
        List<CaseFile> result = instance.searchByClientName(clientName);
        assertEquals(expResult, result.size());
    }

    /**
     * Test of searchByClientName method with an empty name, of class SearchEngine.
     */
    @Test
    public void testSearchByClientNameEmpty() {
        System.out.println("searchByClientName empty");
        String clientName = "";
        SearchEngine instance = new SearchEngine();
        instance.loadData(caseFiles);
        int expResult = 0;
        List<CaseFile> result = instance.searchByClientName(clientName);
        assertEquals(expResult, result.size());
    }

    /**
     * Test of findByDocketNumber method, of class SearchEngine.
     */
    @Test
    public void testFindByDocketNumber() {
        System.out.println("findByDocketNumber");
        SearchEngine instance = new SearchEngine();
        instance.loadData(caseFiles);
        CaseFile result = instance.findByDocketNumber("17204-2026-00230");
        assertEquals("Pedro Andrade", result.getClient().getName());
    }

}
