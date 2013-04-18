/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se362project1;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JEditorPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Randy
 */
public class Editor extends javax.swing.JFrame {
    FormatCheck checker = new BasicHTMLParser();
    private ArrayList<JMenuItem> items = new ArrayList<JMenuItem>();
    private String menuNames[] = {"New", "Open", "Save", "Save As", "Close", "Copy", 
    "Cut", "Paste", "Select All", "Indent", "Undo", "Bold", "Italic", "H1", "H2",
    "H3", "H4", "H5", "H6", "Ordered List", "UnOrdered List", "Definition List", 
    "Table", "IMG", "HREF", "Links"};
    
    
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
        editorPane.addKeyListener(new Shortcuts(this, jTabbedPane3));
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
        newPane.addKeyListener(new Shortcuts(this, jTabbedPane3));
        newPane.addKeyListener(newBuff);
        newPane.setText(newBuff.getText());
        jTabbedPane3.addTab(newBuff.getFileName(), newPane);
        
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
        list = new LinksList(jTabbedPane3);
        control = new CommandControl(this, jTabbedPane3);
        jMenu1 = new javax.swing.JMenu();
        New = new NewCommand(this);
        Open = new OpenCommand(this);
        Save = new SaveCommand(this);
        SaveAs = new SaveAsCommand(this);
        Close = new CloseCommand(this);
        jMenu2 = new javax.swing.JMenu();
        Copy = new CopyCommand(jTabbedPane3, this);
        Cut = new CutCommand(jTabbedPane3, this);
        Paste = new PasteCommand(jTabbedPane3, this);
        SelectAll = new SelectAllCommand(jTabbedPane3, this);
        Indent = new IndentCommand(jTabbedPane3, this);
        Undo = new UndoCommand(this);
        jMenu3 = new javax.swing.JMenu();
        Bold = new BoldCommand(jTabbedPane3, this);
        Italic = new ItalicCommand(jTabbedPane3, this);
        H1 = new H1TagCommand(jTabbedPane3, this);
        H2 = new H2TagCommand(jTabbedPane3, this);
        H3 = new H3TagCommand(jTabbedPane3, this);
        H4 = new H4TagCommand(jTabbedPane3, this);
        H5 = new H5TagCommand(jTabbedPane3, this);
        H6 = new H6TagCommand(jTabbedPane3, this);
        OrderedList = new OrderedListCommand(jTabbedPane3, this);
        UnOrderedList = new UnorderedListCommand(jTabbedPane3, this);
        DefinitionList = new DefinitionListCommand(jTabbedPane3, this);
        Table = new TableTagCommand(jTabbedPane3, this);
        IMG = new IMGcommand(jTabbedPane3, this);
        HREF = new HREFcommand(jTabbedPane3, list, this);
        View = new javax.swing.JMenu();
        Links = new LinksCommand(list);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenu1.setText("File");

        items.add(New);
        jMenu1.add(New);

        items.add(Open);
        jMenu1.add(Open);

        items.add(Save);
        jMenu1.add(Save);

        items.add(SaveAs);
        jMenu1.add(SaveAs);

        items.add(Close);
        jMenu1.add(Close);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        items.add(Copy);
        jMenu2.add(Copy);

        items.add(Cut);
        jMenu2.add(Cut);

        items.add(Paste);
        jMenu2.add(Paste);

        items.add(SelectAll);
        jMenu2.add(SelectAll);

        items.add(Indent);
        jMenu2.add(Indent);

        items.add(Undo);
        jMenu2.add(Undo);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("HTML");

        items.add(Bold);
        Shortcuts cuts = new Shortcuts();
        jMenu3.add(Bold);
        Bold.setAccelerator(KeyStroke.getKeyStroke(cuts.keys[0], cuts.input[0]));

        items.add(Italic);
        jMenu3.add(Italic);

        items.add(H1);
        jMenu3.add(H1);

        items.add(H2);
        jMenu3.add(H2);

        items.add(H3);
        jMenu3.add(H3);

        items.add(H4);
        jMenu3.add(H4);

        items.add(H5);
        jMenu3.add(H5);

        items.add(H6);
        jMenu3.add(H6);

        items.add(OrderedList);
        jMenu3.add(OrderedList);

        items.add(UnOrderedList);
        jMenu3.add(UnOrderedList);

        items.add(DefinitionList);
        jMenu3.add(DefinitionList);

        items.add(Table);
        jMenu3.add(Table);

        items.add(IMG);
        jMenu3.add(IMG);

        items.add(HREF);
        jMenu3.add(HREF);

        jMenuBar1.add(jMenu3);

        View.setText("View");
        View.add(Links);
        items.add(Links);
        addActionAndName(items, menuNames);

        jMenuBar1.add(View);

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
    
    //Method for when an events is called
    //The command is then executed
    private void executedObject(ActionEvent evt){
        JEditorPane text = (JEditorPane) jTabbedPane3.getSelectedComponent();
        ((HTMLBuffer) jTabbedPane3.getSelectedComponent().getKeyListeners()[1]).update(text.getText());
        Command command = (Command) evt.getSource();
        control.setCommand(command);
        control.pressButton();
    }
    
    //Attaches the names and an actionlistener to each of the menu items
    private void addActionAndName(ArrayList<JMenuItem> items,String names[]) {
        for (int i = 0; i < items.size(); i++) {
            items.get(i).setText(names[i]);
            items.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    executedObject(evt);
                }
            });
        }
        
        addShortCuts(items);
    }
    
    //Adds the Keyshortcuts to the menuitems
    private void addShortCuts(ArrayList<JMenuItem> items){
        Shortcuts cuts = new Shortcuts();
        for(int i = 0; i < items.size(); i++){
            items.get(i).setAccelerator(KeyStroke.getKeyStroke(cuts.keys[i], cuts.input[i]));
        }
    }
    
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
    private javax.swing.JMenuItem Bold;
    private javax.swing.JMenuItem Close;
    private javax.swing.JMenuItem Copy;
    private javax.swing.JMenuItem Cut;
    private javax.swing.JMenuItem DefinitionList;
    private javax.swing.JMenuItem H1;
    private javax.swing.JMenuItem H2;
    private javax.swing.JMenuItem H3;
    private javax.swing.JMenuItem H4;
    private javax.swing.JMenuItem H5;
    private javax.swing.JMenuItem H6;
    private javax.swing.JMenuItem HREF;
    private javax.swing.JMenuItem IMG;
    private javax.swing.JMenuItem Indent;
    private javax.swing.JMenuItem Italic;
    private javax.swing.JMenuItem Links;
    private javax.swing.JMenuItem New;
    private javax.swing.JMenuItem Open;
    private javax.swing.JMenuItem OrderedList;
    private javax.swing.JMenuItem Paste;
    private javax.swing.JMenuItem Save;
    private javax.swing.JMenuItem SaveAs;
    private javax.swing.JMenuItem SelectAll;
    private javax.swing.JMenuItem Table;
    private javax.swing.JMenuItem UnOrderedList;
    private javax.swing.JMenuItem Undo;
    private javax.swing.JMenu View;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    // End of variables declaration//GEN-END:variables

    private CommandControl control; 
    private LinksList list; 

}
