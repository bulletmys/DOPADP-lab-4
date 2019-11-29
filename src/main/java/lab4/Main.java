package lab4;


import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class Main {
    int main(String[] args) {
        ActorSystem system = ActorSystem.create("test-system");
        ActorRef routeActor = system.actorOf(RouterActor.props(), "routeActor");

        Htt

        return 0;
    }
}
