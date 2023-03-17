package controller;

import controller.chekings.UserExisting;
import controller.chekings.CheckData;
import controller.chekings.CorrectNumber;

import java.util.ArrayList;
import java.util.List;

public class Checker {
    private static List<CheckData> checkData = new ArrayList<>();

    public static boolean process(String phoneNumber) {
        checkData.add(new CorrectNumber());
        checkData.add(new UserExisting());
        for (CheckData c : checkData) {
            if (!c.check(phoneNumber))
                return false;
        }
        return true;
    }
}
