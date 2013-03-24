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
    
    public SelectAllCommand(JTabbedPane text){
        this.text = text;
    }
    
    @Override
    public void execute() {
        pane = (JEditorPane)text.getSelectedComponent();
        pane.selectAll();
    }

    @Override
    public void undo() {
        
    }
    
}
