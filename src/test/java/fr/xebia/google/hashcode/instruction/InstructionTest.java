package fr.xebia.google.hashcode.instruction;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InstructionTest {

    @Test
    public void should_generate_paint_sq_instruction() {
        PaintInstruction instruction = (PaintInstruction) Instruction.generateInstructionFromText("PAINTSQ 25 3 5");

        assertThat(instruction).isInstanceOf(PaintInstruction.class);
        assertThat(instruction.getCell().getLine()).isEqualTo(25);
        assertThat(instruction.getCell().getColumn()).isEqualTo(3);
        assertThat(instruction.getSize()).isEqualTo(5);
    }

    @Test
    public void should_generate_erase_instruction() {
        EraseInstruction instruction = (EraseInstruction) Instruction.generateInstructionFromText("ERASECELL 25 3");

        assertThat(instruction).isInstanceOf(EraseInstruction.class);
        assertThat(instruction.getCell().getLine()).isEqualTo(25);
        assertThat(instruction.getCell().getColumn()).isEqualTo(3);
    }

}