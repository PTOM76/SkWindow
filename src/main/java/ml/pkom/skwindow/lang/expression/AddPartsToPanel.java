package ml.pkom.skwindow.lang.expression;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.Skript;
import ch.njol.skript.classes.Changer.ChangeMode;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import ch.njol.util.coll.CollectionUtils;
import ml.pkom.skwindow.lang.object.Panel;
import java.awt.Component;

public class AddPartsToPanel extends SimpleExpression<Component> {
    private Expression<Panel> object;

    static {
        Skript.registerExpression(
                AddPartsToPanel.class, 
                Component.class, ExpressionType.COMBINED, "[(skwindow)] %~panel%");
    }

    @Override
    public Class<? extends Component> getReturnType() {
        return Component.class;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expr, int arg1, Kleenean arg2, ParseResult arg3) {
        object = (Expression<Panel>) expr[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return "Expression: AddPartsToPanel , Object: " + object.toString(event, debug);
    }

    @Override
    @Nullable
    protected Component[] get(Event event) {
        Panel panel = this.object.getSingle(event);
        if (panel != null) {
            return new Component[] { panel.getMainPanel() };
        }
        return null;
    }

    @Override
    public void change(Event event, Object[] delta, ChangeMode mode) {
        Panel panel = this.object.getSingle(event);
        if (panel != null) {
            Component component = (Component)delta[0];
            if (mode == ChangeMode.ADD) {
                panel.addParts(component);
                Bukkit.getLogger().info("aiueo");
            }else if (mode == ChangeMode.REMOVE) {
                panel.removeParts(component);
            }
        } 
    }

    @Override
    public Class<?>[] acceptChange(final ChangeMode mode) {
        if (mode == ChangeMode.ADD || mode == ChangeMode.REMOVE) {
            return CollectionUtils.array(Component.class);
        }
        return null;
    }
}