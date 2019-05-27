package units.seaunits;

import java.util.ArrayList;
import java.util.HashMap;
import tools.Coordinates;
import tools.WCException;

/**
 * This class defines the specific method of a Carrier unit.
 * It herits from GroundUnit, an abstract class for every ground unit. It mainly
 * overrides the methods used to compute and give the different scores used
 * by the unit (attack, defense, vision and movement). It also specified the 
 * benefits of the gain of a new level by the unit.
 * 
 * @author Nicolas Brax
 */
public class Carrier extends SeaUnit{
  
  /****************************************************************************/
  /** Constant Attributes                                                    **/
  /****************************************************************************/
  
  /**
   * The generic and constant name of the unit. This is also used to load the 
   * several scores of the unit from the file data/base_unit.xml.
   */
  private final String GENERIC_NAME = "Carrier";
  
  
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
  public Carrier() throws WCException{
    super(0,new Coordinates(0,0),null);
    createUnit(this.GENERIC_NAME);
    this.name = this.GENERIC_NAME;
  }
  
  /**
   * Build a new Carrier unit.
   * @param team    the player team to which the unit belong.
   * @param nb      the number of units of the same type already created in this team.
   * @param x       the X coordinate on which the unit is created.
   * @param y       the Y coordinate on which the unit is created.
   * @param harbour the identificator of the base camp of the unit.
   */
  public Carrier(int team,int nb, int x, int y,String harbour) throws WCException{
    super(team,new Coordinates(x,y),harbour);
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
   * As a Carrier unit, it is computed as follow:
   * ---
   * @return the attack score of the unit, a Combat Plane.
   */
  @Override
  public int getAttackScore(){
    return this.attributes.getAttack();
  }
  
  /**
   * Give the defense score of the unit.
   * As a Carrier unit, it is computed as follow:
   * ---
   * @return the defense score of the unit, a Combat Plane.
   */
  @Override
  public int getDefenseScore(){
    return this.attributes.getDefense();
  }
  
  /**
   * Give the movement score of the unit.
   * As a Carrier unit, it is computed as follow:
   * ---
   * @return the movement score of the unit, a Combat Plane.
   */
  @Override
  public int getMovementScore(){
    return this.attributes.getMovement();
  }
  
  /**
   * Give the vision score of the unit.
   * As a Carrier unit, it is computed as follow:
   * ---
   * @return the vision score of the unit, a Combat Plane.
   */
  @Override
  public int getVisionScore(){
    return this.attributes.getVision();
  }
  
  /**
   * The unit has acquired enough experience to level up and be stronger. As it
   * is a Carrier unit, it consists in:
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
  
  /**
   * 
   * @return 
   */
  @Override
  public Coordinates playAI(){
    // check AI activation?
    // perception
    // decision
    // action
    return null;
  }
  
  @Override
  protected Coordinates decision(HashMap<String,ArrayList<Coordinates>> seen){
    Coordinates objective = new Coordinates(-1,-1,-1);
    System.out.println("I see " + seen.get("locations").size() + " special place and "
                      + seen.get("enemies").size() + " enemies and " 
                      + seen.get("allies").size() + " allies.");
    return action(objective);
  }
  
  @Override
  protected Coordinates action(Coordinates objective){
    // go to coordinates and attack or defend according to what's there, if there is
    return null;
  }
}
