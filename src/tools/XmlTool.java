package tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Nicolas Brax
 */
public class XmlTool {
  
  private final String dataPath = System.getProperty("user.dir") + "/data/";
  private final String baseUnitFile = "base_units.xml";
  private final String basePlaceFile = "base_places.xml";
  
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
            int attack = 0, defense = 0, movement = 0, vision = 0;
            for(Element attribute : unit.getChild("attributes").getChildren()){
              switch(attribute.getAttributeValue("name")){
                case "attack":
                  attack = Integer.parseInt(attribute.getText());
                  break;
                case "defense":
                  defense = Integer.parseInt(attribute.getText());
                  break;
                case "movement":
                  movement = Integer.parseInt(attribute.getText());
                  break;
                case "vision":
                  vision = Integer.parseInt(attribute.getText());
                  break;
                default:
                  //TODO: should no be reached, throw error
                  break;
              }//switch
            }//for attribute
            Collections.addAll(toReturn, attack,defense,movement,vision);
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
  
  public ArrayList<Integer> loadPlace(String placeName){
    ArrayList<Integer> toReturn = new ArrayList<>();
    File inputFile = new File(dataPath + basePlaceFile);
    try{
      SAXBuilder saxBuilder = new SAXBuilder();
      Document document = saxBuilder.build(inputFile);
      Element root = document.getRootElement();
      List<Element> places = root.getChildren();
      boolean found = false;
      for(Element place: places){
        if(place.getAttributeValue("name").equalsIgnoreCase(placeName)){
          int attack = 0, defense = 0, movement = 0, vision = 0;
          toReturn.add(Integer.parseInt(place.getChildText("unit_capacity")));
          for(Element modifier : place.getChild("modifiers").getChildren()){
            switch(modifier.getAttributeValue("skill")){
              case "attack":
                attack = Integer.parseInt(modifier.getText());
                break;
              case "defense":
                defense = Integer.parseInt(modifier.getText());
                break;
              case "movement":
                movement = Integer.parseInt(modifier.getText());
                break;
              case "vision":
                vision = Integer.parseInt(modifier.getText());
                break;
              default:
                //TODO: should no be reached, throw error
                break;
            }//switch
          }//for modifiers
          Collections.addAll(toReturn, attack,defense,movement,vision);
          found = true;
        }// if name == placeName
        if(found){break;}
      }//for places
    }//try
    catch(JDOMException | IOException e){
    }//catch
    return toReturn;
  }
}
