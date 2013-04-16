/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se362project1;

import javax.swing.JEditorPane;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

/**
 *
 * @author soldiercnorm
 */
public class SelectAllCommand extends JMenuItem implements Command {

    private JTabbedPane text;
    private JEditorPane pane;
    private Editor e;
    
    public SelectAllCommand(JTabbedPane text, Editor e){
        this.text = text;
        this.e = e;
    }
    
    @Override
    public void execute() {
        e.saveCurState();
        pane = (JEditorPane)text.getSelectedComponent();
        pane.selectAll();
    }

    @Override
    public void undo() {
        
    }
    
}
