package lab4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class TestMessage {
    int packageID;
    String script;
    String funcName;
    ArrayList<TestUnit> tests;

    TestMessage(@JsonProperty(value = "packageId") String packageId, @JsonProperty(value = "jsScript") String jsScript,
                @JsonProperty(value = "functionName") String functionName, @JsonProperty(value = "tests") TestUnit[] tests) {
        this.packageID = Integer.parseInt(packageId);
        this.script = jsScript;
        this.funcName = functionName;
        this.tests = new ArrayList<>(Arrays.asList(tests));
    }

//    TestMessage(int packageId, String jsScript, String functionName, ArrayList<TestUnit> tests) {
//        this.packageID = packageId;
//        this.script = jsScript;
//        this.funcName = functionName;
//        this.tests = tests;
//    }

    public ArrayList<TestUnit> getTests() {
        return tests;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public void setTests(ArrayList<TestUnit> tests) {
        this.tests = tests;
    }

    public String getFuncName() {
        return funcName;
    }

    public String getScript() {
        return script;
    }
}
