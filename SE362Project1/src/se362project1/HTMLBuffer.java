/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se362project1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import javax.swing.JEditorPane;

/**
 *
 * @author Randy
 */
public class HTMLBuffer implements KeyListener{
    String buffer;
    String bufState;
    String fileName;
    JEditorPane pane;
    Stack<String> state = new Stack<String>();
    
    public HTMLBuffer(JEditorPane p){
        buffer = "";
        fileName = "";
        pane = p;
        bufState = buffer;
    }
    
    public HTMLBuffer(JEditorPane p,String name){
        buffer = "";
        fileName = name;
        pane = p;
        bufState = buffer;
    }
    
    public HTMLBuffer(String name,String text){
        buffer = text;
        fileName = name;
    }
    
    public void saveState(){
        String bufferCopy = buffer;
        state.push(bufferCopy);
        System.out.println("save: " + bufferCopy);
    }
    
    public void restoreState(){
        buffer = state.pop();
        System.out.println("undo: " + buffer);
    }
    
    public void setFileName(String name){
        fileName = name;
    }
    
    public String getFullPath(){
        File pathFile = new File(fileName);
        return pathFile.getAbsolutePath();
    }
    
    public String getFileName(){
        if(fileName.contains("\\")){
            return fileName.substring(fileName.lastIndexOf("\\")+1);
        }else if(fileName.contains("/")){
            return fileName.substring(fileName.lastIndexOf("/")+1);
        }else{
            return fileName;
        }
    }
    
    public boolean isSaved(){
        return buffer.equals(bufState);
    }
    
    public boolean save(){
        try {
            File saveFile = new File(fileName);
            //System.out.println(saveFile.getAbsolutePath());
            if(!saveFile.exists()){
                saveFile.createNewFile();
            }
            System.out.println(saveFile.getAbsolutePath());
            BufferedWriter outFile = new BufferedWriter(new FileWriter(saveFile.getAbsoluteFile()));
            outFile.write(buffer);
            outFile.close();
        } catch (IOException ex) {
            return false;
        }
        bufState = buffer;
        return true;
    }
    
    public void update(String text){
        buffer = text;
    }
    
    public void appendLine(String text){
        if (buffer.equals("")){
            buffer += (text);
        }else{
            buffer+= ("\n"+text);
        }
    }
    
    public String getText(){
        return buffer;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Save a key into the buffer
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        buffer = pane.getText();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
