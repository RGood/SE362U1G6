/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se362project1;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class Editor extends javax.swing.JFrame implements ActionListener {
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
        System.out.println(index);
        buffers.get(index).setFileName(fileName);
        System.out.println(fileName);
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
    
    public String getCurFileName(){
        int index = jTabbedPane3.getSelectedIndex();
        return buffers.get(index).getFileName();
    }
    
    public void addTab(){
        JEditorPane editorPane = new JEditorPane();
        editorPane.addKeyListener(new Shortcuts(this));
        jTabbedPane3.addTab("*untitled "+(buffers.size()+1)+"*", editorPane);
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
        newPane.addKeyListener(new Shortcuts(this));
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
        jMenuItem13 = new CopyCommand(jTabbedPane3);
        jMenuItem14 = new CutCommand(jTabbedPane3);
        jMenuItem15 = new PasteCommand(jTabbedPane3);
        jMenuItem16 = new SelectAllCommand(jTabbedPane3);
        jMenuItem17 = new IndentCommand(jTabbedPane3);
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new BoldCommand(jTabbedPane3);
        jMenuItem2 = new ItalicCommand(jTabbedPane3);
        jMenuItem3 = new H1TagCommand(jTabbedPane3);
        jMenuItem4 = new H2TagCommand(jTabbedPane3);
        jMenuItem5 = new H3TagCommand(jTabbedPane3);
        jMenuItem6 = new H4TagCommand(jTabbedPane3);
        jMenuItem7 = new H5TagCommand(jTabbedPane3);
        jMenuItem8 = new H6TagCommand(jTabbedPane3);
        jMenuItem9 = new OrderedListCommand(jTabbedPane3);
        jMenuItem10 = new UnorderedListCommand(jTabbedPane3);
        jMenuItem11 = new DefinitionListCommand(jTabbedPane3);
        jMenuItem12 = new TableTagCommand(jTabbedPane3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem13.setText("Copy");
        jMenu2.add(jMenuItem13);
        jMenuItem13.addActionListener(this);

        jMenuItem14.setText("Cut");
        jMenu2.add(jMenuItem14);
        jMenuItem14.addActionListener(this);

        jMenuItem15.setText("Paste");
        jMenu2.add(jMenuItem15);
        jMenuItem15.addActionListener(this);

        jMenuItem16.setText("Select All");
        jMenu2.add(jMenuItem16);
        jMenuItem16.addActionListener(this);

        jMenuItem17.setText("Indent");
        jMenu2.add(jMenuItem17);
        jMenuItem17.addActionListener(this);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("HTML");

        jMenuItem1.setText("Bold");
        jMenu3.add(jMenuItem1);
        jMenuItem1.addActionListener(this);

        jMenuItem2.setText("Italic");
        jMenu3.add(jMenuItem2);
        jMenuItem2.addActionListener(this);

        jMenuItem3.setText("H1");
        jMenu3.add(jMenuItem3);
        jMenuItem3.addActionListener(this);

        jMenuItem4.setText("H2");
        jMenu3.add(jMenuItem4);
        jMenuItem4.addActionListener(this);

        jMenuItem5.setText("H3");
        jMenu3.add(jMenuItem5);
        jMenuItem4.addActionListener(this);

        jMenuItem6.setText("H4");
        jMenu3.add(jMenuItem6);
        jMenuItem6.addActionListener(this);

        jMenuItem7.setText("H5");
        jMenu3.add(jMenuItem7);
        jMenuItem7.addActionListener(this);

        jMenuItem8.setText("H6");
        jMenu3.add(jMenuItem8);
        jMenuItem8.addActionListener(this);

        jMenuItem9.setText("Ordered List");
        jMenu3.add(jMenuItem9);
        jMenuItem9.addActionListener(this);

        jMenuItem10.setText("UnOrdered List");
        jMenu3.add(jMenuItem10);
        jMenuItem10.addActionListener(this);

        jMenuItem11.setText("Definition List");
        jMenu3.add(jMenuItem11);
        jMenuItem11.addActionListener(this);

        jMenuItem12.setText("Table");
        jMenu3.add(jMenuItem12);
        jMenuItem12.addActionListener(this);

        jMenuBar1.add(jMenu3);

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
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        CommandControl control = new CommandControl();
        Command command = (Command)e.getSource();
        control.setCommand(command);
        control.pressButton();
    }
}
