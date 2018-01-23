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
 * This class is dedicated to the handling of several XML files in order to
 * properly run the World Conquest project.
 * 
 * These XML files are used to:
 * - set the initial parameters of a game;
 * - save a game;
 * - load a game.
 * 
 * As these files are designed to be part of the project, their names are
 * hard coded and should not be modified. With a little chance, the project
 * will give the ability to modify theses files to stick to the user preference.
 * Maybe.
 * 
 * @author Nicolas Brax
 */
public class XmlTool {
  
  /**
   * Relative to the project, the path of the folder that contains all the 
   * data files.
   */
  private final String dataPath = System.getProperty("user.dir") + "/data/";
  
  /**
   * The file containing the specific attributes of the base units of the game.
   * The XML skeleton MUST BE:
   * <base_units>
   *   <units type="unit type">
   *     <unit name="unit name">
   *       <attributes>
   *         <attribute name="attack">int attack value</attribute>
   *         <attribute name="defense">int defense value</attribute>
   *         <attribute name="movement">int movement value</attribute>
   *         <attribute name="vision">int vision value</attribute>
   *       </attributes>
        </unit>
   *   </units>
   * </base_units>
   */
  private final String baseUnitFile = "base_units.xml";
  
  /**
   * The file containing the specific modifiers of the base places of the game.
   * The XML skeleton MUST BE:
   * <base_places>
   *   <place name="place name">
   *     <unit_capacity>int unit capacity</unit_capacity>
   *     <modifiers>
   *       <modifier skill="modified skill">int modifier value</modifier>
   *     </modifiers>
   *   </place>
   * </base_places>
   */
  private final String basePlaceFile = "base_places.xml";
  
  /**
   * The file containing the specific modifiers of the base land of the game.
   * The XML skeleton MUST BE:
   * <lands>
   *   <land name="place name">
   *     <modifiers>
   *       <modifier skill="modified skill">int modifier value</modifier>
   *     </modifiers>
   *   </land>
   * </lands>
   */
  private final String baseLandFile = "base_lands.xml";
  
  
  /****************************************************************************/
  /** Constructor Methods                                                    **/
  /****************************************************************************/
  
  /**
   * The Default Constructor that does nothing.
   */
  public XmlTool(){
    // things to do ?
  }
  
  
  /****************************************************************************/
  /** Tool Methods                                                           **/
  /****************************************************************************/
  
  /**
   * Load the base parameters of a unit according to the name specified.
   * 
   * @param unitName The name of the unit we want the parameters.
   * @return An ArrayList containing the parameters of the unit in this order:
   *          attack - defense - movement - vision
   * @throws WCException An exception when the unit is not in the file.
   */
  public ArrayList<Integer> loadUnit(String unitName) throws WCException{
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
                  throw new WCException("Unit can't be loaded, it might not exists in the file data/base_units.xml");
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
  
  /**
   * Load the base modifiers of a place according to the name specified.
   * 
   * @param placeName The name of the place we want the modifiers.
   * @return An ArrayList containing the modifiers of the place in this order:
   *          attack - defense - movement - vision
   * @throws WCException An exception when the place is not in the file.
   */
  public ArrayList<Integer> loadPlace(String placeName) throws WCException{
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
                throw new WCException("Place can't be loaded, it might not exists in the file data/base_units.xml");
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
  
  /**
   * Load the base modifiers of a landfield according to the name specified.
   * 
   * @param landName The name of the land we want the modifiers.
   * @return An ArrayList containing the modifiers of the land in this order:
   *          movement - vision
   * @throws WCException An exception when the land is not in the file.
   */
  public ArrayList<Integer> loadLand(String landName) throws WCException{
    ArrayList<Integer> toReturn = new ArrayList<>();
    File inputFile = new File(dataPath + baseLandFile);
    try{
      SAXBuilder saxBuilder = new SAXBuilder();
      Document document = saxBuilder.build(inputFile);
      Element root = document.getRootElement();
      List<Element> lands = root.getChildren();
      boolean found = false;
      for(Element land: lands){
        if(land.getAttributeValue("name").equalsIgnoreCase(landName)){
          int movement = 0, vision = 0;
          for(Element modifier : land.getChild("modifiers").getChildren()){
            switch(modifier.getAttributeValue("skill")){
              case "movement":
                movement = Integer.parseInt(modifier.getText());
                break;
              case "vision":
                vision = Integer.parseInt(modifier.getText());
                break;
              default:
                throw new WCException("Land can't be loaded, it might not exists in the file data/base_units.xml");
            }//switch
          }//for modifiers
          Collections.addAll(toReturn, movement,vision);
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
