/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se362project1;

/**
 *
 * @author Randy
 */
public class MTag {
    private boolean open = true;
    private String tag = "";
    
    MTag(String t,boolean o){
        open = o;
        tag = t;
    }
    
    MTag(String t){
        tag = t;
    }
    
    public boolean isOpen(){
        return open;
    }
    
    public String getTag(){
        return tag;
    }
}
