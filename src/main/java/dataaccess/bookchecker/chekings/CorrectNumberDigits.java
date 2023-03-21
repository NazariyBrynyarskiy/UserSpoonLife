package dataaccess.bookchecker.chekings;


public class CorrectNumberDigits implements CheckData{
    @Override
    public boolean check(String phoneNumber) {
        return phoneNumber.matches("\\d+");
    }
}
