/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package datfile;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class soupXMLReading {
   public static void main(String[] args){

      try {	
         File inputFile = new File("D:/MSCVP/soap_request.dat");
         DocumentBuilderFactory dbFactory 
            = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" 
            + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("LtlLoadMessage");
         System.out.println("----------------------------");
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" 
               + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               System.out.println("CustomerName : " 
                  + eElement.getAttribute("CustomerName"));
               System.out.println("MessageType : " 
                  + eElement
                  .getElementsByTagName("MessageType")
                  .item(0)
                  .getTextContent());
               System.out.println("ShipmentNo : " 
               + eElement
                  .getElementsByTagName("ShipmentNo")
                  .item(0)
                  .getTextContent());
               System.out.println("InboundOutbound : " 
               + eElement
                  .getElementsByTagName("InboundOutbound")
                  .item(0)
                  .getTextContent());
               System.out.println("OperationType : " 
               + eElement
                  .getElementsByTagName("OperationType")
                  .item(0)
                  .getTextContent());
               System.out.println("LoadStatus : " 
               + eElement
                  .getElementsByTagName("LoadStatus")
                  .item(0)
                  .getTextContent());
               System.out.println("PayTerms : " 
               + eElement
                  .getElementsByTagName("PayTerms")
                  .item(0)
                  .getTextContent());
               System.out.println("OperationType : " 
               + eElement
                  .getElementsByTagName("GlNumber")
                  .item(0)
                  .getTextContent());
               System.out.println("Bol : " 
               + eElement
                  .getElementsByTagName("Bol")
                  .item(0)
                  .getTextContent());
               System.out.println("PoNum : " 
               + eElement
                  .getElementsByTagName("PoNum")
                  .item(0)
                  .getTextContent());
               System.out.println("OriginatingSystem : " 
               + eElement
                  .getElementsByTagName("OriginatingSystem")
                  .item(0)
                  .getTextContent());
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
