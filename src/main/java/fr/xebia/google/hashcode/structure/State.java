package fr.xebia.google.hashcode.structure;

public enum State {
    COLORED("#"),
    BLANK(".");

    private final String associatedChar;

    State(String associatedChar) {
        this.associatedChar = associatedChar;
    }

    public static State fromAssociatedChar(String associatedChar) {
        for (State state : State.values()) {
            if (state.associatedChar.compareTo(associatedChar) == 0) {
                return state;
            }
        }

        throw new RuntimeException("Unknown associatedChar");
    }

    public String getAssociatedChar() {
        return associatedChar;
    }
}
