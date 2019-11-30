package lab4;

import akka.actor.AbstractActor;
import akka.actor.Props;
import lab4.models.SepTestMessage;
import lab4.models.TestUnit;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ExecutingActor extends AbstractActor {

    private static final String COMPLETED = "Test %s completed!";
    private static final String KEEPER_PATH = "/user/routeActor/testKeeper";
    private static final String NASHORN = "nashorn";

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(SepTestMessage.class, mail -> {
                    TestUnit test = mail.getTest();
                    ScriptEngine engine = new
                            ScriptEngineManager().getEngineByName(NASHORN);
                    engine.eval(mail.getScript());
                    Invocable invocable = (Invocable) engine;
                    String result = invocable.invokeFunction(mail.getFuncName(), test.getParams()).toString();

                    System.out.format(COMPLETED, test.getTestName());
                    getContext().actorSelection(KEEPER_PATH).tell(
                            new TestUnit(
                                    test.getTestName(),
                                    test.getExpectedRes(),
                                    test.getParams(),
                                    mail.getPackageID(),
                                    result),
                            self());
                }).build();
    }

    public static Props props() {
        return Props.create(ExecutingActor.class);
    }
}
