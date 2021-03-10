package enums;

public enum Language {
    VN("Tiếng Việt"),
    EN("ENGLISH");

    private final String text;

    /**
     * @param text
     */
    Language(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
