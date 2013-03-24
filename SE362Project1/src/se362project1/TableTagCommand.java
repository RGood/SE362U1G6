/*Christopher Norman
 * 03/17/13
 * Table Command
 * 
 * Inserts an table into the buffer, allowing
 * the user to specify the number of cols and rows
 * they want in the table
 */
package se362project1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.BadLocationException;

public class TableTagCommand extends JMenuItem implements Command, ActionListener {

    private JEditorPane pane;
    private JTabbedPane text;
    private JButton confirm;
    private JButton cancel;
    private JTextField rows;
    private JTextField cols;
    private JFrame frame;
    private JPanel panel;
    private JLabel colLabel;
    private JLabel rowLabel;

    public TableTagCommand(JTabbedPane text) {
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
        
       pane = (JEditorPane)text.getSelectedComponent();

        try {
            if (e.getSource().equals(confirm)) {

            int rowNum = Integer.parseInt(rows.getText());
            int colNum = Integer.parseInt(cols.getText());
            

            pane.getDocument().insertString(pane.getCaretPosition(),"\n<table>", null);  

            for (int i = 0; i < rowNum; i++) {

                pane.getDocument().insertString(pane.getCaretPosition(),"\n    <tr>", null);    
                
                for (int s = 0; s < colNum; s++) {
                    pane.getDocument().insertString(pane.getCaretPosition(),"\n        <td></td>", null);   
                }

                pane.getDocument().insertString(pane.getCaretPosition(),"\n    </tr>", null);   

            }

            pane.getDocument().insertString(pane.getCaretPosition(),"\n</table>", null);   

        } else if (e.getSource().equals(cancel)) {

            frame.dispose();
        }
            
            
        } catch (BadLocationException ex) {
            System.out.print("NULL");
        }

    }
}
