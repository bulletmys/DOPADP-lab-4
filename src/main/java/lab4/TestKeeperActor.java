package lab4;

import akka.actor.AbstractActor;
import akka.actor.Props;

import java.util.ArrayList;
import java.util.HashMap;

public class TestKeeperActor extends AbstractActor {

    HashMap<Integer, ArrayList<TestUnit>> tests;

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(TestUnit.class, mail -> {
                    if (tests.containsKey(mail.getPackageID())) {
                        tests.get(mail.getPackageID()).add(mail);
                    } else {
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(mail.getRes());
                        tests.put(mail.getPackageID(), arrayList);
                    }
                })
                .match(GetTestsResult.class, mail -> {
                    tests.get(mail.getPackageID());
                })
                .build();
    }

    public static Props props() {
        return Props.create(TestKeeperActor.class);
    }
}
