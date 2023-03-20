package dataaccess.bookchecker.chekings;

@FunctionalInterface
public interface CheckData {
    boolean check(String phoneNumber);
}
