package fr.xebia.google.hashcode.io;

import com.google.common.io.Resources;
import fr.xebia.google.hashcode.structure.Grid;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URL;

import static fr.xebia.google.hashcode.structure.State.COLORED;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ReaderTest {

    @Test
    public void should_read_file() {
        // Given
        Reader reader = new Reader();

        URL resource = Resources.getResource("basicExample.txt");

        // When
        Grid grid = reader.readFile(resource);

        // Then
        assertThat(grid).isNotNull();
        assertThat(grid.getLineSize()).isEqualTo(5);
        assertThat(grid.getColumnSize()).isEqualTo(7);
        assertThat(grid.getCell(0, 4).getState()).isEqualTo(COLORED);
        assertThat(grid.getCell(0, 4).getLine()).isEqualTo(0);
        assertThat(grid.getCell(0, 4).getColumn()).isEqualTo(4);

        assertThat(grid.getCell(1, 2).getState()).isEqualTo(COLORED);
        assertThat(grid.getCell(1, 3).getState()).isEqualTo(COLORED);
        assertThat(grid.getCell(1, 4).getState()).isEqualTo(COLORED);
        assertThat(grid.getCell(2, 2).getState()).isEqualTo(COLORED);
        assertThat(grid.getCell(2, 4).getState()).isEqualTo(COLORED);
        assertThat(grid.getCell(3, 2).getState()).isEqualTo(COLORED);
        assertThat(grid.getCell(3, 3).getState()).isEqualTo(COLORED);
        assertThat(grid.getCell(3, 4).getState()).isEqualTo(COLORED);
        assertThat(grid.getCell(4, 2).getState()).isEqualTo(COLORED);
    }

}