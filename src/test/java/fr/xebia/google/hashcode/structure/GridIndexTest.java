package fr.xebia.google.hashcode.structure;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class GridIndexTest {

    private Object[] parametersForShould_compute_index() {
        return new Object[][] {
                {0, 0, 0},
                {0, 1, 1},
                {0, 2, 2},
                {1, 0, 3},
                {1, 1, 4},
                {1, 2, 5},
        };
    }

    @Test
    @Parameters
    public void should_compute_index(int lineNumber, int columnNumber, final int expectedResult) {
        // Given
        Grid grid = new Grid(2, 3);

        // When / Then
        assertThat(grid.computeIndex(lineNumber, columnNumber)).isEqualTo(expectedResult);
    }


}