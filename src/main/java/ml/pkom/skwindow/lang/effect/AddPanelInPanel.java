package ml.pkom.skwindow.lang.effect;

import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;
import java.awt.BorderLayout;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import ml.pkom.skwindow.lang.object.Panel;

public class AddPanelInPanel extends Effect {

    static {
        Skript.registerEffect(AddPanelInPanel.class, "[(skwindow)] add panel %~panel% (in|inside) [%-string% of] (%~panel%)");
    }

    private Expression<Panel> panelexpr;
    private Expression<String> borderLayoutExpre;
    private Expression<Panel> inPanelxpr;
    private Panel inPanel = new Panel();
    private Panel panel = new Panel();

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expre, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.panelexpr = (Expression<Panel>) expre[0];
        //Bukkit.getLogger().info(expre[1].getSingle().toString());
        this.borderLayoutExpre = (Expression<String>) expre[1];
        this.inPanelxpr = (Expression<Panel>) expre[2];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return "effect: AddPanelInPanel , Expression: " + panelexpr.toString(event, debug);
    }

    @Override
    protected void execute(Event event) {
        String borderLayout;
        try {
            borderLayout = borderLayoutExpre.getSingle(event);
        } catch (NullPointerException e) {
            borderLayout = BorderLayout.CENTER;
        }
        if (borderLayout.equalsIgnoreCase("North")) {
            borderLayout = BorderLayout.NORTH;
        }else if (borderLayout.equalsIgnoreCase("South")) {
            borderLayout = BorderLayout.SOUTH;
        } else if (borderLayout.equalsIgnoreCase("East")) {
            borderLayout = BorderLayout.EAST;
        } else if (borderLayout.equalsIgnoreCase("West")) {
            borderLayout = BorderLayout.WEST;
        } else if (borderLayout.equalsIgnoreCase("Center")) {
            borderLayout = BorderLayout.CENTER;
        }

        panel = panelexpr.getSingle(event);
        inPanel = inPanelxpr.getSingle(event);
        try {
            inPanel.addPanel(panel, borderLayout);
        } catch (NullPointerException e) {
            inPanel.addPanel(panel, BorderLayout.CENTER);
        }
    }
}
