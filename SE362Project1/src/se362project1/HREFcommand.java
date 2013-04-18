package se362project1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

/**
 *
 * @author christophernorman
 */
public class HREFcommand extends JMenuItem implements Command, ActionListener {

    private JTabbedPane text;
    private LinksList e;
    private JEditorPane pane;
    private JButton confirm;
    private JButton cancel;
    private JTextField rows;
    private JTextField cols;
    private JFrame frame;
    private JPanel panel;
    private JLabel colLabel;
    private JLabel rowLabel;
    private Editor ed;

    public HREFcommand(JTabbedPane text, LinksList e, Editor ed) {
        this.text = text;
        this.e = e;  
        this.ed = ed;
    }

    @Override
    public void execute() {
        frame = new JFrame();
        panel = new JPanel();
        rows = new JTextField(10);
        cols = new JTextField(10);
        confirm = new JButton("Confirm");
        confirm.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        colLabel = new JLabel("URL");
        rowLabel = new JLabel("Text");

        panel.add(rowLabel);
        panel.add(rows);
        panel.add(colLabel);
        panel.add(cols);
        panel.add(confirm);
        panel.add(cancel);
        frame.add(panel);

        frame.setVisible(true);
        frame.setSize(500, 100);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        ed.saveCurState();
        
        if (ae.getSource().equals(confirm)) {
            pane = (JEditorPane) text.getSelectedComponent();



            try {
                pane.getDocument().insertString(pane.getCaretPosition(), "<a href=\"" + cols.getText() 
                        + "\" >" + rows.getText() + "</a>", null);
            } catch (BadLocationException ex) {
            }
            
            e.addLink(cols.getText(), text.getSelectedIndex());
            e.displayLinksList(text);
            frame.dispose();
        }else{
            
            frame.dispose();
        }
        

    }
}
