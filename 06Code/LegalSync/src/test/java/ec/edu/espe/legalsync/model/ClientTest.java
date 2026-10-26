/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.legalsync.model;

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
public class ClientTest {

    public ClientTest() {
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
     * Test of register method, of class Client.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        Client instance = new Client(1, "Maria Lopez", "1712345678", "0991234567", "mlopez@mail.com", "Quito");
        boolean expResult = true;
        boolean result = instance.register();
        assertEquals(expResult, result);
    }

    /**
     * Test of register method with a wrong id number, of class Client.
     */
    @Test
    public void testRegisterWrongIdNumber() {
        System.out.println("register wrong id number");
        Client instance = new Client(1, "Maria Lopez", "17123", "0991234567", "mlopez@mail.com", "Quito");
        boolean expResult = false;
        boolean result = instance.register();
        assertEquals(expResult, result);
    }

    /**
     * Test of register method with an id number written with a dash, of class Client.
     */
    @Test
    public void testRegisterIdNumberWithDash() {
        System.out.println("register id number with dash");
        Client instance = new Client(1, "Maria Lopez", "171234567-8", "0991234567", "mlopez@mail.com", "Quito");
        boolean expResult = true;
        boolean result = instance.register();
        assertEquals(expResult, result);
    }

}
