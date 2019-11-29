package lab4;

import java.util.ArrayList;

public class SepTestMessage {
    int packageID;
    String script;
    String funcName;
    TestUnit test;

    SepTestMessage(int packageID, String script, String funcName, TestUnit test) {
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
