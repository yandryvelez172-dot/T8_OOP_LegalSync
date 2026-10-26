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
public class UserTest {

    public UserTest() {
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
     * Test of login method, of class User.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "cmena";
        String password = "lawyer123";
        User instance = new User(2, "Carlos Mena", "cmena", "lawyer123", Role.LAWYER);
        boolean expResult = true;
        boolean result = instance.login(username, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of login method with an inactive user, of class User.
     */
    @Test
    public void testLoginInactiveUser() {
        System.out.println("login inactive user");
        User instance = new User(2, "Carlos Mena", "cmena", "lawyer123", Role.LAWYER);
        instance.setActive(false);
        boolean result = instance.login("cmena", "lawyer123");
        assertFalse(result);
    }

    /**
     * Test of changePassword method, of class User.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        String oldPass = "lawyer123";
        String newPass = "abc";
        User instance = new User(2, "Carlos Mena", "cmena", "lawyer123", Role.LAWYER);
        boolean expResult = false;
        boolean result = instance.changePassword(oldPass, newPass);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasPermission method, of class User.
     */
    @Test
    public void testHasPermission() {
        System.out.println("hasPermission");
        User instance = new User(4, "Luis Paredes", "lparedes", "assist123", Role.LEGAL_ASSISTANT);
        assertTrue(instance.hasPermission("IMPORT_CSV"));
        assertFalse(instance.hasPermission("MANAGE_USERS"));
    }

    /**
     * Test of login method with the username in capital letters, of class User.
     */
    @Test
    public void testLoginUppercaseUsername() {
        System.out.println("login uppercase username");
        User instance = new User(2, "Carlos Mena", "cmena", "lawyer123", Role.LAWYER);
        boolean expResult = true;
        boolean result = instance.login("CMENA", "lawyer123");
        assertEquals(expResult, result);
    }

}
