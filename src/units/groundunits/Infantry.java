package units.groundunits;

import tools.Coordinates;

/**
 * This class defines the specific method of an Infantry unit.
 * It herits from GroundUnit, an abstract class for every ground unit. It mainly
 * overrides the methods used to compute and give the different scores used
 * by the unit (attack, defense, vision and movement). It also specified the 
 * benefits of the gain of a new level by the unit.
 * 
 * @author Nicolas Brax
 */
public class Infantry extends GroundUnit{
  
  /****************************************************************************/
  /** Constant Attributes                                                    **/
  /****************************************************************************/
  
  /**
   * The generic and constant name of the unit. This is also used to load the 
   * several scores of the unit in the file data/base_unit.xml.
   */
  private final String GENERIC_NAME = "Infantry";
  
  
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
  public Infantry(){
    super(0,new Coordinates(0,0));
    createUnit(this.GENERIC_NAME);
    this.name = this.GENERIC_NAME;
  }
  
  /**
   * Build a new Infantry unit.
   * @param team the player team to which the unit belong.
   * @param nb   the number of units of the same type already created in this team.
   * @param x    the X coordinate on which the unit is created.
   * @param y    the Y coordinate on which the unit is created.
   */
  public Infantry(int team,int nb, int x, int y){
    super(team,new Coordinates(x,y));
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
   * As an Infantry unit, it is computed as follow:
   * ---
   * @return the attack score of the unit, a Combat Plane.
   */
  @Override
  public int getAttackScore(){
    return this.attributes.getAttack();
  }
  
  /**
   * Give the defense score of the unit.
   * As an Infantry unit, it is computed as follow:
   * ---
   * @return the defense score of the unit, a Combat Plane.
   */
  @Override
  public int getDefenseScore(){
    return this.attributes.getDefense();
  }
  
  /**
   * Give the movement score of the unit.
   * As an Infantry unit, it is computed as follow:
   * ---
   * @return the movement score of the unit, a Combat Plane.
   */
  @Override
  public int getMovementScore(){
    return this.attributes.getMovement();
  }
  
  /**
   * Give the vision score of the unit.
   * As an Infantry unit, it is computed as follow:
   * ---
   * @return the vision score of the unit, a Combat Plane.
   */
  @Override
  public int getVisionScore(){
    return this.attributes.getVision();
  }
  
  /**
   * The unit has acquired enough experience to level up and be stronger. As it
   * is an Infantry unit, it consists in:
   * - ---
   * - ---
   * - ---
   */
  @Override
  public void levelUp(){
    this.level = this.level + 1;
    this.attributes.setMaxAttack(this.attributes.getMaxAttack() + this.level);
    this.attributes.setMaxDefense(this.attributes.getMaxDefense() + this.level);
    this.attributes.setMaxMovement(this.attributes.getMaxMovement() + this.level);
    this.attributes.setMaxVision(this.attributes.getMaxVision() + this.level);
    resetAll();
  }
}
