package lab4.models;

public class SepTestMessage {
    private int packageID;
    private String script;
    private String funcName;
    private TestUnit test;

    public SepTestMessage(int packageID, String script, String funcName, TestUnit test) {
        this.packageID = packageID;
        this.script = script;
        this.funcName = funcName;
        this.test = test;
    }

    public TestUnit getTest() {
        return test;
    }

    public int getPackageID() {
        return packageID;
    }

    public String getFuncName() {
        return funcName;
    }

    public String getScript() {
        return script;
    }
}
