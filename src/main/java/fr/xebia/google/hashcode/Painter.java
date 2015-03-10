package fr.xebia.google.hashcode;

import fr.xebia.google.hashcode.instruction.EraseInstruction;
import fr.xebia.google.hashcode.instruction.Instruction;
import fr.xebia.google.hashcode.instruction.PaintInstruction;
import fr.xebia.google.hashcode.structure.Cell;
import fr.xebia.google.hashcode.structure.ColorTarget;
import fr.xebia.google.hashcode.structure.Grid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Painter {

    public List<Instruction> createBasicInstructions(Grid grid) {
        List<Instruction> basicInstructions = new ArrayList<>();

        for (int lineNumber = 0; lineNumber < grid.getLineSize(); lineNumber++) {
            for (int columnNumber = 0; columnNumber < grid.getColumnSize(); columnNumber++) {
                Cell cell = grid.getCell(lineNumber, columnNumber);

                if (cell.mustBeColored()) {
                    basicInstructions.add(new PaintInstruction(cell, 0));
                }
            }
        }

        return basicInstructions;
    }

    public List<Instruction> createInstructionsWithThreeColumnSizeSquare(Grid grid) {
        List<Instruction> instructions = new ArrayList<>();

        Iterator<Cell> gridIterator = grid.iterator();

        while (gridIterator.hasNext()) {
            Cell cell = gridIterator.next();

            if (!cell.isDone()) {
                PaintInstruction instruction = compute3v3PaintSquare(grid, cell);

                if (instruction != null) {
                    instructions.add(instruction);

                    if (instruction.getSize() > 0) {
                        instructions.addAll(generateEraseInstructions(grid, instruction));
                        markCellDone(grid, instruction);
                    }
                }

                grid.getCell(cell.getLine(), cell.getColumn()).markAsDone();
            }
        }

        return instructions;
    }

    void markCellDone(Grid grid, PaintInstruction instruction) {
        if (instruction != null) {
            for (int i = instruction.getCell().getLine() - instruction.getSize(); i <= instruction.getCell().getLine() + instruction.getSize(); i++) {
                for (int j = instruction.getCell().getColumn() - instruction.getSize(); j <= instruction.getCell().getColumn() + instruction.getSize(); j++) {
                    grid.getCell(i, j).markAsDone();
                }
            }
        }
    }

    /**
     * @param grid
     * @param instruction
     * @return
     */
    List<EraseInstruction> generateEraseInstructions(Grid grid, PaintInstruction instruction) {
        List<EraseInstruction> eraseInstructions = new ArrayList<>();

        for (int i = instruction.getCell().getLine() - instruction.getSize(); i <= instruction.getCell().getLine() + instruction.getSize(); i++) {
            for (int j = instruction.getCell().getColumn() - instruction.getSize(); j <= instruction.getCell().getColumn() + instruction.getSize(); j++) {
                if (grid.getCell(i, j).getColorTarget() != ColorTarget.COLORED) {
                    eraseInstructions.add(new EraseInstruction(grid.getCell(i, j)));
                }
            }
        }

        return eraseInstructions;
    }

    PaintInstruction compute3v3PaintSquare(Grid grid, Cell cell) {
        if (cell.getLine() + 3 <= grid.getLineSize() && cell.getColumn() + 3 < grid.getColumnSize()) {
            float toColorCount = 0;
            for (int i = cell.getLine(); i < cell.getLine() + 3; i++) {
                for (int j = cell.getColumn(); j < cell.getColumn() + 3; j++) {
                    if (grid.getCell(i, j).mustBeColored() && !grid.getCell(i, j).isDone()) {
                        toColorCount++;
                    }
                }
            }

            if (toColorCount / 9.0 > 0.5) {
                return new PaintInstruction(new Cell(cell.getLine() + 1, cell.getColumn() + 1), 1);
            }
        }

        if (cell.mustBeColored()) {
            return new PaintInstruction(cell, 0);
        }
        else {
            return null;
        }
    }

//    public List<Instruction> createOptimizedInstructions(Grid grid) {
//        List<Instruction> optimizedInstructions = new ArrayList<>();
//
//        newInstructions.computeNewInstructions();
//
//        while (newInstructions.containsOptimizedInstructions()) {
//            optimizedInstructions.addAll(newInstructions.extractOptimizedInstructions());
//
//            newInstructions.computeNewInstructions();
//        }
//
//        optimizedInstructions.addAll(computeRemainInstructions());
//
//        return optimizedInstructions;
//    }

}
