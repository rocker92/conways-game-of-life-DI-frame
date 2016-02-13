/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomas.gameoflife;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lovas
 */
public class CellRuleSet {

    public boolean analyzeCell(Cell cell, List<Cell> cells) {
        if (isAlive(cell, cells)) {
            if (checkUnderPopulation(cell, cells) || checkLivesOn(cell, cells)) {
                return true;
            }
            if (checkOvercrowding(cell, cells)) {
                return false;
            }
        } else if (checkReproduction(cell, cells)) {
            return true;
        }
        return false;
    }

    public List<Cell> getNeighbours(Cell cell) {
        List<Cell> neighbours = new ArrayList<>();
        for (int x = cell.getX() - 1; x <= cell.getX() + 1; x++) {
            for (int y = cell.getY() - 1; y <= cell.getY() + 1; ++y) {
                neighbours.add(new Cell(x, y));
            }
        }
        return neighbours;
    }

    public boolean isAlive(Cell cell, List<Cell> cells) {
        return cells.contains(cell);
    }

    public int countAliveNeighbours(Cell cell, List<Cell> cells) {

        int aliveNeighbours = 0;

        for (Cell cell1 : cells) {
            if (isNeighbour(cell, cell1)) {
                aliveNeighbours++;
            }
        }

        return aliveNeighbours;
    }

    public boolean isNeighbour(Cell cell1, Cell cell2) {
        if (cell1.equals(cell2)) {
            return false;
        }
        int absX = Math.abs(cell1.getX() - cell2.getX());
        int absY = Math.abs(cell1.getY() - cell2.getY());
        if (absX <= 1 && absY <= 1) {
            return true;
        }
        return false;
    }

    public boolean checkReproduction(Cell cell, List<Cell> cells) {
        return countAliveNeighbours(cell, cells) == 3;
    }

    public boolean checkUnderPopulation(Cell cell, List<Cell> cells) {
        return countAliveNeighbours(cell, cells) < 2;
    }

    public boolean checkLivesOn(Cell cell, List<Cell> cells) {
        if (countAliveNeighbours(cell, cells) == 2 || countAliveNeighbours(cell, cells) == 3) {
            return true;
        }
        return false;
    }

    public boolean checkOvercrowding(Cell cell, List<Cell> cells) {
        return countAliveNeighbours(cell, cells) > 3;
    }
}
