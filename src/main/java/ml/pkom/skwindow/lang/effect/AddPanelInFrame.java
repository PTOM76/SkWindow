package ml.pkom.skwindow.lang.effect;

import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import ml.pkom.skwindow.lang.object.Frame;
import ml.pkom.skwindow.lang.object.Panel;

public class AddPanelInFrame extends Effect {

    static {
        Skript.registerEffect(AddPanelInFrame.class, "[(skwindow)] add frame %~panel% (in|inside) (%~frame%)");
    }

    private Expression<Panel> panelexpr;
    private Expression<Frame> inFramexpr;
    private Frame inFrame = new Frame();
    private Panel panel = new Panel();

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expre, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.panelexpr = (Expression<Panel>) expre[0];
        this.inFramexpr = (Expression<Frame>) expre[1];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return "effect: AddPanelInFrame , Expression: " + panelexpr.toString(event, debug);
    }

    @Override
    protected void execute(Event event) {
        panel = panelexpr.getSingle(event);
        inFrame = inFramexpr.getSingle(event);
        inFrame.addPanel(panel);
    }
}
