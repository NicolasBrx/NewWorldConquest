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
  /** Private Attributes                                                     **/
  /****************************************************************************/
  
  /**
   * The unique identification of the unit.
   */
  private String id;
  
  /**
   * The team to which the unit belongs to.
   */
  private int team;
  
  /**
   * The current coordinates where to find the unit.
   */
  private Coordinates coordinates;
  
  
  /****************************************************************************/
  /** Protected Attributes                                                   **/
  /****************************************************************************/
  
  /**
   * The experience level of the unit, impact its attack, defense, movement
   * and vision scores.
   */
  protected int level;
  
  /**
   * The attributes of a unit as well as the max they can reach in each one
   */
  protected UnitAttributes attributes;
  
  
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
    this.id = "";
    this.team = team;
    this.coordinates = new Coordinates(coord.X,coord.Y,coord.Z);
    this.level = 0;
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
  
  
  /****************************************************************************/
  /** Getter and Setter Methods                                              **/
  /****************************************************************************/
  
  /**
   * Modify the team owning the unit. Each team is identified by a positive
   * natural number.
   * 
   * @param team the number representing the team which owns the unit.
   */
  public void setTeam(int team){
    this.team = team;
  }
  
  /**
   * Give the number identifying the team owning of the unit.
   * 
   * @return the number of the owner team.
   */
  public int getTeam(){
    return this.team;
  }
  
  /**
   * Modify the coordinates of a unit following a creation or a movement.
   * 
   * @param newCoordinates the new coordinates of the unit.
   */
  public void setCoordinates(Coordinates newCoordinates){
    this.coordinates.receive(newCoordinates);
  }
  
  /**
   * Give the current set of coordinates where the unit can be found on the map.
   * 
   * @return the current coordinates of the unit.
   */
  public Coordinates getCoordinates(){
    return this.coordinates;
  }
  
  /**
   * Modify the unique identifier String for the unit.
   * 
   * @param id the unique identifier of the unit.
   */
  public void setId(String id){
    this.id = id;
  }
  
  /**
   * Give the unique identifier String of the unit.
   * 
   * @return the unique identifier of the unit.
   */
  public String getId(){
    return this.id;
  }
  
  
  /****************************************************************************/
  /** Overrided methods from UnitInterface                                   **/
  /****************************************************************************/
  
  /**
   * Compute results of damage taken by the unit according to the damage value 
   * of the opponent. It is computed as follows:
   * ---
   * If the unit is eliminated after the attack, the function gives -1 as a
   * result and it gives 1 otherwise.
   * 
   * @param attackerDV the damage value scored by the opponent.
   * @return 1 if the unit resist the attack and -1 if the unit is eliminated.
   */
  @Override
  public int damage(int attackerDV){
    return 1;
  }
  
  /**
   * Update the coordinates of the unit after a movement.
   * 
   * @param newCoord the new coordinates.
   */
  @Override
  public void updateCoordinates(Coordinates newCoord){
    setCoordinates(newCoord);
  }
  
  
  /****************************************************************************/
  /** Tool method.... nothing to see here...                                 **/
  /****************************************************************************/
  
  /**
   * Reset the attack score of the unit to its max level. 
   */
  public void resetAttack(){
    this.attributes.setAttack(this.attributes.getMaxAttack());
  }
  
  /**
   * Reset the defense score of the unit to its max level.
   */
  public void resetDefense(){
    this.attributes.setDefense(this.attributes.getMaxDefense());
  }
  
  /**
   * Reset the movement score of the unit to its max level.
   */
  public void resetMovement(){
    this.attributes.setMovement(this.attributes.getMaxMovement());
  }
  
  /**
   * Reset the vision score of the unit to its max level.
   */
  public void resetVision(){
    this.attributes.setVision(this.attributes.getMaxVision());
  }
  
  /**
   * Reset all the scores of the unit to its max level.
   */
  public void resetAll(){
    resetAttack();
    resetDefense();
    resetMovement();
    resetVision();
  }
  
}
