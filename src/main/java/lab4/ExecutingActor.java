package lab4;

import akka.actor.AbstractActor;
import akka.actor.Props;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ExecutingActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(SepTestMessage.class, mail -> {
                    TestUnit test = mail.getTest();
                    ScriptEngine engine = new
                            ScriptEngineManager().getEngineByName("nashorn");
                    engine.eval(mail.getScript());
                    Invocable invocable = (Invocable) engine;
                    String result = invocable.invokeFunction(mail.funcName, test.getParams()).toString();

                    getContext().actorSelection("/user/routeActor/testKeeper").tell(
                            new TestUnit(
                                    test.getTestName(),
                                    test.getExpectedRes(),
                                    test.getParams(),
                                    test.getPackageID(),
                                    result),
                            self());
                }).build();
    }

    public static Props props() {
        return Props.create(ExecutingActor.class);
    }
}
