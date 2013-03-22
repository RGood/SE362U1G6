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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DefinitionListCommand extends JButton implements Command, ActionListener {

    private JTextArea text;
    private JButton confirm;
    private JButton cancel;
    private JTextField rows;
    private JTextField cols;
    private JFrame frame;
    private JPanel panel;
    private JLabel defLabel;
    private JLabel termLabel;

    public DefinitionListCommand(JTextArea text) {
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

        if (e.getSource().equals(confirm)) {

            int rowNum = Integer.parseInt(rows.getText());
            int colNum = Integer.parseInt(cols.getText());

            text.insert("\n<dl>", text.getCaretPosition());

            while (rowNum > 0) {
                text.insert("\n    <dt></dt>", text.getCaretPosition());
                if (colNum > 0) {
                    text.insert("\n    <dd></dd>", text.getCaretPosition());
                    colNum--;
                }

                rowNum--;
            }

            if (colNum > 0) {

                while (colNum > 0) {
                    text.insert("\n    <dd></dd>", text.getCaretPosition());
                    colNum--;
                }
            }


            text.insert("\n</dl>", text.getCaretPosition());

        } else if (e.getSource().equals(cancel)) {

            frame.dispose();
        }
    }
}
