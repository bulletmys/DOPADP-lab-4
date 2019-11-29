package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.routing.RoundRobinPool;

public class RouterActor extends AbstractActor {

    private ActorRef execActor = getContext().actorOf(TestKeeperActor.props());
    private ActorRef testKeeperPool = getContext().actorOf(new RoundRobinPool(1))

    @Override
    public Receive createReceive() {
        return null;
    }
}
