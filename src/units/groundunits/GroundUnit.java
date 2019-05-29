package units.groundunits;

import map.Map;
import tools.Coordinates;
import units.ModernUnit;

/**
 * This is an abstract class for every ground unit. It is used to manage the unit
 * type. For ground unit, nothing is specific for now.
 * 
 * It herits from ModernUnit, the high level class for every unit in the modern 
 * game.
 * 
 * Ground units have the unique ability to capture of place of interest and
 * occupy it to defend it. They have no drawbacks except their limited 
 * movement rates.
 * 
 * @author Nicolas Brax
 */
public abstract class GroundUnit extends ModernUnit{
  
  
  /****************************************************************************/
  /** Constant Attributes                                                    **/
  /****************************************************************************/
  
  /**
   * The generic type of the unit.
   */
  protected final String UNIT_TYPE = "ground";
  
  
  /****************************************************************************/
  /** Constructor Methods                                                    **/
  /****************************************************************************/
  
  /**
   * Default Constructor
   * The Unit is built with no base camp.
   */
  public GroundUnit(){
    super(0,new Coordinates(0,0),null);
    
  }
  
  /**
   * Build a new Ground Unit.
   * @param team the player team to which the unit belong.
   * @param coord the coordinates where the unit is created
   * @param gameMap
   */
  public GroundUnit(int team, Coordinates coord, Map gameMap){
    super(team,coord,gameMap);
   
  }

  
  /****************************************************************************/
  /** Overrided methods from UnitInterface implemented in parent <Unit>      **/
  /****************************************************************************/
  
  /**
   * Give the type of the unit amongst 'air', 'ground' and 'sea'.
   * @return the type of the unit.
   */
  @Override
  public String getType(){
    return this.UNIT_TYPE;
  }
}
