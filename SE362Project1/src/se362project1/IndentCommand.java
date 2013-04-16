/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se362project1;


import javax.swing.JEditorPane;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.text.BadLocationException;

/**
 *
 * @author soldiercnorm
 */
public class IndentCommand extends JMenuItem implements Command {
    
    private JTabbedPane text;
    private JEditorPane pane;
    private Editor e;
    
    public IndentCommand(JTabbedPane text, Editor e){
        this.text = text;
        this.e = e;
    }
    
    @Override
    public void execute() {
        pane = (JEditorPane)text.getSelectedComponent();
        if(pane.getSelectedText() == null){
            try {
                pane.getDocument().insertString(pane.getCaretPosition(),"\t", null);
            } catch (BadLocationException ex) {

            }
        }
        else{
            try { 
                pane.getDocument().insertString(pane.getSelectionStart() ,"\t", null);
            } catch (BadLocationException ex) {
                
            }
        }
    }
}
