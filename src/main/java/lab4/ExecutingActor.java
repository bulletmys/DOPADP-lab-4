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
                .match(TestMessage.class, mail -> {
                    ScriptEngine engine = new
                            ScriptEngineManager().getEngineByName("nashorn");
                    engine.eval(jscript);
                    Invocable invocable = (Invocable) engine;
                    return invocable.invokeFunction(functionName, params).toString();
                })
    }

    public static Props props() {
        return Props.create(ExecutingActor.class);
    }
}
