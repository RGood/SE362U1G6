/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se362project1;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author grantstacey
 */
public class LinksList {
    
    public void displayLinksList(String[] list) {
        JFrame f = new JFrame("Links List");
        f.setSize(400, 150);
        Container content = f.getContentPane();
        content.add(new JList(list));
        f.setVisible(true);
    }
}
