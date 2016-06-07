/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rain_Vision
 */
public class ToUTF8Fixer {
    
    public static String encode(String str){
        try {
            return new String(str.getBytes("ISO-8859-1"), "utf8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ToUTF8Fixer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static String decode(String str){
        try {
            return new String(str.getBytes("UTF8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ToUTF8Fixer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
