/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miracle
 */
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import org.w3c.dom.NodeList;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.stream.StreamSource;

public class soapxmltwo {

    private static SOAPMessage message;

    public static void main(String[] args) throws IOException, SOAPException {


        try {

            File f = new File("D:/MSCVP/soap_request.dat");
            FileInputStream file_input = new FileInputStream(f);
            DataInputStream data_in = new DataInputStream(file_input);

            MessageFactory mf = MessageFactory.newInstance();
            message = mf.createMessage();
            SOAPPart soapPart = message.getSOAPPart();
            soapPart.setContent(new StreamSource(data_in));
            
            NodeList innerList1 = null;
            NodeList subinnerList = null;
            NodeList list = soapPart.getElementsByTagName("soapenv:Envelope");

            for (int i = 0; i < list.getLength(); i++) {
                NodeList innerList = list.item(i).getChildNodes();

                for (int j = 0; j < innerList.getLength(); j++) {
                    System.out.println(innerList.item(j).getNodeName());
                    if (innerList.item(j).getChildNodes().getLength() > 0) {
                        innerList1 = innerList.item(j).getChildNodes();
                        for (int n = 0; n < innerList1.getLength(); n++) {
                            System.out.println(innerList1.item(n).getNodeName());

                            if (innerList1.item(n).getChildNodes().getLength() > 0) {
                                NodeList innerList2 = innerList1.item(n).getChildNodes();
                                for (int n1 = 0; n1 < innerList2.getLength(); n1++) {
                                    System.out.println(innerList2.item(n1).getNodeName());
                                    //System.out.println(innerList2.item(n1).getTextContent());
                                    if(innerList2.item(n1).getChildNodes().getLength() > 0){
                                        NodeList innerList3 = innerList2.item(n1).getChildNodes();
                                        for(int n2 = 0; n2 < innerList3.getLength(); n2++){
                                            System.out.println(innerList3.item(n2).getNodeName());
                                            System.out.println(innerList3.item(n2).getTextContent());
                                        }
                                    }else{
                                        System.out.println(innerList2.item(n1).getTextContent());
                                    }
                                }
                            } else {
                                System.out.println(innerList1.item(n).getTextContent());
                            }
                        }
                    } 
                    else {
                        System.out.println(innerList.item(j).getTextContent());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
