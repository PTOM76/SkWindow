package ml.pkom.skwindow.lang.object.parts;

import javax.swing.JLabel;
import java.awt.Font;

public class Label {

    String text = "";
    String fontName = Font.DIALOG;
    int fontSize = 15;
    JLabel label = new JLabel();

    public JLabel getPart(){
        return label;
    }

    public void setPart(JLabel label) {
        this.label = label;
    }

    public String getText(){
        text = label.getText();
        return text;
    }

    public void setFontSize(int i){
        fontSize = i;
        label.setFont(new Font(fontName, Font.PLAIN, fontSize));
    }
  
    public int getFontSize() {
        fontSize = label.getFont().getSize();
        return fontSize;
    }

    public void setFont(String s) {
        fontName = s;
        label.setFont(new Font(fontName, Font.PLAIN, fontSize));
    }

    public String getFont() {
        fontName = label.getFont().getFontName();
        return fontName;
    }

    public void setText(String text) {
        text = text.replaceAll("\\\\\\[", "ffd120a5-5c2f-e8fa-110a-d6a1b6b54621").replaceAll("\\\\\\]", "ffd120a5-5c2f-e8fa-110a-d6a1b6b54622");
        text = text.replaceAll("\\[([a-zA-Z0-9]+)\\](.*)\\[/([a-zA-Z0-9]+)\\]", "<$1>$2</$3>");
        text = text.replaceAll("ffd120a5-5c2f-e8fa-110a-d6a1b6b54621", "[").replaceAll("ffd120a5-5c2f-e8fa-110a-d6a1b6b54622", "]");
        this.text = text;
        label.setText(this.text);
        return;
    }
}
