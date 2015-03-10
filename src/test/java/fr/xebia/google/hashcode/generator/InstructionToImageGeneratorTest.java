package fr.xebia.google.hashcode.generator;

import com.google.common.collect.Lists;
import com.google.common.io.Resources;
import fr.xebia.google.hashcode.instruction.EraseInstruction;
import fr.xebia.google.hashcode.instruction.Instruction;
import fr.xebia.google.hashcode.instruction.PaintInstruction;
import fr.xebia.google.hashcode.io.Reader;
import fr.xebia.google.hashcode.structure.Cell;
import fr.xebia.google.hashcode.structure.Grid;
import org.junit.Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

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
        assertThat(imageGenerated)
                .isEqualTo
                        ("...\n" +
                                ".#.\n" +
                                "...\n");
    }

    @Test
    public void should_generate_img_text_from_instructions_() throws Exception {
        // Given
        String expectedImage =
                ".......\n" +
                        ".###...\n" +
                        ".###...\n" +
                        ".###...\n" +
                        ".......\n";

        Reader reader = new Reader();
        URL resource = Resources.getResource("blankExample.txt");

        Grid grid = reader.readFile(resource);

        // When / Then
        Iterator<Cell> iterator = grid.iterator();
        while (iterator.hasNext()) {
            assertThat(iterator.next().isDone()).isFalse();
        }

        // When
        String imageGenerated = InstructionToImageGenerator.generate(
                grid.getLineSize(),
                grid.getColumnSize(),
                Lists.newArrayList(new PaintInstruction(new Cell(2, 2), 1)));

        // Then
        assertThat(imageGenerated).isEqualTo(expectedImage);
    }

}