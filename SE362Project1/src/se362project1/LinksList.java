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
/**
 *
 * @author grantstacey
 */
public class LinksList implements ActionListener {
    
    private ArrayList<ArrayList> URLlist = new ArrayList<ArrayList>();
    private JList list = new JList();
    private JButton button;
    private JTabbedPane pane;
    
    public LinksList(JTabbedPane pane){
        JFrame f = new JFrame("Links List");
        JPanel panel = new JPanel();
        button = new JButton("Update");
        this.pane = pane;
        f.setSize(400, 150);
        Container content = f.getContentPane();
        panel.setLayout(new BorderLayout());
        panel.add(list, BorderLayout.CENTER);
        panel.add(button, BorderLayout.PAGE_START);
        f.add(panel);
        button.addActionListener(this);
        f.setVisible(true);
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
        list.setListData(URLlist.get(pane.getSelectedIndex()).toArray());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
    }
}
