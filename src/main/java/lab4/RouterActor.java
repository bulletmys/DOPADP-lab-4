package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;

public class RouterActor extends AbstractActor {

    private ActorRef execActor = getContext().actorOf(TestKeeperActor.props());
    private 

    @Override
    public Receive createReceive() {
        return null;
    }
}
