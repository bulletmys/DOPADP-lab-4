package lab4;

import akka.actor.ActorRef;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;

public class Router extends AllDirectives {
    Route createRoute(ActorRef routerActor) {
        return route(
                path("runtest", () -> )
        )
    }
}
