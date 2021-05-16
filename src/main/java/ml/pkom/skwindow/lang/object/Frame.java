package ml.pkom.skwindow.lang.object;

import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.Rectangle;
import java.awt.Container;
//import java.awt.BorderLayout;

import org.bukkit.Bukkit;

import ml.pkom.skwindow.Mod;

public class Frame {
    private String frameTitle;
    private URL frameIconUrl = Mod.class.getResource("/icon/default.png");
    private FrameSize frameSize = new FrameSize();
    private FrameLoc frameLoc = new FrameLoc();
    private String icon = "default";
    private JFrame jFrame = new JFrame("<none>");
    private Container contentPage = jFrame.getContentPane();
    private ArrayList<Panel> contentJPanels = new ArrayList<Panel>();

    public Frame(){
        setTheme("system");
    }

    public String getTitle() {
        return frameTitle;
    }

    public void setTitle(String title) {
        frameTitle = title;
        if (frameTitle == null) {
            frameTitle = "<none>";
        }
        jFrame.setTitle(frameTitle);
    }

    public FrameSize size() {
        return frameSize;
    }

    public FrameLoc location() {
        return frameLoc;
    }

    public void setIcon(String icon) {
        this.icon = icon;
        if (icon.equalsIgnoreCase("hide")) {
            frameIconUrl = Mod.class.getResource("/icon/hide.png");
        } else if (icon.equalsIgnoreCase("default")) {
            frameIconUrl = Mod.class.getResource("/icon/default.png");
        }
        try {
            jFrame.setIconImage(new ImageIcon(frameIconUrl).getImage());
        } catch (NullPointerException e) {
            Bukkit.getLogger().info("Image is not found.");
            jFrame.setIconImage(null);
        }
        return;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setCenterLocation() {
        jFrame.setSize(size().getWidth(), size().getHeight());
        Rectangle screen = jFrame.getGraphicsConfiguration().getBounds();
        location().setX(screen.x + screen.width / 2 - jFrame.getSize().width / 2);
        location().setY(screen.y + screen.height / 2 - jFrame.getSize().height / 2);
    }

    public void addPanel(Panel panel) {
        contentJPanels.add(panel);
    }

    public String getTheme() {
        return UIManager.getLookAndFeel().toString();
    }

    public void setTheme(String type) {
        String mlfClassName;
        if (type.equalsIgnoreCase("system")) {
            mlfClassName = UIManager.getSystemLookAndFeelClassName();
        } else if (type.equalsIgnoreCase("metal")) {
            mlfClassName = "javax.swing.plaf.metal.MetalLookAndFeel";
        } else if (type.equalsIgnoreCase("motif")) {
            mlfClassName = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
        } else {
            mlfClassName = type;
        }
        try {
            UIManager.setLookAndFeel(mlfClassName);
            SwingUtilities.updateComponentTreeUI(jFrame);
        } catch (Exception e) {
            mlfClassName = UIManager.getSystemLookAndFeelClassName();
            try {
                UIManager.setLookAndFeel(mlfClassName);
                SwingUtilities.updateComponentTreeUI(jFrame);  
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void show() {
        jFrame.setSize(size().getWidth(), size().getHeight());
        jFrame.setLocation(location().getX(), location().getY());
        if (contentJPanels.size() >= 1){
            updatePanel();
        }
        jFrame.setVisible(true);
    }

    public void updatePanel(){
        for (Panel panel : contentJPanels) {
            contentPage.add(panel.getMainPanel());
        }
    }

    public void update() {
        jFrame.setSize(size().getWidth(), size().getHeight());
        jFrame.setLocation(location().getX(), location().getY());
        jFrame.setVisible(true);
    }
    
    public void unVisible() {
        jFrame.setVisible(false);
    }

    public void close() {
        jFrame.setVisible(false);
        jFrame.dispose();
    }
}
