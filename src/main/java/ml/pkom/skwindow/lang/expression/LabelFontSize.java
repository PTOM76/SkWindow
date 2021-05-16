package ml.pkom.skwindow.lang.expression;

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
import ml.pkom.skwindow.lang.object.parts.Label;

public class LabelFontSize extends SimpleExpression<Number> {
    private Expression<Label> label;

    static {
        Skript.registerExpression(
                LabelFontSize.class, Number.class, ExpressionType.COMBINED, "[(skwindow)] [[font][ ]size] of %~label%");
    }

    @Override
    public Class<? extends Number> getReturnType() {
        return Number.class;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expr, int arg1, Kleenean arg2, ParseResult arg3) {
        label = (Expression<Label>) expr[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return "Expression: LabelFontSize , Object: " + label.toString(event, debug);
    }

    @Override
    @Nullable
    protected Number[] get(Event event) {
        Label label = this.label.getSingle(event);
        if (label != null) {
            return new Number[] { label.getFontSize() };
        }
        return null;
    }

    @Override
    public void change(Event event, Object[] delta, ChangeMode mode) {
        Label label = this.label.getSingle(event);
        if (label != null) {
            if (mode == ChangeMode.SET) {
                label.setFontSize(((Number) delta[0]).intValue());
            }if (mode == ChangeMode.RESET || mode == ChangeMode.DELETE) {
                label.setFontSize(15);
            }
        } 
    }

    @Override
    public Class<?>[] acceptChange(final ChangeMode mode) {
        if (mode == ChangeMode.DELETE || mode == ChangeMode.SET || mode == ChangeMode.RESET) {
            return CollectionUtils.array(Number.class);
        }
        return null;
    }
}