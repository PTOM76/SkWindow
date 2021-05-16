package ml.pkom.skwindow.lang.effect;

import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import ml.pkom.skwindow.lang.object.Frame;

public class LocCenter extends Effect {

    static {
        Skript.registerEffect(LocCenter.class, "[(skwindow)] set location of %~frame% to center");
    }

    private Expression<Frame> frameexpr;
    private Frame frame = new Frame();

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expre, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.frameexpr = (Expression<Frame>) expre[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return "effect: LocCenter , Expression: " + frameexpr.toString(event, debug);
    }

    @Override
    protected void execute(Event event) {
        frame = frameexpr.getSingle(event);
        frame.setCenterLocation();
        
    }
}
