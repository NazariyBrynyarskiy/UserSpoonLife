package data.dao.insertchecker.chekings;

@FunctionalInterface
public interface CheckData {
    boolean check(String phoneNumber);
}
