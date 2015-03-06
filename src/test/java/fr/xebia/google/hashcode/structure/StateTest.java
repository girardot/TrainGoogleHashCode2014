package fr.xebia.google.hashcode.structure;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StateTest {

    @Test
    public void should_return_associated_state() {
        // Given / When / Then
        assertThat(State.fromAssociatedChar("#")).isEqualTo(State.COLORED);
        assertThat(State.fromAssociatedChar(".")).isEqualTo(State.BLANK);
    }

    @Test
    public void should_throw_exception_when_unknown_char() {
        // Given

        // When

        // Then
    }


}