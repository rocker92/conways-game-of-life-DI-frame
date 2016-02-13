package com.thomas.gameoflife;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thomas
 */
public class GameOfLife {
    
    @Inject
    private CellRuleSet cellRuleSet;

    public void nextGeneration(List<Cell> cells) {
        List<Cell> newGeneration = new ArrayList<>();
        List<Cell> processedCells = new ArrayList<>();
        
        for (Cell cell : cells) {
            List<Cell> neighbours = cellRuleSet.getNeighbours(cell);
            neighbours = filterNeighbours(neighbours, processedCells);
            if(!processedCells.contains(cell)){
                for (Cell neighbour : neighbours) {
                    processedCells.add(neighbour);
                    if(cellRuleSet.analyzeCell(neighbour, cells)){
                        newGeneration.add(neighbour);
                    }
                }
            }
        }
        cells.clear();
        cells.addAll(newGeneration);
    }
    
    public List<Cell> filterNeighbours(List<Cell> neighbours, List<Cell> cells){
        neighbours.removeAll(cells);
        return neighbours;
    }
}
