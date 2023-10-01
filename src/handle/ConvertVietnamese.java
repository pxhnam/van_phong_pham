/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handle;

import app.frmProd;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class ConvertVietnamese {

    public String toVietnamese(byte[] bytes) {
        String str = "";
        try {
            str = new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(frmProd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;
    }
}
