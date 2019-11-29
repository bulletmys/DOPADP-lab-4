package lab4;

public class TestUnit {
    private String testName;
    private String expectedRes;
    private String params;
    private String res;

    TestUnit(String testName, String expectedRes, String params) {
        this.testName = testName;
        this.expectedRes = expectedRes;
        this.params = params;
        this.res = "";
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
}
