package lab4;

import akka.actor.ActorRef;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;

import java.util.concurrent.Future;
import java.util.regex.Pattern;

public class Router extends AllDirectives {
    Route createRoute(ActorRef routerActor) {
        return route(
                path("runtest", () ->
                        post(() ->
                                entity(Jackson.unmarshaller(TestMessage.class), mail -> {
                                    routerActor.tell(mail, ActorRef.noSender());
                                    return complete("Running Tests");
                                })
                        )
                ),
                path(parameter("packageID", packageID -> {
                    Future<Object> res = Pattern.ask
                        })

                )
        )
    }
}
