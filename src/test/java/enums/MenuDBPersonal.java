package enums;

public enum MenuDBPersonal {
    ASK_DOCTOR("/askdoctor"),
    APPOINTMENT("/appointment"),
    BUY_MEDICINE("/buy-medicine"),
    JOINED_ORG("/profile/organization"),
    BIO_INFO("/profile/bioinfo"),
    ACCOUNT("/profile/info")
    ;

    private final String text;

    /**
     * @param text
     */
    MenuDBPersonal(final String text) {
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
