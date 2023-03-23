package dataaccess.dbmanagers.entities;

public class Schedule {
    private final String day;
    private final String time;

    public Schedule(String day, String time) {
        this.day = day;
        this.time = time;
    }

    public String getDay() { return day; }
    public String getTime() { return time; }
}
