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

import java.awt.Font;

import ml.pkom.skwindow.lang.object.parts.Label;

public class LabelFontName extends SimpleExpression<String> {
    private Expression<Label> label;

    static {
        Skript.registerExpression(
                LabelFontName.class, String.class, ExpressionType.COMBINED, "[(skwindow)] [font[ ][name]] of %~label%");
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
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
        return "Expression: LabelFontName , Object: " + label.toString(event, debug);
    }

    @Override
    @Nullable
    protected String[] get(Event event) {
        Label label = this.label.getSingle(event);
        if (label != null) {
            return new String[] { label.getFont() };
        }
        return null;
    }

    @Override
    public void change(Event event, Object[] delta, ChangeMode mode) {
        Label label = this.label.getSingle(event);
        if (label != null) {
            if (mode == ChangeMode.SET) {
                label.setFont((String) delta[0]);
            }if (mode == ChangeMode.RESET || mode == ChangeMode.DELETE) {
                label.setFont(Font.DIALOG);
            }
        } 
    }

    @Override
    public Class<?>[] acceptChange(final ChangeMode mode) {
        if (mode == ChangeMode.DELETE || mode == ChangeMode.SET || mode == ChangeMode.RESET) {
            return CollectionUtils.array(String.class);
        }
        return null;
    }
}