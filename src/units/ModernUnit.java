package units;

import java.util.ArrayList;
import tools.Coordinates;
import tools.XmlTool;

/**
 * The high level class for all modern unit in the game. It allows the management
 * of each unit in the same way. It must implements and respect UnitInterface
 * to ensure consistancy within the game.
 * 
 * @author Nicolas Brax
 */
public abstract class ModernUnit implements UnitInterface{
  
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
   * The max attack score that can be reached by the unit.
   */
  protected int maxAttack;
  
  /**
   * The current attack score of the unit when against another unit.
   */
  protected int attack;
  
  /**
   * The max defense score that can be reached by the unit.
   */
  protected int maxDefense;
  
  /**
   * The current defense score of the unit when against another unit.
   */
  protected int defense;
  
  /**
   * The max movement score that can be reached by the unit.
   */
  protected int maxMovement;
  
  /**
   * The current attack score of the unit when against another unit.
   */
  protected int movement;
  
  /**
   * The max attack score that can be reached by the unit.
   */
  protected int maxVision;
  
  /**
   * The current attack score of the unit when against another unit.
   */
  protected int vision;
  
  
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
   * @param team the team number of the player creating the unit.
   * @param coord the coordinates where to build the team.
   */
  public ModernUnit(int team, Coordinates coord){
    this.id = "";
    this.team = team;
    this.coordinates.receive(coord);
    this.level = 0;
  }
  
  /**
   * Update the unit according to its generic name and as set in data/base_unit.xml.
   * This method must not be overrided and only called into the child constructor.
   * It is a Constructor Extension, nothing more.
   * @param genericName the name of the unit as it can be retrieve in the
   *                    base unit file.
   */
  protected void createUnit(String genericName){
    XmlTool loader = new XmlTool();
    ArrayList<Integer> unit = loader.loadUnit(genericName);
    this.maxAttack = unit.get(0);
    this.maxDefense = unit.get(1);
    this.maxMovement = unit.get(2);
    this.maxVision = unit.get(3);
    
    this.attack = this.maxAttack;
    this.defense = this.maxDefense;
    this.movement = this.maxMovement;
    this.movement = this.maxVision;
  }
  
  
  /****************************************************************************/
  /** Constructor Methods                                                    **/
  /****************************************************************************/
  
  /**
   * 
   * @param team 
   */
  public void setTeam(int team){
    this.team = team;
  }
  
  /**
   * 
   * @param newCoordinates 
   */
  public void setCoordinates(Coordinates newCoordinates){
    this.coordinates.receive(newCoordinates);
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
   * @param attackerDV the damage value scored by the opponent.
   * @return 1 if the unit resist the attack and -1 if the unit is eliminated.
   */
  @Override
  public int damage(int attackerDV){
    return 0;
  }
  
  /**
   * Update the coordinates of the unit after a movement.
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
    this.attack = this.maxAttack;
  }
  
  /**
   * Reset the defense score of the unit to its max level.
   */
  public void resetDefense(){
    this.defense = this.maxDefense;
  }
  
  /**
   * Reset the movement score of the unit to its max level.
   */
  public void resetMovement(){
    this.movement = this.maxMovement;
  }
  
  /**
   * Reset the vision score of the unit to its max level.
   */
  public void resetVision(){
    this.vision = this.maxVision;
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
