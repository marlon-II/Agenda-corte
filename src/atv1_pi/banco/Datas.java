/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atv1_pi.banco;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author marlon
 */
public class Datas {
    public static Date ConverterSQL (String dataantiga) throws ParseException{
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date datanova = formatar.parse(dataantiga);
        
        java.sql.Date datasql = new java.sql.Date(datanova.getTime());
      
        return datasql;
    }
    
     public static String ConverteString (Date dataantiga){
        String datanova;
        
        datanova = String.valueOf(dataantiga);
        
        return datanova;
    }
}
