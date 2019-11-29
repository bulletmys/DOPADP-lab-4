package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.routing.RoundRobinPool;

public class RouterActor extends AbstractActor {

    private ActorRef testKeeperActor = getContext().actorOf(TestKeeperActor.props());
    private ActorRef execActorsPool = getContext().actorOf(new RoundRobinPool(1).props(ExecutingActor.props()));

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match()
    }
}
