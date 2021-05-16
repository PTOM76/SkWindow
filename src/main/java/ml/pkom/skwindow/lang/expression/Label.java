package ml.pkom.skwindow.lang.expression;

import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

public class Label extends SimpleExpression<ml.pkom.skwindow.lang.object.parts.Label> {
    private Expression<String> label;

    static {
        Skript.registerExpression(Label.class, ml.pkom.skwindow.lang.object.parts.Label.class, ExpressionType.PROPERTY
                , "[(skwindow)] [(label[s]|text[s]|sentence[s]) %-string%]");
    }

    @Override
    public Class<? extends ml.pkom.skwindow.lang.object.parts.Label> getReturnType() {
        return ml.pkom.skwindow.lang.object.parts.Label.class;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expr, int arg1, Kleenean arg2, ParseResult arg3) {
        label = (Expression<String>) expr[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        if (label != null){
            return "Expression: Label , Label: " + label.toString(event, debug);
        }else{
            return "Expression: Label , Label: <none>";   
        }
    }

    @Override
    @Nullable
    protected ml.pkom.skwindow.lang.object.parts.Label[] get(Event event) {
        String labelString;
        try {
            labelString = this.label.getSingle(event);
        } catch (NullPointerException e) {
            labelString = "";
        }
        ml.pkom.skwindow.lang.object.parts.Label label = new ml.pkom.skwindow.lang.object.parts.Label();
        label.setText(labelString);
        ml.pkom.skwindow.lang.object.parts.Label[] labels = { label };
        return labels;
    }
}