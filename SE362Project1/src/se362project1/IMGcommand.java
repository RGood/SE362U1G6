/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se362project1;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.text.BadLocationException;

/**
 *
 * @author christophernorman
 */
public class IMGcommand extends JMenuItem implements Command {
    
    private JTabbedPane text;
    private Editor e;
    private JFileChooser open;
    private String URL;
    private JEditorPane pane;
    
    public IMGcommand(JTabbedPane text, Editor e){
        this.text = text;
        this.e = e;
    }

    @Override
    public void execute() {
       e.saveCurState();
        
       pane = (JEditorPane)text.getSelectedComponent();
       open = new JFileChooser();
       open.showOpenDialog(null);
       URL = open.getSelectedFile().getAbsolutePath();
       
       
        try {
            pane.getDocument().insertString(pane.getCaretPosition(), "<img src=\"" + URL + "\" />", null);
        } catch (BadLocationException ex) {
           
        }
        
       
        
    }

    @Override
    public void undo() {
        e.undoCurState();
    }
    
    
    
}
