/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se362project1;

import javax.swing.JMenuItem;

/**
 *
 * @author soldiercnorm
 */
public class LinksCommand extends JMenuItem implements Command {
    
    boolean show = true;
    private LinksList list;
    
    public LinksCommand(LinksList list){
        
        this.list = list;
    }

    @Override
    public void execute() {
        
        if(show){
            list.f.setVisible(show);
            show = false;
            
        }
        else{
            list.f.setVisible(show);
            show = true;
        }
    }
    
}
