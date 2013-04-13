/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se362project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author grantstacey
 */
public class LinksList implements ActionListener {
    
    private ArrayList<ArrayList> URLlist = new ArrayList<ArrayList>();
    private JList list = new JList();
    private JButton updatebutton;
    private JButton sortbutton;
    private JButton inorderbutton;
    private JTabbedPane pane;
    private int selectedList;
    
    public LinksList(JTabbedPane pane){
        JFrame f = new JFrame("Links List");
        JPanel panel = new JPanel();
        JPanel buttonPanel = new JPanel();
        updatebutton = new JButton("Update");
        sortbutton = new JButton("Sort");
        inorderbutton = new JButton("In Order");
        this.pane = pane;
        f.setSize(400, 150);
        Container content = f.getContentPane();
        panel.setLayout(new BorderLayout());
        panel.add(list, BorderLayout.CENTER);
        buttonPanel.add(updatebutton);
        buttonPanel.add(sortbutton);
        buttonPanel.add(inorderbutton);
        panel.add(buttonPanel, BorderLayout.PAGE_START);
        f.add(panel);
        updatebutton.addActionListener(this);
        sortbutton.addActionListener(this);
        inorderbutton.addActionListener(this);
        f.setVisible(true);
    }
    
    public void displayLinksList(JTabbedPane pane) {
       list.setListData(URLlist.get(pane.getSelectedIndex()).toArray());
       this.pane = pane;
    }
    
    public void addLink(String URL, int index){
       
        selectedList = index;
        
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
        list.setListData(URLlist.get(pane.getSelectedIndex()).toArray());
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
}
