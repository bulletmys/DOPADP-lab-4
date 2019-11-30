package lab4;


import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.stream.ActorMaterializer;
import akka.stream.CompletionStrategy;
import akka.stream.javadsl.Flow;

import java.util.concurrent.CompletionStage;

public class Main {
    int main(String[] args) {
        ActorSystem system = ActorSystem.create("test-system");
        ActorRef routeActor = system.actorOf(RouterActor.props(), "routeActor");

        Http http = Http.get(system);
        ActorMaterializer actorMaterializer =  ActorMaterializer.create(system);
        Router router = new Router();

        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow =
                router.createRoute(routeActor).flow(system, actorMaterializer);

        final CompletionStage<ServerBinding> bind = http.bindAndHandle()


        return 0;
    }
}
