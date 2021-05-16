package ml.pkom.skwindow.lang.classinfo;

import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import ml.pkom.skwindow.lang.object.parts.TextArea;

public class TextAreaClass {

    static {
        Classes.registerClass(new ClassInfo<>(TextArea.class, "textarea").user("textareas?").name("TextArea")
                //.description("")
                //.examples("")
                .defaultExpression(new EventValueExpression<>(TextArea.class)).parser(new Parser<TextArea>() {

                    @Override
                    @Nullable
                    public TextArea parse(String input, ParseContext context) {
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
                    public String toString(TextArea textArea, int flags) {
                        return toVariableNameString(textArea);
                    }

                    @Override
                    public String toVariableNameString(TextArea textArea) {
                        return "name:" + textArea.toString();
                    }
                }
            )
        );
    }
}
