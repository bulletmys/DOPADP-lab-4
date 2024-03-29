package lab4;

import akka.actor.AbstractActor;
import akka.actor.Props;
import lab4.models.GetTestsResult;
import lab4.models.TestUnit;
import lab4.models.TestsRes;

import java.util.ArrayList;
import java.util.HashMap;

public class TestKeeperActor extends AbstractActor {
    private static final String ERROR = "Cant find current key";

    private HashMap<Integer, ArrayList<TestUnit>> tests = new HashMap<>();

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(TestUnit.class, mail -> {
                    if (tests.containsKey(mail.getPackageID())) {
                        tests.get(mail.getPackageID()).add(mail);
                    } else {
                        ArrayList<TestUnit> arrayList = new ArrayList<>();
                        arrayList.add(mail);
                        tests.put(mail.getPackageID(), arrayList);
                    }
                })
                .match(GetTestsResult.class, mail -> {
                    if (tests.containsKey(mail.getPackageID())) {
                        TestsRes testsRes = new TestsRes(mail.getPackageID(), tests.get(mail.getPackageID()));
                        sender().tell(testsRes, self());
                    } else {
                        sender().tell(ERROR, self());
                    }
                })
                .build();
    }

    public static Props props() {
        return Props.create(TestKeeperActor.class);
    }
}
