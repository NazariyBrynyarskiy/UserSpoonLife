package data.dao.entities;

public class Schedule {
    private final String DAY;
    private final String TIME;

    public Schedule(String DAY, String TIME) {
        this.DAY = DAY;
        this.TIME = TIME;
    }

    public String getDay() { return DAY; }
    public String getTime() { return TIME; }
}
