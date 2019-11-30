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
    private static final String RUNNING_TESTS = "Running Tests";
    private static final String POST_PATH = "runtest";
    private static final String GET_PATH = "get";
    private static final String PACKAGE_PARAM = "packageID";

    Route createRoute(ActorRef routerActor) {
        return route(
                path(POST_PATH, () ->
                        post(() ->
                                entity(Jackson.unmarshaller(TestMessage.class), mail -> {
                                    routerActor.tell(mail, ActorRef.noSender());
                                    return complete(RUNNING_TESTS);
                                })
                        )
                ),
                path(GET_PATH, () ->
                        get(() ->
                                parameter(PACKAGE_PARAM, packageID -> {
                                    Future<Object> res = Patterns.ask(routerActor,
                                            new GetTestsResult(Integer.parseInt(packageID)), 5000);
                                    return completeOKWithFuture(res, Jackson.marshaller());
                                })
                        )
                )
        );
    }
}
