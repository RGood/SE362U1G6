/*Christopher Norman
 * 03/17/13
 * Bold Command
 *
 * Inserts a Bold tag in the buffer
 *
 */
package se362project1;


import javax.swing.JEditorPane;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.text.BadLocationException;

//This command is a sub class of JMenuItem and implements the
//command interface
public class BoldCommand extends JMenuItem implements Command {

    private JTabbedPane text;
    private JEditorPane pane;
    private Editor e;

    //Passes in a jtabbedpane and Editor so the tag can
    //be inserted into the correct buffer
    public BoldCommand(JTabbedPane text, Editor e) {
        this.text = text;
        this.e = e;
    }

    //Overided method from the command interface. 
    //Used to execute the concrete command 
    @Override
    public void execute() {
        
        //Gets the selected editor pane 
        pane = (JEditorPane)text.getSelectedComponent();
        
        //Try block that trys to insert the tag into the document, if it exsist
        try {
            pane.getDocument().insertString(pane.getCaretPosition(), "<b></b>", null);
        } catch (BadLocationException ex) {
            System.out.print("NULL");
        }
    }
}
