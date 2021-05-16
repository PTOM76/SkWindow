package ml.pkom.skwindow.lang.effect;

import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import ml.pkom.skwindow.lang.object.Panel;
import ml.pkom.skwindow.lang.object.parts.TextArea;

public class AddTextAreaInPanel extends Effect {

    static {
        Skript.registerEffect(AddTextAreaInPanel.class,
                "[(skwindow)] add text[ ]area %~textarea% (in|inside) %~panel%");
    }

    private Expression<TextArea> putTextAreaexpr;
    private Expression<Panel> inPanelexpr;
    private Panel inPanel = new Panel();
    private TextArea textArea;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expre, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.putTextAreaexpr = (Expression<TextArea>) expre[0];
        this.inPanelexpr = (Expression<Panel>) expre[1];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return "effect: AddTextAreaInPanel , Expression: " + putTextAreaexpr.toString(event, debug);
    }

    @Override
    protected void execute(Event event) {
        inPanel = inPanelexpr.getSingle(event);
        textArea = putTextAreaexpr.getSingle(event);
        inPanel.addParts(textArea.getPart());
    }
}
