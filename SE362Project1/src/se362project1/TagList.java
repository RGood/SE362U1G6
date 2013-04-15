/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se362project1;

import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author Randy
 */
public class TagList {
    private HashMap matched = new HashMap();
    private ArrayList<String> unmatchedTag = new ArrayList<String>();
    private ArrayList<Integer> unmatchedLine = new ArrayList<Integer>();
    
    public HashMap genTagList(String htmlText){
        String[] lines = htmlText.split("\n");
        for(int i = 0;i<lines.length;i++){
            lines[i] = lines[i].trim();
        }
        for(int j = 0;j<lines.length;j++){
            if(lines[j].startsWith("</")){
                String tag = lines[j].substring(2,lines[j].indexOf(">"));
                if(unmatchedTag.contains(tag)){
                    int index = unmatchedTag.lastIndexOf(tag);
                    matched.put(unmatchedLine.get(index), j);
                    unmatchedTag.remove(index);
                    unmatchedLine.remove(index);
                }
                
            }else if(lines[j].startsWith("<")){
                int space = lines[j].indexOf(" ");
                int close = lines[j].indexOf(">");
                int index;
                if(space<close){
                    index = space;
                }else{
                    index = close;
                }
                String tag = lines[j].substring(1,index);
                unmatchedTag.add(tag);
                unmatchedLine.add(j);
            }else{
                
            }
        }
        return matched;
    }
}