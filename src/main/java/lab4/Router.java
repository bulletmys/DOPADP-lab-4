package lab4;

import akka.actor.ActorRef;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;

public class Router extends AllDirectives {
    Route createRoute(ActorRef routerActor) {
        return route(
                path("runtest", () ->
                        post( () ->
                                entity(Jackson.unmarshaller(TestMessage.class), mail ->
                                        )
                                )
                )
        )
    }
}
