package fr.xebia.google.hashcode.io;

import com.google.common.io.Resources;
import fr.xebia.google.hashcode.Painter;
import fr.xebia.google.hashcode.instruction.Instruction;
import fr.xebia.google.hashcode.structure.Grid;
import org.junit.Test;

import java.net.URL;
import java.util.List;

public class WriterTest {

    @Test
    public void should_write_basic_instructions() {
        // Given
        Painter painter = new Painter();
        Reader reader = new Reader();
        URL resource = Resources.getResource("basicExample.txt");

        Grid grid = reader.readFile(resource);
        List<Instruction> basicInstructions = painter.createBasicInstructions(grid);

        Writer writer = new Writer();

        // When
        writer.writeInstructions(basicInstructions);

        // Then
    }


}