/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//This class uses a 3rd party Java class called JTidy. A class for HTML syntax checking.

package se362project1;

import java.io.ByteArrayInputStream;
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
        ByteArrayInputStream bais =
            new ByteArrayInputStream(x.getText().getBytes());
        
        try{
            tidy.parseDOM(bais, null);
        }catch(Throwable e){
            return false;
        }
        return true;
    }
    
}
