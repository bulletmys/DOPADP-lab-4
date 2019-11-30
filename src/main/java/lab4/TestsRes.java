package lab4;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.ArrayList;

@JsonAutoDetect
public class TestsRes {
    int packageID;
    ArrayList<TestUnit> tests;

    TestsRes(int packageID, ArrayList<TestUnit> tests) {
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
