package fr.xebia.google.hashcode.utils;

import fr.xebia.google.hashcode.instruction.EraseInstruction;
import fr.xebia.google.hashcode.instruction.Instruction;
import fr.xebia.google.hashcode.instruction.PaintInstruction;
import fr.xebia.google.hashcode.structure.Cell;
import fr.xebia.google.hashcode.structure.Grid;
import org.junit.Test;

import java.nio.file.Files;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static fr.xebia.google.hashcode.structure.ColorTarget.BLANK;
import static fr.xebia.google.hashcode.structure.ColorTarget.COLORED;
import static org.assertj.core.api.Assertions.assertThat;


public class FileUtilsTest {

    @Test
    public void should_read_file_in_grid() throws Exception {
        // Given
        String fileName = "fileToRead.txt";
        String filePath = "src/test/resources";

        // When
        Grid grid = FileUtils.readFileInGrid(filePath, fileName);

        // Then
        assertThat(grid.getLineSize()).isEqualTo(5);
        assertThat(grid.getColumnSize()).isEqualTo(7);

        assertThat(grid.getCell(0, 0).getColorTarget()).isEqualTo(BLANK);
        assertThat(grid.getCell(0, 1).getColorTarget()).isEqualTo(BLANK);
        assertThat(grid.getCell(0, 2).getColorTarget()).isEqualTo(BLANK);
        assertThat(grid.getCell(0, 3).getColorTarget()).isEqualTo(BLANK);
        assertThat(grid.getCell(0, 4).getColorTarget()).isEqualTo(COLORED);

        assertThat(grid.getCell(2, 2).getColorTarget()).isEqualTo(COLORED);

        assertThat(grid.getCell(4, 6).getColorTarget()).isEqualTo(BLANK);
    }

    @Test
    public void should_write_instruction_in_file() throws Exception {
        // Given
        String fileName = "instructionsFile.txt";
        String filePath = "src/test/resources";
        List<Instruction> instructions = newArrayList(new PaintInstruction(new Cell(1, 1), 1), new EraseInstruction(new Cell(1, 1)));

        // When
        FileUtils.writeInstructionsInFile(instructions, filePath, fileName);

        // Then
        List<String> fileInString = FileUtils.readFileInString(filePath, fileName);
        assertThat(fileInString).hasSize(2);
        assertThat(fileInString.get(0)).isEqualTo("PAINTSQ 1 1 1");
        assertThat(fileInString.get(1)).isEqualTo("ERASECELL 1 1");
    }

}