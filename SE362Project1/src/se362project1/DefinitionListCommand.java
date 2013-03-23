/*Christopher Norman
 * 03/17/13
 * Definition List Command
 *
 * Creates a definition List, asking the user for
 * the number of definition terms and definitions
 *
 */
package se362project1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.text.BadLocationException;

public class DefinitionListCommand extends JMenuItem implements Command, ActionListener {

    private JTabbedPane text;
    private JButton confirm;
    private JButton cancel;
    private JTextField rows;
    private JTextField cols;
    private JFrame frame;
    private JPanel panel;
    private JLabel defLabel;
    private JLabel termLabel;
    private JEditorPane pane;

    public DefinitionListCommand(JTabbedPane text) {
        this.text = text;
    }

    @Override
    public void execute() {
        frame = new JFrame();
        panel = new JPanel();
        rows = new JTextField(10);
        cols = new JTextField(10);
        confirm = new JButton("Confirm");
        confirm.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        defLabel = new JLabel("Definitions");
        termLabel = new JLabel("Terms");

        panel.add(defLabel);
        panel.add(rows);
        panel.add(termLabel);
        panel.add(cols);
        panel.add(confirm);
        panel.add(cancel);
        frame.add(panel);

        frame.setVisible(true);
        frame.setSize(500, 100);

    }

    @Override
    public void undo() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JScrollPane scroll = (JScrollPane) text.getComponentAt(text.getSelectedIndex());
        JViewport view = (JViewport) scroll.getViewport();
        pane = (JEditorPane) view.getComponent(0);

        try {

            if (e.getSource().equals(confirm)) {

                int rowNum = Integer.parseInt(rows.getText());
                int colNum = Integer.parseInt(cols.getText());

                pane.getDocument().insertString(pane.getCaretPosition(), "\n<dl>", null);

                while (rowNum > 0) {
                    pane.getDocument().insertString(pane.getCaretPosition(), "\n    <dt></dt>", null);
                    if (colNum > 0) {
                        pane.getDocument().insertString(pane.getCaretPosition(), "\n    <dd></dd>", null);
                        colNum--;
                    }

                    rowNum--;
                }

                if (colNum > 0) {

                    while (colNum > 0) {
                        pane.getDocument().insertString(pane.getCaretPosition(), "\n    <dd></dd>", null);
                        colNum--;
                    }
                }


                pane.getDocument().insertString(pane.getCaretPosition(), "\n</dl>", null);

            } else if (e.getSource().equals(cancel)) {

                frame.dispose();
            }

        } catch (BadLocationException ex) {
            System.out.print("NULL");
        }

    }
}
