/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.legalsync.model;

import java.time.LocalDate;
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
public class CaseFileTest {

    private Client client;
    private Defendant defendant;
    private Lawyer lawyer;

    public CaseFileTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        client = new Client(1, "Maria Lopez", "1712345678", "0991234567", "mlopez@mail.com", "Quito");
        defendant = new Defendant(1, "Jorge Salazar", "1723456789", "0987654321", "Sangolqui");
        lawyer = new Lawyer(2, "Carlos Mena", "cmena", "lawyer123", Role.LAWYER, "Litigation Lawyer", "LIC-0102");
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of register method, of class CaseFile.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        CaseFile instance = new CaseFile(1, "17230-2026-00101", "Breach of contract", client, defendant, lawyer);
        boolean expResult = true;
        boolean result = instance.register();
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class CaseFile.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        CaseFile instance = new CaseFile(1, "17230-2026-00101", "Breach of contract", client, defendant, lawyer);
        instance.setStatus(CaseStatus.CLOSED);
        boolean expResult = false;
        boolean result = instance.update();
        assertEquals(expResult, result);
    }

    /**
     * Test of validateMandatoryFields method, of class CaseFile.
     */
    @Test
    public void testValidateMandatoryFields() {
        System.out.println("validateMandatoryFields");
        CaseFile instance = new CaseFile(1, "", "Breach of contract", client, defendant, null);
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
        Document document = new Document(1, "Contract", "", "C:\\cases\\contract.pdf");
        CaseFile instance = new CaseFile(1, "17230-2026-00101", "Breach of contract", client, defendant, lawyer);
        instance.addDocument(document);
        assertEquals(1, instance.getDocuments().size());
        assertEquals("PDF", document.getType());
    }

    /**
     * Test of addEvidence method, of class CaseFile.
     */
    @Test
    public void testAddEvidence() {
        System.out.println("addEvidence");
        Evidence evidence = new Evidence(1, "Photo of the property", "Photo", "C:\\cases\\photo.jpg",
                LocalDate.now().plusDays(3));
        CaseFile instance = new CaseFile(1, "17230-2026-00101", "Breach of contract", client, defendant, lawyer);
        instance.addEvidence(evidence);
        assertEquals(0, instance.getEvidences().size());
    }

    /**
     * Test of addDeadline method, of class CaseFile.
     */
    @Test
    public void testAddDeadline() {
        System.out.println("addDeadline");
        Deadline deadline = new Deadline(1, 0, "Preliminary hearing", "Hearing", LocalDate.now().plusDays(10), 5);
        CaseFile instance = new CaseFile(7, "17230-2026-00101", "Breach of contract", client, defendant, lawyer);
        instance.addDeadline(deadline);
        assertEquals(1, instance.getDeadlines().size());
        assertEquals(7, deadline.getCaseId());
    }

    /**
     * Test of getDetails method, of class CaseFile.
     */
    @Test
    public void testGetDetails() {
        System.out.println("getDetails");
        CaseFile instance = new CaseFile(1, "17230-2026-00101", "Breach of contract", client, defendant, null);
        String result = instance.getDetails();
        assertTrue(result.contains("17230-2026-00101"));
    }

}
