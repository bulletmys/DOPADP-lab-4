package lab4;

public class TestUnit {
    private String testName;
    private String expectedRes;
    private String params;
    private String res;
    private int packageID;

    TestUnit(String testName, String expectedRes, String params, int packageID) {
        this.testName = testName;
        this.expectedRes = expectedRes;
        this.params = params;
        this.res = "";
        this.packageID = packageID;
    }

    public String getExpectedRes() {
        return expectedRes;
    }

    public String getParams() {
        return params;
    }

    public String getRes() {
        return res;
    }

    public String getTestName() {
        return testName;
    }

    public int getPackageID() {
        return packageID;
    }
}
