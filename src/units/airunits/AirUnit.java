package units.airunits;

import map.Map;
import tools.Coordinates;
import units.ModernUnit;

/**
 * This is an abstract class for every flying unit. It is used to manage the unit
 * type as well as the main base of the unit, its airfield.
 * 
 * It herits from ModernUnit, the high level class for every unit in the game.
 * 
 * Air units have the special ability to be able to move after a combat. On the 
 * other hand, they can not capture a city and they have to  manage their fuel
 * level before they crash.
 * 
 * Air unit are not subject to the land type movement modifier.
 * 
 * @author Nicolas Brax
 */
public abstract class AirUnit extends ModernUnit{
  
  
  /****************************************************************************/
  /** Constant Attributes                                                    **/
  /****************************************************************************/
  
  /**
   * The generic type of the unit.
   */
  protected final String UNIT_TYPE = "air";
  
  
  /****************************************************************************/
  /** Protected Attributes                                                   **/
  /****************************************************************************/
  
  /**
   * The identification of the main basecamp of the unit that also act as
   * restock and repair station. It is also the only place where a unit
   * is able to land (except for chopper).
   */
  protected String airfieldId; 

  
  /****************************************************************************/
  /** Constructor Methods                                                    **/
  /****************************************************************************/
  
  /**
   * Default Constructor
   * The Unit is built with no base camp.
   */
  public AirUnit(){
    super(0,new Coordinates(0,0),null);
    this.airfieldId = null;
  }
  
  /**
   * Build a new Air Unit.
   * @param team the player team to which the unit belong.
   * @param coord the coordinates where the unit is created
   * @param camp the identificator of the base camp of the unit.
   */
  public AirUnit(int team, Coordinates coord, String camp, Map gameMap){
    super(team,coord,gameMap);
    this.airfieldId = camp;
  }

  
  /****************************************************************************/
  /** Getter and Setter Methods                                              **/
  /****************************************************************************/

  /**
   * Give the identificator of the base camp of the current unit.
   * @return the base camp id.
   */
  public String getAirfieldId() {
    return airfieldId;
  }

  /**
   * Set the identificator of the base camp of the current unit.
   * @param airfieldId the base camp id.
   */
  public void setAirfieldId(String airfieldId) {
    this.airfieldId = airfieldId;
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
