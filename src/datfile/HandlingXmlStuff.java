/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datfile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author visruth
 */
public class HandlingXmlStuff extends DefaultHandler {

    private String key;
//    private Map<String, String> request = new HashMap<String, String>();
//    private Map<String, String> current_condition = new HashMap<String, String>();
//    private List<Map<String, String>> weather = new ArrayList<Map<String, String>>();
//    private Map<String, String> weatherMap;
//    private boolean requestStatus;
//    private boolean current_conditionStatus;
//    private boolean weatherStatus;
    
    private Map<String, String> Authentication = new HashMap<String, String>();
    private Map<String, String> LtlLoadMessage = new HashMap<String, String>();
    private List<Map<String, String>> Material = new ArrayList<Map<String, String>>();
    private List<Map<String, String>> Address = new ArrayList<Map<String, String>>();
    private Map<String, String> weatherMap;
    private boolean authenticationStatus;
    private boolean ltlLoadMessageStatus;
    private boolean materialStatus;
    private boolean addressStatus;

//    public Map<String, String> getCurrent_condition() {
//        return this.current_condition;
//    }
//
//    public Map<String, String> getRequest() {
//        return this.request;
//    }
//
//    public List<Map<String, String>> getWeather() {
//        return this.weather;
//    }

    
    public Map<String, String> getAuthentication() {
        return this.Authentication;
    }

    public Map<String, String> getLtlLoadMessage() {
        return this.LtlLoadMessage;
    }

    public List<Map<String, String>> getMaterial() {
        return this.Material;
    }

    public List<Map<String, String>> getAddress() {
        return this.Address;
    }
    
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        key = qName;
        if (qName.equals("Authentication")) {

            authenticationStatus = true;
        } else if (qName.equals("LtlLoadMessage")) {

            ltlLoadMessageStatus = true;
        } else if (qName.equals("Material")) {
            weatherMap = new HashMap<String, String>();
            materialStatus = true;
        }else if (qName.equals("Address")) {
            weatherMap = new HashMap<String, String>();
            addressStatus = true;
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        String value = new String(ch, start, length).trim();
        if (authenticationStatus) {
            if (!key.trim().equals("Authentication") && !key.trim().isEmpty() && !value.isEmpty()) {
                Authentication.put(key, value);
            }
        } else if (ltlLoadMessageStatus) {
            if (!key.trim().equals("LtlLoadMessage") && !key.trim().isEmpty() && !value.isEmpty()) {
                LtlLoadMessage.put(key, new String(ch, start, length).trim());
            }
        } else if (materialStatus) {
            if (!key.trim().equals("Material") && !key.trim().isEmpty() && !value.isEmpty()) {
                weatherMap.put(key, new String(ch, start, length).trim());
            }
        }else if (addressStatus) {
            if (!key.trim().equals("Address") && !key.trim().isEmpty() && !value.isEmpty()) {
                weatherMap.put(key, new String(ch, start, length).trim());
            }
    }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("Authentication")) {
            authenticationStatus = false;
        } else if (qName.equals("LtlLoadMessage")) {
            ltlLoadMessageStatus = false;
        } else if (qName.equals("Material")) {
            Material.add(weatherMap);
            materialStatus = false;
        }else if (qName.equals("Address")) {
            Address.add(weatherMap);
            addressStatus = false;
        }
    }

    public void parseDocument() {
        //get a factory
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            //get a new instance of parser
            SAXParser sp = spf.newSAXParser();
            //parse the file and also register this class for call backs
            sp.parse("D:/MSCVP/myExample.dat", this);
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    
}
