
package se362project1;

import javax.swing.JMenuItem;

/**
 *
 * @author christophernorman
 */
public class OutlineViewCommand extends JMenuItem implements Command {
    
    
    private Editor e;
    
    public OutlineViewCommand(Editor e){
        this.e = e;  
    }
    
    

    @Override
    public void execute() {
        e.openCurOutline();
    }
    
    
}
