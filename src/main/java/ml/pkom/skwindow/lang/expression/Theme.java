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
import ml.pkom.skwindow.lang.object.Frame;

public class Theme extends SimpleExpression<String> {
    private Expression<Frame> object;

    static {
        Skript.registerExpression(
                Theme.class, 
                String.class, ExpressionType.COMBINED, "[(skwindow)] (theme[s]|look[ ]and[ ]feel) of %~frame%");
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
        object = (Expression<Frame>) expr[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return "Expression: Theme , Object: " + object.toString(event, debug);
    }

    @Override
    @Nullable
    protected String[] get(Event event) {
        Frame frame = this.object.getSingle(event);
        if (frame != null) {
            return new String[] { frame.getTheme() };
        }
        return null;
    }

    @Override
    public void change(Event event, Object[] delta, ChangeMode mode) {
        Frame frame = this.object.getSingle(event);
        if (frame != null) {
            if (mode == ChangeMode.SET) {
                frame.setTheme((String)delta[0]);

            }if (mode == ChangeMode.RESET || mode == ChangeMode.DELETE) {
                frame.setTheme("system");
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