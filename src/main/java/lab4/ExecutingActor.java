package lab4;

import akka.actor.AbstractActor;
import akka.actor.Props;

public class ExecutingActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(TestMessage.class, m -> {

                })
    }

    public static Props props() {
        return Props.create(ExecutingActor.class);
    }
}
