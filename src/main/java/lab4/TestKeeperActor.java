package lab4;

import akka.actor.AbstractActor;
import akka.actor.Props;

public class TestKeeperActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return null;
    }

    public static Props props() {
        return Props.create(TestKeeperActor.class);
    }
}
