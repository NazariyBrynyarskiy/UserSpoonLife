package dataaccess.dbmanagers.interfaces;

public class DBManagerFields {

    private final String DB_NAME = "user_info.db";
    public final String CONNECTION_STRING = "jdbc:sqlite:/Users/nazariybrynyarsky/Desktop/Java/JavaEE/UserSpoonLife/database/"+DB_NAME;

    private final String ATTRIBUTE_ONE;
    private final String ATTRIBUTE_TWO;
    private final String ATTRIBUTE_THREE;

    private final String TABLE;

    public DBManagerFields(String ATTRIBUTE_ONE, String ATTRIBUTE_TWO, String ATTRIBUTE_THREE, String TABLE) {
        this.ATTRIBUTE_ONE = ATTRIBUTE_ONE;
        this.ATTRIBUTE_TWO = ATTRIBUTE_TWO;
        this.ATTRIBUTE_THREE = ATTRIBUTE_THREE;
        this.TABLE = TABLE;
    }

    public String getATTRIBUTE_ONE() { return ATTRIBUTE_ONE; }
    public String getATTRIBUTE_TWO() { return ATTRIBUTE_TWO; }
    public String getATTRIBUTE_THREE() { return ATTRIBUTE_THREE; }
    public String getTABLE() { return TABLE; }
}
