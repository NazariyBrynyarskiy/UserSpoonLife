package data.dao.insertchecker.chekings;

public class CorrectNumberLength implements CheckData{
    @Override
    public boolean check(String phoneNumber) {
        return ((phoneNumber.length() == 12) && (phoneNumber.startsWith("3809"))) ||
               ((phoneNumber.length() == 10) && (phoneNumber.startsWith("09")));
    }
}
