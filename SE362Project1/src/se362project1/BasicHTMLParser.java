/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package se362project1;

import org.w3c.tidy.*;

/**
 *
 * @author Randy Goodman
 */
public class BasicHTMLParser implements FormatCheck {
    Tidy tidy = new Tidy();

    @Override
    public boolean Check(HTMLBuffer x) {
        tidy.setXHTML(true);
        
        
        
        return false;
    }
    
}
