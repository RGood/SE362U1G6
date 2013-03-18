/*Christopher Norman
 * 03/17/13
 * Command Controller
 *
 * Pastes the selected text
 *
 */
package se362project1;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class PasteCommand extends JButton implements Command {

    private JTextArea text;
    private String copyText = " ";

    public PasteCommand(JTextArea text) {
        this.text = text;
    }

    @Override
    public void execute() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);

        try {
            copyText = (String) contents.getTransferData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        text.insert(copyText, text.getCaretPosition());
    }

    @Override
    public void undo() {
    }
}
