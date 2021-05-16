package ml.pkom.skwindow.lang.classinfo;

import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import ml.pkom.skwindow.lang.object.Frame;

public class FrameClass {

    static {
        Classes.registerClass(new ClassInfo<>(Frame.class, "frame").user("frames?").name("Frame")
                //.description("")
                //.examples("")
                .defaultExpression(new EventValueExpression<>(Frame.class)).parser(new Parser<Frame>() {

                    @Override
                    @Nullable
                    public Frame parse(String input, ParseContext context) {
                        return null;
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }

                    @Override
                    public String getVariableNamePattern() {
                        return "title:[string]";
                    }

                    @Override
                    public String toString(Frame frame, int flags) {
                        return toVariableNameString(frame);
                    }

                    @Override
                    public String toVariableNameString(Frame frame) {
                        return "title:" + frame.toString();
                    }
                }
            )
        );
    }
}
