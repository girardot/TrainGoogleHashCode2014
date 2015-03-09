package fr.xebia.google.hashcode.structure;

import org.junit.Test;

import static fr.xebia.google.hashcode.structure.ColorTarget.BLANK;
import static fr.xebia.google.hashcode.structure.ColorTarget.COLORED;
import static org.assertj.core.api.Assertions.assertThat;

public class CellTest {

    @Test
    public void should_return_true_when_colored() {
        // Given
        Cell coloredCell = new Cell(COLORED);

        // When / Then
        assertThat(coloredCell.isColored()).isTrue();
    }

    @Test
    public void should_return_false_when_no_colored() {
        // Given
        Cell coloredCell = new Cell(BLANK);

        // When / Then
        assertThat(coloredCell.isColored()).isFalse();
    }

}