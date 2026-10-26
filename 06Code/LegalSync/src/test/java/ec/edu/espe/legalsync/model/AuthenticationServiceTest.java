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
public class AuthenticationServiceTest {

    public AuthenticationServiceTest() {
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
     * Test of authenticate method, of class AuthenticationService.
     */
    @Test
    public void testAuthenticate() {
        System.out.println("authenticate");
        AuthenticationService instance = new AuthenticationService("data/credentials.txt", 3);
        instance.loadCredentials();
        User result = instance.authenticate("atorres", "partner123");
        assertNotNull(result);
        assertEquals(Role.PARTNER, result.getRole());
    }

    /**
     * Test of maskPassword method, of class AuthenticationService.
     */
    @Test
    public void testMaskPassword() {
        System.out.println("maskPassword");
        String input = "partner123";
        AuthenticationService instance = new AuthenticationService("data/credentials.txt", 3);
        String expResult = "**********";
        String result = instance.maskPassword(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of maskPassword method with a null password, of class AuthenticationService.
     */
    @Test
    public void testMaskPasswordNull() {
        System.out.println("maskPassword null");
        String input = null;
        AuthenticationService instance = new AuthenticationService("data/credentials.txt", 3);
        String expResult = "";
        String result = instance.maskPassword(input);
        assertEquals(expResult, result);
    }

}
