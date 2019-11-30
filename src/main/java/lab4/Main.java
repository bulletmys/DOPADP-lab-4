package lab4;


import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.http.javadsl.Http;
import akka.http.javadsl.server.AllDirectives;
import akka.stream.ActorMaterializer;

public class Main extends AllDirectives {
    int main(String[] args) {
        ActorSystem system = ActorSystem.create("test-system");
        ActorRef routeActor = system.actorOf(RouterActor.props(), "routeActor");

        Http http = Http.get(system);
        ActorMaterializer actorMaterializer =  ActorMaterializer.create(system);


        return 0;
    }
}
