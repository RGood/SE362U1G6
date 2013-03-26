/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//This class uses a 3rd party Java class called JTidy. A class for HTML syntax checking.

package se362project1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        
        try{
            tidy.parseDOM(bais, bOut);
            if(tidy.getParseWarnings()>0 || tidy.getParseErrors()>0){
                return false;
            }
        }catch(Throwable e){
            return false;
        }
        return true;
    }
    
}
