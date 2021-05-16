package ml.pkom.skwindow.lang.expression;

import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import ml.pkom.skwindow.lang.object.Frame;

public class SFrame extends SimpleExpression<Frame> {
    private Expression<String> title;
    private Frame frame = new Frame();

    static {
        Skript.registerExpression(SFrame.class, Frame.class, ExpressionType.PROPERTY, "[(skwindow)] (frame|window) [(named|with name[s]|titled|with title[s]) %-string%]");
    }

    @Override
    public Class<? extends Frame> getReturnType() {
        return Frame.class;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expr, int arg1, Kleenean arg2, ParseResult arg3) {
        title = (Expression<String>) expr[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        if (title != null){
            return "Expression: SFrame , Title: " + title.toString(event, debug);
        }else{
            return "Expression: SFrame , Title: <none>";   
        }
    }

    @Override
    @Nullable
    protected Frame[] get(Event event) {
        frame = new Frame();
        try {
            String title = this.title.getSingle(event);
            if (title != null) {
                frame.setTitle(title);
            }
        } catch (NullPointerException e) {
            frame.setTitle("<none>");
        }
        Frame[] frames = { frame };
        return frames;
    }
}