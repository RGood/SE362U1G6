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
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JList;

/**
 *
 * @author Randy
 */
public class Editor extends javax.swing.JFrame implements ActionListener {
    FormatCheck checker = new BasicHTMLParser();
    /**
     * Creates new form Editor
     */
    public Editor() {
        initComponents();
    }
    
    public boolean check(){
        HTMLBuffer buf = (HTMLBuffer)jTabbedPane3.getSelectedComponent().getKeyListeners()[1];
        return checker.Check(buf);
    }
    
    public boolean checkAt(int index){
        if (index<jTabbedPane3.getTabCount()){
            HTMLBuffer buf = (HTMLBuffer)jTabbedPane3.getComponentAt(index).getKeyListeners()[1];
            return checker.Check(buf);
        }
        return false;
    }
    
    public void save(){
        HTMLBuffer buf = (HTMLBuffer)jTabbedPane3.getSelectedComponent().getKeyListeners()[1];
        buf.save();
        jTabbedPane3.setTitleAt(jTabbedPane3.getSelectedIndex(), buf.getFileName());
    }
    
    public void saveAs(String fileName){
        HTMLBuffer buf = (HTMLBuffer)jTabbedPane3.getSelectedComponent().getKeyListeners()[1];
        buf.setFileName(fileName);
        buf.save();
        jTabbedPane3.setTitleAt(jTabbedPane3.getSelectedIndex(), buf.getFileName());
    }
    
    public void closeCur(){
        if(this.tabsOpen()<=1){
            HTMLBuffer buf = (HTMLBuffer)jTabbedPane3.getComponentAt(0).getKeyListeners()[1];
            if (!buf.isSaved()) {
                Object[] options = {"Yes, abort.", "No, continue."};
                int n = JOptionPane.showOptionDialog(this, "The file " + buf.getFileName() + " is not saved. Abort termination?", 
                        "Unsaved File", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
                        null, options, options[0]);
                if(n == 0){
                    return;
                }
            }
            this.dispose();
        }
        int index = jTabbedPane3.getSelectedIndex();
        HTMLBuffer buf = (HTMLBuffer)jTabbedPane3.getComponentAt(index).getKeyListeners()[1];
        if (!buf.isSaved()) {
            Object[] options = {"Yes, abort.", "No, continue."};
            int n = JOptionPane.showOptionDialog(this, "The file " + buf.getFileName() + " is not saved. Abort termination?", 
                    "Unsaved File", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
                    null, options, options[0]);
            if(n == 0){
                return;
            }
        }
        jTabbedPane3.remove(index);
    }
    
    public void saveCurState(){
        ((HTMLBuffer)jTabbedPane3.getSelectedComponent().getKeyListeners()[1]).saveState();
    }
    
    public void undoCurState(){
        ((HTMLBuffer)jTabbedPane3.getSelectedComponent().getKeyListeners()[1]).restoreState();
        HTMLBuffer buf = (HTMLBuffer)jTabbedPane3.getSelectedComponent().getKeyListeners()[1];
        ((JEditorPane)jTabbedPane3.getSelectedComponent()).setText(buf.getText());
    }
    
    public void closeAt(int index){
        if(this.tabsOpen()<=1){
            this.dispose();
        }
        if(index<jTabbedPane3.getTabCount()){
            jTabbedPane3.remove(index);
        }
    }
    
    public String getCurFileName(){
        HTMLBuffer buf = (HTMLBuffer)jTabbedPane3.getSelectedComponent().getKeyListeners()[1];
        return buf.getFileName();
    }
    
    public int tabsOpen(){
        return jTabbedPane3.getTabCount();
    }
    
    public void addTab(){
        JEditorPane editorPane = new JEditorPane();
        editorPane.addKeyListener(new Shortcuts(this));
        editorPane.addKeyListener(new HTMLBuffer(editorPane));
        jTabbedPane3.addTab("*untitled "+(jTabbedPane3.getTabCount()+1)+"*", editorPane);
    }
    
    public boolean openTab(String filename){
        File inFile = new File(filename);
        JEditorPane newPane = new JEditorPane();
        HTMLBuffer newBuff = new HTMLBuffer(newPane,filename);
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
        newPane.addKeyListener(new Shortcuts(this));
        newPane.addKeyListener(newBuff);
        newPane.setText(newBuff.getText());
        jTabbedPane3.addTab(newBuff.getFileName(), newPane);
        
        return true;
    }
    
