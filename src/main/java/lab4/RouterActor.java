package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.RoundRobinPool;
import lab4.models.GetTestsResult;
import lab4.models.SepTestMessage;
import lab4.models.TestMessage;
import lab4.models.TestUnit;

public class RouterActor extends AbstractActor {

    public static final String KEEPER_ACTOR_NAME = "testKeeper";
    private static final int POOL_NUM = 5;

    private ActorRef testKeeperActor = getContext().actorOf(TestKeeperActor.props(), KEEPER_ACTOR_NAME);
    private ActorRef execActorsPool = getContext().actorOf(new RoundRobinPool(POOL_NUM).props(ExecutingActor.props()));


    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(GetTestsResult.class, mail -> {
                    testKeeperActor.tell(mail, sender());
                })
                .match(TestMessage.class, mail -> {
                    for (TestUnit test : mail.getTests()) {
                        execActorsPool.tell(new SepTestMessage(
                                mail.getPackageID(), mail.getScript(), mail.getFuncName(), test), self());
                    }
                })
                .build();
    }

    public static Props props() {
        return Props.create(RouterActor.class);
    }
}
