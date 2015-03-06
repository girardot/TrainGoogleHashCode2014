package fr.xebia.google.hashcode.structure;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GridTest {

    @Test
    public void should_compute_index() {
        // Given
        Grid grid = new Grid(2, 3);

        // When / Then
        assertThat(grid.computeIndex(0, 0)).isEqualTo(0);
        assertThat(grid.computeIndex(0, 1)).isEqualTo(1);
        assertThat(grid.computeIndex(0, 2)).isEqualTo(2);
        assertThat(grid.computeIndex(1, 0)).isEqualTo(3);
        assertThat(grid.computeIndex(1, 1)).isEqualTo(4);
        assertThat(grid.computeIndex(1, 2)).isEqualTo(5);
    }


}