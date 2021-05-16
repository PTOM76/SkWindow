package ml.pkom.skwindow.lang.classinfo;

import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import ml.pkom.skwindow.lang.object.parts.Label;

public class LabelClass {

    static {
        Classes.registerClass(new ClassInfo<>(Label.class, "label").user("labels?").name("Label")
                //.description("")
                //.examples("")
                .defaultExpression(new EventValueExpression<>(Label.class)).parser(new Parser<Label>() {

                    @Override
                    @Nullable
                    public Label parse(String input, ParseContext context) {
                        return null;
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }

                    @Override
                    public String getVariableNamePattern() {
                        return "name:[string]";
                    }

                    @Override
                    public String toString(Label label, int flags) {
                        return toVariableNameString(label);
                    }

                    @Override
                    public String toVariableNameString(Label label) {
                        return "name:" + label.toString();
                    }
                }
            )
        );
    }
}
