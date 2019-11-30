package lab4;

import akka.actor.ActorRef;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;
import lab4.models.GetTestsResult;
import lab4.models.TestMessage;
import scala.concurrent.Future;

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
                path("get", () ->
                        get(() ->
                                parameter("packageID", packageID -> {
                                    Future<Object> res = Patterns.ask(routerActor,
                                            new GetTestsResult(Integer.parseInt(packageID)), 5000);
                                    return completeOKWithFuture(res, Jackson.marshaller());
                                })
                        )
                )
        );
    }
}
