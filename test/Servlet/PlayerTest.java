/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chalaka
 */
public class PlayerTest {
    
    public PlayerTest() {
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
     * Test of getId method, of class Player.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Player instance = null;
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJsonString method, of class Player.
     */
    @Test
    public void testSetJsonString() {
        System.out.println("setJsonString");
        String st = "";
        Player instance = null;
        instance.setJsonString(st);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJsonString method, of class Player.
     */
    @Test
    public void testGetJsonString() {
        System.out.println("getJsonString");
        Player instance = null;
        String expResult = "";
        String result = instance.getJsonString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCards method, of class Player.
     */
    @Test
    public void testSetCards() {
        System.out.println("setCards");
        ArrayList<String> cards = null;
        Player instance = null;
        instance.setCards(cards);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCards method, of class Player.
     */
    @Test
    public void testGetCards() {
        System.out.println("getCards");
        Player instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getCards();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCard method, of class Player.
     */
    @Test
    public void testRemoveCard() {
        System.out.println("removeCard");
        String card = "";
        Player instance = null;
        instance.removeCard(card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPlayablity method, of class Player.
     */
    @Test
    public void testCheckPlayablity() {
        System.out.println("checkPlayablity");
        String currentHandCardType = "main/webapp/cards/0_1.png";
        String currentCard = "main/webapp/cards/0_2.png";
        Player instance = new Player("555");
        boolean expResult = true;
        boolean result = instance.checkPlayablity(currentHandCardType, currentCard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
