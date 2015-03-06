package fr.xebia.google.hashcode.instruction;

import fr.xebia.google.hashcode.structure.Cell;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PaintInstructionTest {

    @Test
    public void should_generate_text_instruction_for_paint() {
        // Given
        PaintInstruction paintInstruction = new PaintInstruction(new Cell(1, 7), 4);

        // When
        String textInstruction = paintInstruction.toString();

        // Then
        assertThat(textInstruction).isEqualTo("PAINTSQ 1 7 4");
    }

    @Test
    public void should_generate_text_instruction_for_erae() {
        // Given
        EraseInstruction eraseInstruction = new EraseInstruction(new Cell(1, 7));

        // When
        String textInstruction = eraseInstruction.toString();

        // Then
        assertThat(textInstruction).isEqualTo("ERASECELL 1 7");
    }

}