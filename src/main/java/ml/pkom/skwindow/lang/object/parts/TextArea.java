package ml.pkom.skwindow.lang.object.parts;

import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class TextArea {

    private int rows = 1;
    private int cols = 80;
    private String text = "";
    private JTextArea textArea = new JTextArea(rows, cols);

    public TextArea(){
        textArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
    }

    public JTextArea getPart(){
        return textArea;
    }

    public void setPart(JTextArea textArea) {
        this.textArea = textArea;
    }

    public void setRows(int i) {
        rows = i;
        textArea.setRows(rows);
    }

    public void setCols(int i) {
        cols = i;
        textArea.setColumns(cols);
    }

    public int getRows() {
        rows = textArea.getRows();
        return rows;
    }

    public int getCols() {
        cols = textArea.getColumns();
        return cols;
    }

    public String getText(){
        text = textArea.getText();
        return text;
    }
  
    public void setText(String text) {
        this.text = text;
        textArea.setText(this.text);
        return;
    }
}
