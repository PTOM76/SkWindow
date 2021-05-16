package ml.pkom.skwindow.lang.object;

import java.util.ArrayList;

import java.awt.Component;
import javax.swing.JPanel;

public class Panel {
    private ArrayList<Panel> Panels = new ArrayList<Panel>();
    private ArrayList<String> PanelLayouts = new ArrayList<String>();
    private ArrayList<Component> Parts = new ArrayList<Component>();
    private JPanel jPanel = new JPanel();

    public void addParts(Component part) {
        Parts.add(part);
    }

    public void removeParts(Component part) {
        Parts.remove(part);
    }

    public void addPanel(Panel panel, String borderLayout) {
        Panels.add(panel);
        PanelLayouts.add(borderLayout);
    }

    public void removePanel(Panel panel) {
        PanelLayouts.remove(Panels.indexOf(panel));
        Panels.remove(panel);
    }

    public JPanel getMainPanel() {
        if (Panels.size() >= 1) {
            for (Panel panel : Panels) {
                jPanel.add(panel.getMainPanel(), PanelLayouts.get(Panels.indexOf(panel)));
            }
        }
        if (Parts.size() >= 1) {
            for (Component part : Parts) {
                jPanel.add(part);
            }
        }
        return jPanel;
    }
}
