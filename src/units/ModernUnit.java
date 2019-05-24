package units;

import java.util.ArrayList;
import tools.Coordinates;
import tools.WCException;
import tools.XmlTool;

/**
 * The high level class for all modern unit in the game. It allows the management
 * of each unit in the same way. It must implements and respect UnitInterface
 * to ensure consistancy within the game.
 * 
 * @author Nicolas Brax
 */
public abstract class ModernUnit extends Unit{
  
  /****************************************************************************/
  /** Constructor Methods                                                    **/
  /****************************************************************************/
  
  /**
   * Default Constructor doing absolutely nothing and should not be called
   */
  public ModernUnit(){
    // Nothing to do, nothing to see here...
  }
  
  /**
   * Build a new generic Unit with a team and coordinates. The different scores
   * are then to be built by the method CreateUnit(unitName) called in the child 
   * constructor.
   * The unit is created with no experience.
   * 
   * @param team the team number of the player creating the unit.
   * @param coord the coordinates where to build the team.
   */
  public ModernUnit(int team, Coordinates coord){
    super("",team,new Coordinates(coord.X, coord.Y, coord.Z));
  }
  
  /**
   * Update the unit according to its generic name and as set in data/base_unit.xml.
   * This method must not be overrided and only called into the child constructor.
   * It is a Constructor Extension, nothing more.
   * 
   * @param genericName the name of the unit as it can be retrieved in the
   *                    base unit file.
   * @throws tools.WCException the exception is thrown whenever the xml file
   *                            cannot be read properly.
   */
  protected void createUnit(String genericName) throws WCException{
    XmlTool loader = new XmlTool();
    ArrayList<Integer> unit = loader.loadUnit(genericName);
    this.attributes = new UnitAttributes(unit.get(0),unit.get(1),unit.get(2),unit.get(3));
  } 
}
