package dataaccess.bookchecker;

import dataaccess.bookchecker.chekings.UserExisting;
import dataaccess.bookchecker.chekings.CheckData;
import dataaccess.bookchecker.chekings.CorrectNumber;

import java.util.ArrayList;
import java.util.List;

public class Checker {
    private List<CheckData> checkData = new ArrayList<>();

    public boolean process(String phoneNumber) {
        checkData.add(new CorrectNumber());
        checkData.add(new UserExisting());
        for (CheckData c : checkData) {
            if (!c.check(phoneNumber))
                return false;
        }
        return true;
    }
}
