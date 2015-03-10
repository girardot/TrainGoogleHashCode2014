package fr.xebia.google.hashcode;

import com.google.common.collect.Lists;
import com.google.common.io.Resources;
import fr.xebia.google.hashcode.generator.InstructionToImageGenerator;
import fr.xebia.google.hashcode.instruction.EraseInstruction;
import fr.xebia.google.hashcode.instruction.Instruction;
import fr.xebia.google.hashcode.instruction.PaintInstruction;
import fr.xebia.google.hashcode.io.Reader;
import fr.xebia.google.hashcode.structure.Cell;
import fr.xebia.google.hashcode.structure.Grid;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.extractProperty;

public class PainterTest {

    private Painter painter;

    private long startTime;

    @Before
    public void setUp() {
        painter = new Painter();
        this.startTime = System.nanoTime();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Duration: " + ((System.nanoTime() - startTime) / 1000000000) + "s");
    }

    @Test
    public void should_generate_basic_instruction() throws IOException {
        // Given
        Reader reader = new Reader();
        URL resource = Resources.getResource("basicExample.txt");
//        URL resource = Resources.getResource("doodle.txt");

        Grid grid = reader.readFile(resource);

        // When
        List<Instruction> instructions = painter.createInstructionsWithThreeColumnSizeSquare(grid);
//        List<Instruction> instructions = painter.createBasicInstructions(grid);

        // Then
        assertThat(instructions).isNotEmpty();

        // Check same image
        String generatedFile = InstructionToImageGenerator.generate(grid.getLineSize(), grid.getColumnSize(), instructions);

        URL outPutUrl = Resources.getResource("testFile.txt");

        Writer writer = new OutputStreamWriter(new FileOutputStream(outPutUrl.getFile()), "UTF-8");

        try {
            writer.append(generatedFile);
        } finally {
            writer.close();
        }

//        System.out.println(instructions.size());
//        for (Instruction basicInstruction : instructions) {
//            System.out.println(basicInstruction);
//        }
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

    @Test
    public void should_mark_cells_done() {
        // Given
        Reader reader = new Reader();
        URL resource = Resources.getResource("basicExample.txt");

        Grid grid = reader.readFile(resource);

        // When / Then
        Iterator<Cell> iterator = grid.iterator();
        while (iterator.hasNext()) {
            assertThat(iterator.next().isDone()).isFalse();
        }

        // When
        painter.markCellDone(grid, new PaintInstruction(new Cell(1, 1), 1));

        // Then
        assertThat(grid.getCell(0, 0).isDone()).isTrue();
        assertThat(grid.getCell(0, 1).isDone()).isTrue();
        assertThat(grid.getCell(0, 2).isDone()).isTrue();
        assertThat(grid.getCell(1, 0).isDone()).isTrue();
        assertThat(grid.getCell(1, 1).isDone()).isTrue();
        assertThat(grid.getCell(1, 2).isDone()).isTrue();
        assertThat(grid.getCell(2, 0).isDone()).isTrue();
        assertThat(grid.getCell(2, 1).isDone()).isTrue();
        assertThat(grid.getCell(2, 2).isDone()).isTrue();
    }

    @Test
    public void should_generate_erase_instructions() {
        // Given
        Reader reader = new Reader();
        URL resource = Resources.getResource("basicExample.txt");

        Grid grid = reader.readFile(resource);

        // When / Then
        Iterator<Cell> iterator = grid.iterator();
        while (iterator.hasNext()) {
            assertThat(iterator.next().isDone()).isFalse();
        }

        // When
        List<EraseInstruction> eraseInstructions = painter.generateEraseInstructions(grid, new PaintInstruction(new Cell(1, 1), 1));

        // Then
        List<int[]> expectedResult = Lists.newArrayList(t(0, 0), t(0, 1), t(0, 2), t(1, 0), t(1, 1), t(2, 0), t(2, 1));
        List<int[]> notExpectedResult = Lists.newArrayList(t(1, 2), t(2, 2));

        for (Cell cell : extractProperty("cell", Cell.class).from(eraseInstructions)) {
            assertThat(expectedResult).contains(cell.coordinatesToArray());
            assertThat(notExpectedResult).doesNotContain(cell.coordinatesToArray());
        }
    }

//    @Test
//    public void should_compute_() {
//        // Given
//        Reader reader = new Reader();
//        URL resource = Resources.getResource("basicExample.txt");
//
//        Grid grid = reader.readFile(resource);
//
//        // When / Then
//        assertThat(painter.compute3v3PaintSquare(grid, new Cell(0,0)));
//    }

    private int[] t(int line, int column) {
        return new int[]{line, column};
    }

}