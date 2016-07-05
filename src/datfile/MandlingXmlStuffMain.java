/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datfile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author miracle1
 */
public class MandlingXmlStuffMain {
    
    //private String key;
    
    public static void main(String[] args) throws IOException {
        HandlingXmlStuff handlingXmlStuf = new HandlingXmlStuff();
        handlingXmlStuf.parseDocument();
        System.out.println("----values inside Authentication tag-----");
        Map<String, String> Authentication = handlingXmlStuf.getAuthentication();
        for (String key : Authentication.keySet()) {
            System.out.println("Authentication for loop");
            System.out.println(key + ":" + Authentication.get(key) + ":" + key);
        }
        System.out.println("----values inside LtlLoadMessage tag-----");
        Map<String, String> LtlLoadMessage = handlingXmlStuf.getLtlLoadMessage();
        for (String key : LtlLoadMessage.keySet()) {
            System.out.println("LtlLoadMessage for loop");
            System.out.println(key + ":" + LtlLoadMessage.get(key) + ":" + key);
        }

        List<Map<String, String>> Material = handlingXmlStuf.getMaterial();
        
        for (Map<String, String> map : Material) {
            System.out.println("\n----each set of Material-----start");
            for (String key : map.keySet()) {
                System.out.println("Material for loop");
                System.out.println(key + ":" + map.get(key) + ":" + key);
            }
            System.out.println("----each set of Material-----end");
        }
        
        List<Map<String, String>> Address = handlingXmlStuf.getAddress();
        
        for (Map<String, String> map : Address) {
            System.out.println("\n----each set of Address-----start");
            for (String key : map.keySet()) {
                System.out.println("Address for loop");
                System.out.println(key + ":" + map.get(key) + ":" + key);
            }
            System.out.println("----each set of Address-----end");
        }
    }
}

