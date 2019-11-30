package lab4.models;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class TestUnit {
    private String testName;
    private String expectedRes;
    private Object[] params;
    private String res;
    private int packageID;

    TestUnit(@JsonProperty(value = "testName") String testName, @JsonProperty(value = "expectedResult") String expectedResult,
             @JsonProperty(value = "params") Object[] params) {
        this.testName = testName;
        this.expectedRes = expectedResult;
        this.params = params;
        this.packageID = 0;
        this.res = "";
    }

    public TestUnit(String testName, String expectedRes, Object[] params, int packageID, String res) {
        this.testName = testName;
        this.expectedRes = expectedRes;
        this.params = params;
        this.res = res;
        this.packageID = packageID;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getExpectedRes() {
        return expectedRes;
    }

    public Object[] getParams() {
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
