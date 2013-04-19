package se362project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author christopher norman
 */
public class LinksList implements ActionListener, ListSelectionListener {
    
    private ArrayList<ArrayList> URLlist = new ArrayList<ArrayList>();
    private JList list = new JList();
    private JButton updatebutton;
    private JButton sortbutton;
    private JButton inorderbutton;
    private JTabbedPane pane;
    private JLabel label;
    public JFrame f;
    
    public LinksList(JTabbedPane pane){
        f = new JFrame("Links List");
        f.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                f.setVisible(false);
            }
        });
        JPanel panel = new JPanel();
        JPanel buttonPanel = new JPanel();
        updatebutton = new JButton("Update");
        sortbutton = new JButton("Sort");
        inorderbutton = new JButton("In Order");
        label = new JLabel("Test");
        this.pane = pane;
        panel.setLayout(new BorderLayout());
        panel.add(list, BorderLayout.CENTER);
        buttonPanel.add(updatebutton);
        buttonPanel.add(sortbutton);
        buttonPanel.add(inorderbutton);
        buttonPanel.add(label);
        panel.add(buttonPanel, BorderLayout.PAGE_START);
        f.add(panel);
        updatebutton.addActionListener(this);
        sortbutton.addActionListener(this);
        inorderbutton.addActionListener(this);
        list.addListSelectionListener(this);
        f.setSize(400, 400);
        f.setVisible(false);
    }
    
    public void displayLinksList(JTabbedPane pane) {
       list.setListData(URLlist.get(pane.getSelectedIndex()).toArray());
       this.pane = pane;
    }
    
    public void addLink(String URL, int index){
        
        try {
           URLlist.get(index);
           URLlist.get(index).add(URL);
        } catch (IndexOutOfBoundsException e) {
           ArrayList<String> URLs = new ArrayList<String>();
           URLlist.add(index,URLs); 
           URLlist.get(index).add(URL);
        }
        
    }
    
    public void update(){
        JEditorPane text = (JEditorPane)pane.getSelectedComponent();
        String HTML = text.getText();
        
        URLlist.get(pane.getSelectedIndex()).clear();
        
        for(int i = 0; i < HTML.length(); i++){
            String temp = "";
            if(HTML.charAt(i) == 'h' && HTML.charAt(i + 1) == 'r' && 
                    HTML.charAt(i + 2) == 'e' && HTML.charAt(i + 3) == 'f'){
                int s  = (i + 6);
                while(HTML.charAt(s) != '"'){
                    temp += HTML.charAt(s);
                    s++;
                    
                }
                addLink(temp, pane.getSelectedIndex());
            }
        }
        
        
        list.setListData(URLlist.get(pane.getSelectedIndex()).toArray());
    }
    
    public void countDuplicates(){
        String selected = (String) list.getSelectedValue();
        Iterator itr = URLlist.get(pane.getSelectedIndex()).iterator();
        int count = 0;
        
        while(itr.hasNext()){
            if(selected.equals(itr.next())){
                count++;
            }
        }
        
        label.setText(Integer.toString(count));
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(updatebutton)){
            update();
        }
        else if(e.getSource().equals(sortbutton)){
            ArrayList Copy = new ArrayList(URLlist.get(pane.getSelectedIndex()));
            Collections.sort(Copy);
            list.setListData(Copy.toArray());
        }
        else if(e.getSource().equals(inorderbutton)){
            list.setListData(URLlist.get(pane.getSelectedIndex()).toArray());
        }
       
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        countDuplicates();
    }
}
