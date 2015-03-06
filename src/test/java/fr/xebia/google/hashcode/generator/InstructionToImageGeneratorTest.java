package fr.xebia.google.hashcode.generator;

import com.google.common.collect.Lists;
import fr.xebia.google.hashcode.instruction.EraseInstruction;
import fr.xebia.google.hashcode.instruction.Instruction;
import fr.xebia.google.hashcode.instruction.PaintInstruction;
import fr.xebia.google.hashcode.structure.Cell;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


public class InstructionToImageGeneratorTest {

    @Test
    public void should_generate_img_text_from_instructions() throws Exception {
        // Given
        ArrayList<Instruction> instructions = Lists.newArrayList();
        instructions.add(new PaintInstruction(new Cell(1, 1), 1));

        instructions.add(new EraseInstruction(new Cell(0, 0)));
        instructions.add(new EraseInstruction(new Cell(0, 1)));
        instructions.add(new EraseInstruction(new Cell(0, 2)));
        instructions.add(new EraseInstruction(new Cell(1, 0)));
        instructions.add(new EraseInstruction(new Cell(1, 2)));
        instructions.add(new EraseInstruction(new Cell(2, 0)));
        instructions.add(new EraseInstruction(new Cell(2, 1)));
        instructions.add(new EraseInstruction(new Cell(2, 2)));

        // When
        String imageGenerated = InstructionToImageGenerator.generate(3, 3, instructions);

        // Then
        assertThat(imageGenerated).isEqualTo
                ("...\n" + ".#.\n" + "...\n");
    }

}