package dataaccess.bookchecker.chekings;


public class CorrectNumber implements CheckData{
    @Override
    public boolean check(String phoneNumber) {
        return phoneNumber.matches("\\d+");
    }
}