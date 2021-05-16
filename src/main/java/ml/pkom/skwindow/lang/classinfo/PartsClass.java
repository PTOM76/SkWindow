package ml.pkom.skwindow.lang.classinfo;

import org.eclipse.jdt.annotation.Nullable;

import java.awt.Component;
import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;

public class PartsClass {

    static {
        Classes.registerClass(new ClassInfo<>(Component.class, "framepart").user("frameparts?").name("Frameparts")
                //.description("")
                //.examples("")
                .defaultExpression(new EventValueExpression<>(Component.class)).parser(new Parser<Component>() {

                    @Override
                    @Nullable
                    public Component parse(String input, ParseContext context) {
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
                    public String toString(Component component, int flags) {
                        return toVariableNameString(component);
                    }

                    @Override
                    public String toVariableNameString(Component component) {
                        return "name:" + component.toString();
                    }
                }
            )
        );
    }
}
