package ml.pkom.skwindow.lang.expression;

import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

public class TextArea extends SimpleExpression<ml.pkom.skwindow.lang.object.parts.TextArea> {
    private Expression<String> contentsText;
    private Expression<Number> rows;
    private Expression<Number> cols;

    static {
        Skript.registerExpression(TextArea.class, ml.pkom.skwindow.lang.object.parts.TextArea.class, ExpressionType.PROPERTY,
                "[(skwindow)] text[ ]area [with %-number% row[s]] [with %-number% column[s]] [(text[s] with|texted) %-string%]");
    }

    @Override
    public Class<? extends ml.pkom.skwindow.lang.object.parts.TextArea> getReturnType() {
        return ml.pkom.skwindow.lang.object.parts.TextArea.class;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expr, int arg1, Kleenean arg2, ParseResult arg3) {
        rows = (Expression<Number>) expr[0];
        cols = (Expression<Number>) expr[1];
        contentsText = (Expression<String>) expr[2];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        if (contentsText != null) {
            return "Expression: TextArea , contentsText: " + contentsText.toString(event, debug);
        } else {
            return "Expression: TextArea , contentsText: <none>";
        }
    }

    @Override
    @Nullable
    protected ml.pkom.skwindow.lang.object.parts.TextArea[] get(Event event) {
        String contentsText;
        Integer rows;
        Integer cols;
        try {
            contentsText = this.contentsText.getSingle(event);
        } catch (NullPointerException e) {
            contentsText = "";
        }
        try {
            rows = this.rows.getSingle(event).intValue();
        } catch (NullPointerException e) {
            rows = 1;
        }
        try {
            cols = this.cols.getSingle(event).intValue();
        } catch (NullPointerException e) {
            cols = 80;
        }
        //String[] datas = { contentsText + "," + rows.toString() + "," + cols.toString() };
        ml.pkom.skwindow.lang.object.parts.TextArea textArea = new ml.pkom.skwindow.lang.object.parts.TextArea();
        textArea.setText(contentsText);
        textArea.setRows(rows);
        textArea.setCols(cols);
        ml.pkom.skwindow.lang.object.parts.TextArea[] textAreas = {textArea};
        return textAreas;
    }
}