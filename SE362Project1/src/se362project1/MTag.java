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
    private int line;
    
    MTag(String t,int l,boolean o){
        open = o;
        tag = t;
        line = l;
    }
    
    MTag(String t,int l){
        tag = t;
        line = l;
    }
    
    public boolean isOpen(){
        return open;
    }
    
    public String getTag(){
        return tag;
    }
}
