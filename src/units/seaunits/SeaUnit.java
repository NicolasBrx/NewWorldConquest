package units.seaunits;

import tools.Coordinates;
import units.ModernUnit;

/**
 * This is an abstract class for every marine unit. It is used to manage the unit
 * type as well as the main base of the unit, its harbour.
 * 
 * It herits from ModernUnit, the high level class for every unit in the game.
 * 
 * Sea units are the only one that can move in sea tiles. Their unique ability
 * is to be able to shoot from ashore and at certain range, allowing
 * supporting fire.
 * 
 * Of course, aicraft can move over tile too.
 * 
 * @author Nicolas Brax
 */
public abstract class SeaUnit extends ModernUnit{
  
  
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
  protected String harbourId; 

  
  /****************************************************************************/
  /** Constructor Methods                                                    **/
  /****************************************************************************/
  
  /**
   * Default Constructor
   * The Unit is built with no base camp.
   */
  public SeaUnit(){
    super(0,new Coordinates(0,0),null);
    this.harbourId = null;
  }
  
  /**
   * Build a new Air Unit.
   * @param team the player team to which the unit belong.
   * @param coord the coordinates where the unit is created
   * @param camp the identificator of the base camp of the unit.
   */
  public SeaUnit(int team, Coordinates coord, String harbour){
    super(0,coord,null);
    this.harbourId = harbour;
  }

  
  /****************************************************************************/
  /** Getter and Setter Methods                                              **/
  /****************************************************************************/

  /**
   * Give the identificator of the base camp of the current unit.
   * @return the base camp id.
   */
  public String getHarbourId() {
    return harbourId;
  }

  /**
   * Set the identificator of the base camp of the current unit.
   * @param harbourId the base camp id.
   */
  public void setHarbourId(String harbourId) {
    this.harbourId = harbourId;
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
