package dataaccess.bookchecker;

import dataaccess.bookchecker.chekings.CorrectNumberLength;
import dataaccess.bookchecker.chekings.UserExisting;
import dataaccess.bookchecker.chekings.CheckData;
import dataaccess.bookchecker.chekings.CorrectNumberDigits;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Checker {
    private final List<CheckData> checkData;

    public Checker() {
        checkData = new ArrayList<>();
    }

    public boolean process(String phoneNumber) {
        checkData.add(new CorrectNumberDigits());
        checkData.add(new CorrectNumberLength());
        checkData.add(new UserExisting());
        for (CheckData c : checkData) {
            if (!c.check(phoneNumber))
                return false;
        }
        return true;
    }
}
