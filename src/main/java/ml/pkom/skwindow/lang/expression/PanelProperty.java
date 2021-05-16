package ml.pkom.skwindow.lang.expression;

import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import ml.pkom.skwindow.lang.object.Panel;

public class PanelProperty extends SimpleExpression<Panel> {
    private Panel panel = new Panel();

    static {
        Skript.registerExpression(PanelProperty.class, Panel.class, ExpressionType.SIMPLE, "[(skwindow)] panel");
    }

    @Override
    public Class<? extends Panel> getReturnType() {
        return Panel.class;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public boolean init(Expression<?>[] expr, int arg1, Kleenean arg2, ParseResult arg3) {
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        // if (panel != null) {
        // return "Expression: Panel , inPanel: " + panel.toString(event, debug);
        // } else {
        // return "Expression: Panel , inPanel: contentPages";
        // }
        return "Expression: PanelProperty";
    }

    @Override
    @Nullable
    protected Panel[] get(Event event) {
        panel = new Panel();
        Panel[] panels = { panel };
        return panels;
    }
}