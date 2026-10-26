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
public class DeadlineTest {

    public DeadlineTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of calculateRemainingDays method, of class Deadline.
     */
    @Test
    public void testCalculateRemainingDays() {
        System.out.println("calculateRemainingDays");
        Deadline instance = new Deadline(1, 1, "Preliminary hearing", "Hearing", LocalDate.now().plusDays(5), 3);
        int expResult = 5;
        int result = instance.calculateRemainingDays();
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateRemainingDays method with the default values, of class Deadline.
     */
    @Test
    public void testCalculateRemainingDaysWithoutDate() {
        System.out.println("calculateRemainingDays without target date");
        Deadline instance = new Deadline(0, 0, "", "", null, 0);
        int expResult = 0;
        int result = instance.calculateRemainingDays();
        assertEquals(expResult, result);
    }

    /**
     * Test of isApproaching method, of class Deadline.
     */
    @Test
    public void testIsApproaching() {
        System.out.println("isApproaching");
        Deadline instance = new Deadline(1, 1, "Preliminary hearing", "Hearing", LocalDate.now().plusDays(2), 3);
        boolean expResult = true;
        boolean result = instance.isApproaching();
        assertEquals(expResult, result);
    }

    /**
     * Test of generateAlertMessage method, of class Deadline.
     */
    @Test
    public void testGenerateAlertMessage() {
        System.out.println("generateAlertMessage");
        Deadline instance = new Deadline(1, 1, "Appeal submission", "Appeal", LocalDate.now().minusDays(1), 3);
        String result = instance.generateAlertMessage();
        assertTrue(result.startsWith("OVERDUE"));
    }

    /**
     * Test of markCompleted method, of class Deadline.
     */
    @Test
    public void testMarkCompleted() {
        System.out.println("markCompleted");
        Deadline instance = new Deadline(1, 1, "Preliminary hearing", "Hearing", LocalDate.now().plusDays(1), 3);
        instance.markCompleted();
        assertTrue(instance.isCompleted());
        assertFalse(instance.isApproaching());
    }

}
