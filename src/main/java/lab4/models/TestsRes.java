package lab4.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.ArrayList;

@JsonAutoDetect
public class TestsRes {
    private int packageID;
    private ArrayList<TestUnit> tests;

    public TestsRes(int packageID, ArrayList<TestUnit> tests) {
        this.packageID = packageID;
        this.tests = tests;
    }

    public int getPackageID() {
        return packageID;
    }

    public ArrayList<TestUnit> getTests() {
        return tests;
    }
}
