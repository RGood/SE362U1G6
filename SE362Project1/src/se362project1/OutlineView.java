    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    /*//GEN-END:initComponents
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se362project1;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.bounce.text.LineNumberMargin;
import org.bounce.text.ScrollableEditorPanel;
import org.bounce.text.xml.XMLEditorKit;
import org.bounce.text.xml.XMLFoldingMargin;

/**
 *
 * @author Randy
 */
public class OutlineView extends JFrame {

    /**
     * Creates new form OutlineView
     */
    public OutlineView(String HTMLText) {
        try {
            initComponents();
            JEditorPane editor = new JEditorPane();
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            XMLEditorKit kit = new XMLEditorKit();
            kit.setAutoIndentation(true);
            kit.setTagCompletion(true);
            editor.setEditorKit(kit);
            editor.setText(HTMLText);
            editor.setEditable(false);
            editor.getDocument().putProperty(XMLEditorKit.ERROR_HIGHLIGHTING_ATTRIBUTE, true);
            
            ScrollableEditorPanel editorPanel = new ScrollableEditorPanel(editor);
            
            JScrollPane scroller = new JScrollPane(editorPanel);
            
            JPanel rowHeader = new JPanel(new BorderLayout());
            rowHeader.add(new XMLFoldingMargin(editor), BorderLayout.EAST);
            rowHeader.add(new LineNumberMargin(editor), BorderLayout.WEST);
            scroller.setRowHeaderView(rowHeader);
            
            this.getContentPane().setLayout(new BorderLayout());
            this.getContentPane().add(scroller,BorderLayout.CENTER);
            this.repaint();
            
        } catch (IOException ex) {
            Logger.getLogger(OutlineView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                                            

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OutlineView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OutlineView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OutlineView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OutlineView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new OutlineView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify              
    
    // End of variables declaration                   
}
