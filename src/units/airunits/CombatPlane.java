package units.airunits;

import java.util.ArrayList;
import tools.Coordinates;
import tools.XmlTool;
import units.UnitInterface;

/**
 * 
 * @author Nicolas Brax
 */
public class CombatPlane extends AirUnit implements UnitInterface{
  
  /****************************************************************************/
  /** Constant Attributes                                                    **/
  /****************************************************************************/
  
  private final String GENERIC_NAME = "Combat Plane"; // generic name of the unit
                                                      // is also used to load base unit
  
  
  /****************************************************************************/
  /** Private Attributes                                                     **/
  /****************************************************************************/
  
  private String name;        // name of the unit, can be modified by user
  private int level;          // experience level of the unit
  
  private int maxAttack;      // max power score available of the unit
  private int attack;         // attack score of the unit to attack another
  
  private int maxDefense;     // max defense score of the unit
  private int defense;        // defense score of the unit to oppose attack
  
  private int maxMovement;    // max movement score of the unit
  private int movement;       // movement ability of the unit on the map
  
  private int maxVision;      // max vision score of the unit
  private int vision;         // distance of view of the unit on the map
  
  
  /****************************************************************************/
  /** Constructor Methods                                                    **/
  /****************************************************************************/
  
  /**
   * Generic Constructor
   * The Unit is built with the standart name and scores but negative experience
   */
  public CombatPlane(){
    super(0,new Coordinates(0,0),null);
    
    this.name = this.GENERIC_NAME;
    this.level = -1;
    
    XmlTool loader = new XmlTool();
    ArrayList<Integer> unit = loader.loadUnit(this.GENERIC_NAME);
    this.maxAttack = unit.get(0);
    this.maxDefense = unit.get(1);
    this.maxMovement = unit.get(2);
    this.maxVision = unit.get(3);
    
    this.attack = this.maxAttack;
    this.defense = this.maxDefense;
    this.movement = this.maxMovement;
    this.movement = this.maxVision;
  }
  
  /**
   * Build a new Combat Plane according to scores set in base_unit.xml.
   * @param team the player team to which the unit belong.
   * @param nb   the number of units of the same type already created in this team.
   * @param x    the X coordinate on which the unit is created.
   * @param y    the Y coordinate on which the unit is created.
   * @param camp the identificator of the base camp of the unit.
   */
  public CombatPlane(int team,int nb, int x, int y, String camp){
    super(team,new Coordinates(x,y),camp);
    
    this.name = this.GENERIC_NAME + " " + (nb < 10 ? "0" : "") + nb;
    this.level = 0;
    
    XmlTool loader = new XmlTool();
    ArrayList<Integer> unit = loader.loadUnit(this.GENERIC_NAME);
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
  /** Overrided methods from UnitInterface                                   **/
  /****************************************************************************/
  
  /**
   * Modify the name of the unit.
   * @param newName The new name of the unit.
   */
  @Override
  public void setName(String newName){
    this.name = newName;
  }
  
  /**
   * Give the name of the unit.
   * @return the name of the unit.
   */
  @Override
  public String getName(){
    return this.name;
  }
  
  /**
   * Give the type of the unit, might be 'air' amongst 'air', 'ground' and 'sea'.
   * @return the type of the unit.
   */
  @Override
  public String getType(){
    return UNIT_TYPE;
  }
  
  /**
   * Give the attack score of the unit.
   * As a Combat Plane, it is computed as follow:
   * ---
   * @return the attack score of the unit, a Combat Plane.
   */
  @Override
  public int getAttackScore(){
    return this.attack;
  }
  
  /**
   * Give the defense score of the unit.
   * As a Combat Plane, it is computed as follow:
   * ---
   * @return the defense score of the unit, a Combat Plane.
   */
  @Override
  public int getDefenseScore(){
    return this.defense;
  }
  
  /**
   * Give the movement score of the unit.
   * As a Combat Plane, it is computed as follow:
   * ---
   * @return the movement score of the unit, a Combat Plane.
   */
  @Override
  public int getMovementScore(){
    return this.movement;
  }
  
  /**
   * Give the vision score of the unit.
   * As a Combat Plane, it is computed as follow:
   * ---
   * @return the vision score of the unit, a Combat Plane.
   */
  @Override
  public int getVisionScore(){
    return this.vision;
  }
  
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
  
  /**
   * The unit has acquired enough experience to level up and be stronger. As it
   * is a Combat Plane, it consists in:
   * - ---
   * - ---
   * - ---
   */
  @Override
  public void levelUp(){
    this.level = level + 1;
    
    this.maxAttack = this.maxAttack + this.level;
    this.maxDefense = this.maxDefense + this.level;
    this.maxMovement = this.maxMovement + this.level;
    this.maxVision = this.maxVision + this.level;
    
    resetAll();
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
