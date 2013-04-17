/*Christopher Norman
 * 
 * Close Command
 * Closes the currently selected tab
 */

package se362project1;
import javax.swing.JMenuItem;

//Sub classes jemenuitem and implements the command interface 
//to be treated as a command
public class CloseCommand extends JMenuItem implements Command{

    private Editor e;

    //Passes in an editor
    public CloseCommand(Editor e){
        this.e = e;
    }
    
    //execute command implemented form the command interface
    //calls to a close method
    @Override
    public void execute() {
        e.closeCur();
    }

}
