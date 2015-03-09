package fr.xebia.google.hashcode.structure;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ColorTargetTest {

    @Test
    public void should_return_associated_state() {
        // Given / When / Then
        assertThat(ColorTarget.fromAssociatedChar("#")).isEqualTo(ColorTarget.COLORED);
        assertThat(ColorTarget.fromAssociatedChar(".")).isEqualTo(ColorTarget.BLANK);
    }

    @Test
    public void should_throw_exception_when_unknown_char() {
        // Given

        // When

        // Then
    }


}