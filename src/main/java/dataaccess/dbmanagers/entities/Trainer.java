package dataaccess.dbmanagers.entities;

public class Trainer {
    private final String name;
    private final String surname;
    private final String phoneNumber;

    public Trainer(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return name + " " + surname + "(" + phoneNumber + ")";
    }
}
