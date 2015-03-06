package fr.xebia.google.hashcode.generator;

import fr.xebia.google.hashcode.instruction.Instruction;
import fr.xebia.google.hashcode.structure.Grid;

import java.util.List;

public class InstructionToImageGenerator {

    public static String generate(int lineSize, int columnSize, List<Instruction> instructions) {

        Grid grid = new Grid(lineSize, columnSize);

        for (Instruction instruction : instructions) {
            instruction.print(grid);
        }

        return grid.toString();
    }

}
