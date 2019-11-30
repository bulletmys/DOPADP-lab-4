package lab4;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class TestMessage {
    int packageID;
    String script;
    String funcName;
    ArrayList<TestUnit> tests;

    TestMessage(int packageId, String jsScript, String funcName, ArrayList<TestUnit> tests) {
        this.packageID = packageId;
        this.script = jsScript;
        this.funcName = funcName;
        this.tests = tests;
    }

    public ArrayList<TestUnit> getTests() {
        return tests;
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
