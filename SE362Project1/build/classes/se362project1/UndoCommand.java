package se362project1;

import javax.swing.JMenuItem;

/**
 *
 * @author christophernorman
 */
public class UndoCommand  extends JMenuItem implements Command {
    
    private Editor e;
    
    public UndoCommand(Editor e){
        this.e = e;
    }

    @Override
    public void execute() {
         e.undoCurState();
    }

}
