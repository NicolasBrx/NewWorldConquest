package units.airunits;

import tools.Coordinates;

/**
 * This class defines the specific method of a Combat Plane.
 * It herits from AirUnit, an abstract class for every flying unit. It mainly
 * overrides the methods used to compute and give the different scores used
 * by the unit (attack, defense, vision and movement). It also specified the 
 * benefits of the gain of a new level by the unit.
 * 
 * @author Nicolas Brax
 */
public class CombatPlane extends AirUnit{
  
  /****************************************************************************/
  /** Constant Attributes                                                    **/
  /****************************************************************************/
  
  /**
   * The generic and constant name of the unit. This is also used to load the 
   * several scores of the unit in the file data/base_unit.xml.
   */
  private final String GENERIC_NAME = "Combat Plane";
  
  
  /****************************************************************************/
  /** Private Attributes                                                     **/
  /****************************************************************************/
  
  /**
   * The name of the unit. This name can be modified by the user.
   */
  private String name;
  
  
  /****************************************************************************/
  /** Constructor Methods                                                    **/
  /****************************************************************************/
  
  /**
   * Default Constructor
   * The Unit is built with the standart name and scores but negative experience
   */
  public CombatPlane(){
    super(0,new Coordinates(0,0),null);
    createUnit(this.GENERIC_NAME);
    this.name = this.GENERIC_NAME;
  }
  
  /**
   * Build a new Combat Plane.
   * @param team the player team to which the unit belong.
   * @param nb   the number of units of the same type already created in this team.
   * @param x    the X coordinate on which the unit is created.
   * @param y    the Y coordinate on which the unit is created.
   * @param camp the identificator of the base camp of the unit.
   */
  public CombatPlane(int team,int nb, int x, int y, String camp){
    super(team,new Coordinates(x,y),camp);
    createUnit(this.GENERIC_NAME);
    this.name = this.GENERIC_NAME + " " + (nb < 10 ? "0" : "") + nb;
  }
  
  
  /****************************************************************************/
  /** Overrided methods from UnitInterface implemented in parent <Unit>      **/
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
   * The unit has acquired enough experience to level up and be stronger. As it
   * is a Combat Plane, it consists in:
   * - ---
   * - ---
   * - ---
   */
  @Override
  public void levelUp(){
    this.level = this.level + 1;
    this.maxAttack = this.maxAttack + this.level;
    this.maxDefense = this.maxDefense + this.level;
    this.maxMovement = this.maxMovement + this.level;
    this.maxVision = this.maxVision + this.level;
    resetAll();
  }
}
