package lab4;


import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.http.javadsl.Http;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    int main(String[] args) {
        ActorSystem system = ActorSystem.create("test-system");
        ActorRef routeActor = system.actorOf(RouterActor.props(), "routeActor");

        Http http = Http.get(system);
        ActorMaterializer actorMaterializer =  ActorMaterializer.create(system);

        final Flow<HttpRequest, HttpResponse, NotUsed> route


        return 0;
    }
}
