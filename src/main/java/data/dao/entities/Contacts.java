package data.dao.entities;

public class Contacts {
    private final String COMMUNICATION_TYPE;
    private final String LINK;

    public Contacts(String COMMUNICATION_TYPE, String LINK) {
        this.COMMUNICATION_TYPE = COMMUNICATION_TYPE;
        this.LINK = LINK;
    }

    public String getCOMMUNICATION_TYPE() { return COMMUNICATION_TYPE; }
    public String getLINK() { return LINK; }
}
