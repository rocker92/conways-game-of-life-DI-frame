/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomas.gameoflife;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lovas
 */
public class CellRuleSetTest {

    public CellRuleSetTest() {
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
     * Test of analyzeCell method, of class CellRuleSet.
     */
    @Test
    public void testAnalyzeCell() {
        System.out.println("analyzeCell");
        Cell cell = null;
        List<Cell> cells = null;
        CellRuleSet instance = new CellRuleSet();
        boolean expResult = false;
        boolean result = instance.analyzeCell(cell, cells);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNeighbours method, of class CellRuleSet.
     */
    @Test
    public void testGetNeighbours() {
        System.out.println("getNeighbours");
        Cell cell = null;
        CellRuleSet instance = new CellRuleSet();
        List<Cell> expResult = null;
        List<Cell> result = instance.getNeighbours(cell);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAlive method, of class CellRuleSet.
     */
    @Test
    public void testIsAlive() {
        Cell cell = new Cell(2, 2);
        List<Cell> cells = new ArrayList<>();
        cells.add(cell);
        CellRuleSet instance = new CellRuleSet();
        boolean expResult = true;
        boolean result = instance.isAlive(cell, cells);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNotAlive() {
        Cell cell = new Cell(2, 2);
        List<Cell> cells = new ArrayList<>();
        cells.add(new Cell(1, 1));
        CellRuleSet instance = new CellRuleSet();
        boolean expResult = false;
        boolean result = instance.isAlive(cell, cells);
        assertEquals(expResult, result);
    }

    /**
     * Test of countAliveNeighbours method, of class CellRuleSet.
     */
    @Test
    public void testCountAliveNeighbours() {
        Cell cell = new Cell(2, 2);
        List<Cell> cells = new ArrayList<>();
        cells.add(new Cell(1, 2));
        cells.add(cell);
        cells.add(new Cell(10, 10));
        CellRuleSet instance = new CellRuleSet();
        int expResult = 1;
        int result = instance.countAliveNeighbours(cell, cells);
        assertEquals(expResult, result);
    }

    /**
     * Test of isNeighbour method, of class CellRuleSet.
     */
    @Test
    public void testIsNeighbour() {
        Cell cell1 = new Cell(2, 2);
        Cell cell2 = new Cell(2, 3);
        CellRuleSet instance = new CellRuleSet();
        boolean expResult = true;
        boolean result = instance.isNeighbour(cell1, cell2);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNeighbourSame() {
        Cell cell1 = new Cell(2, 2);
        CellRuleSet instance = new CellRuleSet();
        boolean expResult = false;
        boolean result = instance.isNeighbour(cell1, cell1);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNotNeighbour() {
        Cell cell1 = new Cell(2, 2);
        Cell cell2 = new Cell(0, 3);
        CellRuleSet instance = new CellRuleSet();
        boolean expResult = false;
        boolean result = instance.isNeighbour(cell1, cell2);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkReproduction method, of class CellRuleSet.
     */
    @Test
    public void testCheckReproduction() {
        Cell cell = new Cell(2, 2);
        List<Cell> cells = new ArrayList<>();
        cells.add(new Cell(2, 1));
        cells.add(new Cell(1, 1));
        cells.add(new Cell(2, 3));
        CellRuleSet instance = new CellRuleSet();
        boolean expResult = true;
        boolean result = instance.checkReproduction(cell, cells);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckReproductionFalse() {
        Cell cell = new Cell(2, 2);
        List<Cell> cells = new ArrayList<>();
        cells.add(new Cell(2, 1));
        cells.add(new Cell(0, 1));
        cells.add(new Cell(2, 3));
        CellRuleSet instance = new CellRuleSet();
        boolean expResult = false;
        boolean result = instance.checkReproduction(cell, cells);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkUnderPopulation method, of class CellRuleSet.
     */
    @Test
    public void testUnderPopulation() {
        Cell cell = new Cell(2, 2);
        List<Cell> cells = new ArrayList<>();
        cells.add(new Cell(2, 1));
        CellRuleSet instance = new CellRuleSet();
        boolean expResult = true;
        boolean result = instance.checkUnderPopulation(cell, cells);
        assertEquals(expResult, result);
    }

    @Test
    public void testUnderPopulationFalse() {
        Cell cell = new Cell(2, 2);
        List<Cell> cells = new ArrayList<>();
        cells.add(new Cell(2, 1));
        cells.add(new Cell(1, 1));
        CellRuleSet instance = new CellRuleSet();
        boolean expResult = false;
        boolean result = instance.checkUnderPopulation(cell, cells);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckLivesOn() {
        Cell cell = new Cell(2, 2);
        List<Cell> cells = new ArrayList<>();
        CellRuleSet instance = new CellRuleSet();
        cells.add(new Cell(2, 1));
        assertFalse(instance.checkLivesOn(cell, cells));

        cells.add(new Cell(1, 1));
        assertTrue(instance.checkLivesOn(cell, cells));
        cells.add(new Cell(1, 2));
        assertTrue(instance.checkLivesOn(cell, cells));
        cells.add(new Cell(2, 3));

        boolean expResult = false;
        boolean result = instance.checkLivesOn(cell, cells);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkOvercrowding method, of class CellRuleSet.
     */
    @Test
    public void testCheckOvercrowding() {
        Cell cell = new Cell(2, 2);
        List<Cell> cells = new ArrayList<>();
        CellRuleSet instance = new CellRuleSet();
        cells.add(new Cell(2, 1));
        assertFalse(instance.checkOvercrowding(cell, cells));

        cells.add(new Cell(1, 1));
        assertFalse(instance.checkOvercrowding(cell, cells));
        cells.add(new Cell(1, 2));
        assertFalse(instance.checkOvercrowding(cell, cells));
        cells.add(new Cell(2, 3));

        boolean expResult = true;
        boolean result = instance.checkOvercrowding(cell, cells);
        assertEquals(expResult, result);
    }

}
