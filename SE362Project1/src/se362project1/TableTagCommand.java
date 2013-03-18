/*Christopher Norman
 * 03/17/13
 * Command Controller
 * 
 * Inserts an table into the buffer, allowing
 * the user to specify the number of cols and rows
 * they want in the table
 */
package se362project1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TableTagCommand extends JButton implements Command, ActionListener {

    private JTextArea text;
    private JButton confirm;
    private JButton cancel;
    private JTextField rows;
    private JTextField cols;
    private JFrame frame;
    private JPanel panel;
    private JLabel colLabel;
    private JLabel rowLabel;

    public TableTagCommand(JTextArea text) {
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
        colLabel = new JLabel("Colums");
        rowLabel = new JLabel("Rows");

        panel.add(rowLabel);
        panel.add(rows);
        panel.add(colLabel);
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

            text.insert("\n<table>", text.getCaretPosition());

            for (int i = 0; i < rowNum; i++) {

                text.insert("\n    <tr>", text.getCaretPosition());

                for (int s = 0; s < colNum; s++) {
                    text.insert("\n        <td></td>", text.getCaretPosition());
                }

                text.insert("\n    </tr>", text.getCaretPosition());

            }

            text.insert("\n</table>", text.getCaretPosition());

        } else if (e.getSource().equals(cancel)) {

            frame.dispose();
        }
    }
}
