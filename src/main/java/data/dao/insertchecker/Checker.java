package data.dao.insertchecker;

import data.dao.insertchecker.chekings.CheckData;
import data.dao.insertchecker.chekings.CorrectNumberDigits;
import data.dao.insertchecker.chekings.CorrectNumberLength;
import data.dao.insertchecker.chekings.UserExisting;

import java.util.ArrayList;
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
