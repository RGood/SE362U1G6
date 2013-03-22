/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se362project1;

/**
 *
 * @author Randy
 */
public class HTMLBuffer {
    String buffer = "";
    
    public HTMLBuffer(){
        buffer = "";
    }
    
    public HTMLBuffer(String text){
        buffer = text;
    }
    
    public void update(String text){
        buffer = text;
    }
    
    public void appendLine(String text){
        buffer += ("\n"+text);
    }
    
    public String getText(){
        return buffer;
    }
}
