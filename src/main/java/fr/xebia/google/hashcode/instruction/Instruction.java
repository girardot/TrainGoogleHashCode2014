package fr.xebia.google.hashcode.instruction;

import fr.xebia.google.hashcode.structure.Cell;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Instruction {

    final Pattern PAINT_PATTERN = Pattern.compile("PAINTSQ (\\d+) (\\d+) (\\d+)");
    final Pattern ERASE_PATTERN = Pattern.compile("ERASECELL (\\d+) (\\d+)");

    static Instruction generateInstructionFromText(String textInstruction) {

        Matcher m = PAINT_PATTERN.matcher(textInstruction);

        if(m.matches()) {
            return new PaintInstruction(new Cell(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2))), Integer.parseInt(m.group(3)));
        }

        m = ERASE_PATTERN.matcher(textInstruction);

        if(m.matches()) {
            return new EraseInstruction(new Cell(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2))));
        }

        return null;
    }

}
