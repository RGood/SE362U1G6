/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se362project1;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JEditorPane;

/**
 *
 * @author Randy
 */
public class Editor extends javax.swing.JFrame {
    ArrayList<HTMLBuffer> buffers = new ArrayList<HTMLBuffer>();
    FormatCheck checker = new BasicHTMLParser();
    /**
     * Creates new form Editor
     */
    public Editor() {
        initComponents();
    }
    
    public boolean check(){
        int index = jTabbedPane3.getSelectedIndex();
        return checker.Check(buffers.get(index));
    }
    
    public boolean checkAt(int index){
        if (index<buffers.size()){
            return checker.Check(buffers.get(index));
        }
        return false;
    }
    
    public void save(){
        int index = jTabbedPane3.getSelectedIndex();
        buffers.get(index).save();
    }
    
    public void saveAs(String fileName){
        int index = jTabbedPane3.getSelectedIndex();
        buffers.get(index).setFileName(fileName);
        buffers.get(index).save();
        
    }
    
    public void closeCur(){
        int index = jTabbedPane3.getSelectedIndex();
        jTabbedPane3.remove(index);
        buffers.remove(index);
    }
    
    public void closeAt(int index){
        if(index<buffers.size()){
            jTabbedPane3.remove(index);
            buffers.remove(index);
        }
    }
    
    public void addTab(){
        JEditorPane editorPane = new JEditorPane();
        jTabbedPane3.addTab("*untitled "+buffers.size()+1+"*", editorPane);
        buffers.add(new HTMLBuffer());
    }
    
    public boolean openTab(String filename){
        File inFile = new File(filename);
        HTMLBuffer newBuff = new HTMLBuffer(filename);
        if(!inFile.exists()){
            return false;
        }
        try{
            BufferedReader buff = new BufferedReader(new FileReader(inFile));
            while(buff.ready()){
                newBuff.appendLine(buff.readLine());
            }
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
        JEditorPane newPane = new JEditorPane();
        jTabbedPane3.addTab("*untitled "+buffers.size()+1+"*", newPane);
        buffers.add(newBuff);
        
        return true;
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(final String args[]) {
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
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Editor editor = new Editor();
                editor.setTitle("Group 6 Editor");
                Toolkit tk = Toolkit.getDefaultToolkit();  
                int xSize = ((int) tk.getScreenSize().getWidth());  
                int ySize = ((int) tk.getScreenSize().getHeight());  
                editor.setSize(xSize,ySize);  
                editor.setVisible(true);
                editor.addTab();
            }
            
        });
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    // End of variables declaration//GEN-END:variables
}
