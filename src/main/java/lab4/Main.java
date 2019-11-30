package lab4;


import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.stream.ActorMaterializer;
import akka.stream.CompletionStrategy;
import akka.stream.javadsl.Flow;

import java.io.IOException;
import java.util.concurrent.CompletionStage;

public class Main {
    private static final String SERVER_ONLINE_MSG = "Server online at http://localhost:8080/\nPress RETURN to stop...";
    private static final int PORT = 8080;
    private static final String HOST = "localhost";
    private static final String ROUTE_ACTOR = "routeActor";
    private static final String SYSTEM_NAME = "test-system";

    public static void main(String[] args) throws IOException {
        ActorSystem system = ActorSystem.create(SYSTEM_NAME);
        ActorRef routeActor = system.actorOf(RouterActor.props(), ROUTE_ACTOR);

        Http http = Http.get(system);
        ActorMaterializer actorMaterializer = ActorMaterializer.create(system);
        Router router = new Router();

        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow =
                router.createRoute(routeActor).flow(system, actorMaterializer);

        final CompletionStage<ServerBinding> bind = http.bindAndHandle(routeFlow,
                ConnectHttp.toHost(HOST, PORT), actorMaterializer);

        System.out.println(SERVER_ONLINE_MSG);
        System.in.read();

        bind.thenCompose(ServerBinding::unbind).thenAccept(m -> system.terminate());
    }
}