    public void linksList(){
        JFrame f = new JFrame("Links List");
        f.setSize(400, 150);
        Container content = f.getContentPane();
        String[] data = {"one", "two", "three", "four"};
        content.add(new JList(data));
        f.setVisible(true);
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
        New = new NewCommand(this);
        Open = new OpenCommand(this);
        Save = new SaveCommand(this);
        SaveAs = new javax.swing.JMenuItem();
        Close = new CloseCommand(this);
        jMenu2 = new javax.swing.JMenu();
        jMenuItem13 = new CopyCommand(jTabbedPane3);
        jMenuItem14 = new CutCommand(jTabbedPane3);
        jMenuItem15 = new PasteCommand(jTabbedPane3);
        jMenuItem16 = new SelectAllCommand(jTabbedPane3);
        jMenuItem17 = new IndentCommand(jTabbedPane3);
        Undo = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new BoldCommand(jTabbedPane3);
        jMenuItem2 = new ItalicCommand(jTabbedPane3);
        jMenuItem3 = new H1TagCommand(jTabbedPane3, this);
        jMenuItem4 = new H2TagCommand(jTabbedPane3);
        jMenuItem5 = new H3TagCommand(jTabbedPane3);
        jMenuItem6 = new H4TagCommand(jTabbedPane3);
        jMenuItem7 = new H5TagCommand(jTabbedPane3);
        jMenuItem8 = new H6TagCommand(jTabbedPane3);
        jMenuItem9 = new OrderedListCommand(jTabbedPane3);
        jMenuItem10 = new UnorderedListCommand(jTabbedPane3);
        jMenuItem11 = new DefinitionListCommand(jTabbedPane3);
        jMenuItem12 = new TableTagCommand(jTabbedPane3);
        jMenuItem18 = new IMGcommand(jTabbedPane3);
        jMenuItem19 = new HREFcommand(jTabbedPane3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenu1.setText("File");

        New.setText("New ");
        jMenu1.add(New);
        New.addActionListener(this);

        Open.setText("Open");
        jMenu1.add(Open);
        Open.addActionListener(this);

        Save.setText("Save");
        jMenu1.add(Save);
        Save.addActionListener(this);

        SaveAs.setText("Save As");
        jMenu1.add(SaveAs);
        SaveAs.addActionListener(this);

        Close.setText("Close");
        jMenu1.add(Close);
        Close.addActionListener(this);

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

        Undo.setText("Undo");
        jMenu2.add(Undo);
        Undo.addActionListener(this);

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
        jMenuItem5.addActionListener(this);

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

        jMenuItem18.setText("IMG");
        jMenu3.add(jMenuItem18);
        jMenuItem18.addActionListener(this);

        jMenuItem19.setText("HREF");
        jMenu3.add(jMenuItem19);
        jMenuItem19.addActionListener(this);

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
    private javax.swing.JMenuItem Close;
    private javax.swing.JMenuItem New;
    private javax.swing.JMenuItem Open;
    private javax.swing.JMenuItem Save;
    private javax.swing.JMenuItem SaveAs;
    private javax.swing.JMenuItem Undo;
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
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
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

    CommandControl control = new CommandControl(this);
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(Save)){
            if(check() == false){
                Object[] options = {"Yes, save.", "No, don't save."};
                int n = JOptionPane.showOptionDialog(this, "The file is in an improper format. Save anyway?", 
                        "Unsuccessful Check", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
                        null, options, options[0]);
                if(n == 1){
                    return;
                }
            }
            save();
        }
        else if(e.getSource().equals(SaveAs)){
            if(check() == false){
                Object[] options = {"Yes, save.", "No, don't save."};
                int n = JOptionPane.showOptionDialog(this, "The file is in an improper format. Save anyway?", 
                        "Unsuccessful Check", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
                        null, options, options[0]);
                if(n == 1){
                    return;
                }
            }
            SaveCommand com = new SaveCommand();
            com.execute();
            saveAs(com.getFile());
        }
        else if(e.getSource().equals(Undo)){
            control.undoButton();
        }
        else{
            JEditorPane pane = (JEditorPane)jTabbedPane3.getSelectedComponent();
            ((HTMLBuffer)jTabbedPane3.getSelectedComponent().getKeyListeners()[1]).update(pane.getText());
            saveCurState();
            Command command = (Command)e.getSource();
            control.setCommand(command);
            control.pressButton();
        }
    }
}
