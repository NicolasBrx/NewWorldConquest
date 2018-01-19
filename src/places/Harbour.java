package places;

import tools.Coordinates;

/**
 *
 * @author Nicolas Brax
 */
public class Harbour extends Place {
  
  /****************************************************************************/
  /** Constant Attributes                                                    **/
  /****************************************************************************/
  
  /**
   * The generic and constant name of the place. This is also used to load the 
   * several values related to the place in the file data/base_places.xml.
   */
  private final String GENERIC_NAME = "Harbour";
  
  /**
   * 
   */
  private int SHIP_CAPACITY = 10;
 
  
  /****************************************************************************/
  /** Constructor Methods                                                    **/
  /****************************************************************************/
  
  /**
   * 
   */
  public Harbour(){
    super(new Coordinates(0,0,0));
    createPlace(GENERIC_NAME,-1);
  }
  
  /**
   * 
   * @param x
   * @param y
   * @param z 
   * @param nb 
   */
  public Harbour(int x, int y, int z, int nb){
    super(new Coordinates(x,y,z));
    createPlace(GENERIC_NAME,nb);
  }
  
  
  /****************************************************************************/
  /** Getter and Setter Methods                                              **/
  /****************************************************************************/
  
  /**
   * 
   * @return 
   */
  public String getGenericName(){
    return this.GENERIC_NAME;
  }
  
  /**
   * Give the ship capacity of the harbour. This does not count the units that
   * are disposed at this location.
   * 
   * @return the plane capacity of the airfield.
   */
  public int getShipCapacity(){
    return this.SHIP_CAPACITY;
  }
  
  @Override
  public String toString(){
    String toReturn;
    toReturn = "Harbour: " + this.scoreModifiers.getAttackModifier() + " - "
             + this.scoreModifiers.getDefenseModifier() + " - "
             + this.scoreModifiers.getMovementModifier() + " - "
             + this.scoreModifiers.getVisionModifier() + " - "
             + this.scoreModifiers.getUnitCapacity() + " - ";
    return toReturn;
  } 
}