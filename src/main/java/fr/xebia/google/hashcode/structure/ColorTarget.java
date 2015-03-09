package fr.xebia.google.hashcode.structure;

public enum ColorTarget {
    COLORED("#"),
    BLANK(".");

    private final String associatedChar;

    ColorTarget(String associatedChar) {
        this.associatedChar = associatedChar;
    }

    public static ColorTarget fromAssociatedChar(String associatedChar) {
        for (ColorTarget colorTarget : ColorTarget.values()) {
            if (colorTarget.associatedChar.compareTo(associatedChar) == 0) {
                return colorTarget;
            }
        }

        throw new RuntimeException("Unknown associatedChar");
    }

    public String getAssociatedChar() {
        return associatedChar;
    }
}
