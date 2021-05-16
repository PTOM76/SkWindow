package ml.pkom.skwindow.lang.classinfo;

import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import ml.pkom.skwindow.lang.object.Panel;

public class PanelClass {

    static {
        Classes.registerClass(new ClassInfo<>(Panel.class, "panel").user("panels?").name("Panel")
                //.description("")
                //.examples("")
                .defaultExpression(new EventValueExpression<>(Panel.class)).parser(new Parser<Panel>() {

                    @Override
                    @Nullable
                    public Panel parse(String input, ParseContext context) {
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
                    public String toString(Panel panel, int flags) {
                        return toVariableNameString(panel);
                    }

                    @Override
                    public String toVariableNameString(Panel panel) {
                        return "name:" + panel.toString();
                    }
                }
            )
        );
    }
}
