package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.RoundRobinPool;

public class RouterActor extends AbstractActor {

    private ActorRef testKeeperActor = getContext().actorOf(TestKeeperActor.props(), "testKeeper");
    private ActorRef execActorsPool = getContext().actorOf(new RoundRobinPool(1).props(ExecutingActor.props()));


    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(GetTestsResult.class, mail -> {
                    testKeeperActor.tell(mail, sender());
                })
                .match(TestMessage.class, mail -> {

                })
                .build();
    }

    public static Props props() {
        return Props.create(RouterActor.class);
    }
}
