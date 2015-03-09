package fr.xebia.google.hashcode;

import com.google.common.io.Resources;
import fr.xebia.google.hashcode.instruction.Instruction;
import fr.xebia.google.hashcode.io.Reader;
import fr.xebia.google.hashcode.structure.Cell;
import fr.xebia.google.hashcode.structure.Grid;
import org.junit.Test;

import java.net.URL;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PainterTest {

    @Test
    public void should_generate_basic_instruction() {
        // Given
        Painter painter = new Painter();
        Reader reader = new Reader();
        URL resource = Resources.getResource("basicExample.txt");

        Grid grid = reader.readFile(resource);

        // When
        List<Instruction> basicInstructions = painter.createBasicInstructions(grid);

        // Then
        assertThat(basicInstructions).isNotEmpty();

        for (Instruction basicInstruction : basicInstructions) {
            System.out.println(basicInstruction);
        }
    }

    @Test
    public void should_iterate_on_grid() {
        // Given
        Reader reader = new Reader();
        URL resource = Resources.getResource("basicExample.txt");

        Grid grid = reader.readFile(resource);

        // When / Then
        Iterator<Cell> iterator = grid.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}