package data.dao.entities;

public class Trainer {
    private final String NAME;
    private final String SURNAME;
    private final String PHONE_NUMBER;

    public Trainer(String NAME, String SURNAME, String PHONE_NUMBER) {
        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.PHONE_NUMBER = PHONE_NUMBER;
    }

    @Override
    public String toString() {
        return NAME + " " + SURNAME + "(" + PHONE_NUMBER + ")";
    }
}
