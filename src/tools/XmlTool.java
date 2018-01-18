package tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.xpath.XPathExpressionException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import org.xml.sax.SAXException;

/**
 *
 * @author nicolas
 */
public class XmlTool {
  
  private final String dataPath = System.getProperty("user.dir") + "/data/";
  private final String baseUnitFile = "base_units.xml";
  
  public XmlTool(){
    // things to do ?
  }
  
  public ArrayList<Integer> loadUnit(String unitName){
    ArrayList<Integer> toReturn = new ArrayList<>();
    File inputFile = new File(dataPath + baseUnitFile);
    try{
      SAXBuilder saxBuilder = new SAXBuilder();
      Document document = saxBuilder.build(inputFile);
      Element root = document.getRootElement();
      List<Element> types = root.getChildren();
      boolean found = false;
      for(Element type: types){
        List<Element> units = type.getChildren();
        for(Element unit : units){
          if(unit.getAttributeValue("name").equalsIgnoreCase(unitName)){
            for(Element attribute : unit.getChildren()){
              toReturn.add(Integer.parseInt(attribute.getValue()));
            }//for attribute
            found = true;
          }
          if(found){break;}
        }//for units
        if(found){break;}
      }//for types
    }//try
    catch(JDOMException | IOException e){
      
    }//catch
    
    return toReturn;
  }
}
