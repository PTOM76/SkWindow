package ml.pkom.skwindow.lang.effect;

import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import ml.pkom.skwindow.lang.object.Panel;
import ml.pkom.skwindow.lang.object.parts.Label;

public class AddLabelInPanel extends Effect {

    static {
        Skript.registerEffect(AddLabelInPanel.class, "[(skwindow)] add label %~label% (in|inside) %~panel%");
    }

    private Expression<Label> putLabelexpr;
    private Expression<Panel> inPanelexpr;
    private Panel inPanel = new Panel();
    private Label label;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expre, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.putLabelexpr = (Expression<Label>) expre[0];
        this.inPanelexpr = (Expression<Panel>) expre[1];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return "effect: AddLabelInPanel , Expression: " + putLabelexpr.toString(event, debug);
    }

    @Override
    protected void execute(Event event) {
        inPanel = inPanelexpr.getSingle(event);
        label = putLabelexpr.getSingle(event);
        inPanel.addParts(label.getPart());
    }
}
