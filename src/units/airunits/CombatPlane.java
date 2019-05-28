package units.airunits;

import java.util.ArrayList;
import java.util.HashMap;
import map.Map;
import tools.Coordinates;
import tools.WCException;

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
   * several scores of the unit from the file data/base_units.xml.
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
  public CombatPlane() throws WCException{
    super(0,new Coordinates(0,0),null,null);
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
   * @param gameMap
   * @throws tools.WCException
   */
  public CombatPlane(int team,int nb, int x, int y, String camp, Map gameMap) throws WCException{
    super(team,new Coordinates(x,y),camp, gameMap);
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
    return this.attributes.getAttack();
  }
  
  /**
   * Give the defense score of the unit.
   * As a Combat Plane, it is computed as follow:
   * ---
   * @return the defense score of the unit, a Combat Plane.
   */
  @Override
  public int getDefenseScore(){
    return this.attributes.getDefense();
  }
  
  /**
   * Give the movement score of the unit.
   * As a Combat Plane, it is computed as follow:
   * ---
   * @return the movement score of the unit, a Combat Plane.
   */
  @Override
  public int getMovementScore(){
    return this.attributes.getMovement();
  }
  
  /**
   * Give the vision score of the unit.
   * As a Combat Plane, it is computed as follow:
   * ---
   * @return the vision score of the unit, a Combat Plane.
   */
  @Override
  public int getVisionScore(){
    return this.attributes.getVision();
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
    this.attributes.setMaxAttack(this.attributes.getMaxAttack() + this.level);
    this.attributes.setMaxDefense(this.attributes.getMaxDefense() + this.level);
    this.attributes.setMaxMovement(this.attributes.getMaxMovement() + this.level);
    this.attributes.setMaxVision(this.attributes.getMaxVision() + this.level);
    resetAll();
  }
  
  @Override
  public String toString(){
    String toReturn;
    toReturn = "Combat Plane: " + this.attributes.getAttack() + " - "
             + this.coordinates.X + " - "
             + this.coordinates.Y + " - "
             + this.attributes.getDefense() + " - "
             + this.attributes.getMovement() + " - "
             + this.attributes.getVision() + " - "
             + this.team;
    return toReturn;
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
    return perception();
  }
  
  
  
  /**
   * 
   * // decide what to do according to the surroundings
    // mix surroundings with self state
    // decide a couse of action according to these factors + will of things to do
    
    // count the allies, ennemies and locations in view
    // count the ones that are possible to reach (ennemies and locations)
    // see if allies can help or finish the job if I loose
    // more allies than ennemies ? am I alone ?
    
    // decide to take down an ennemy or take over a location
    // priority on location
    // table of priority of the ennemy in sight against me
   * 
   * @param seen
   * @return 
   */
  @Override
  protected Coordinates decision(HashMap<String,ArrayList<Coordinates>> seen){
    Coordinates objective = new Coordinates(-1,-1,-1);
    System.out.println("I see " + seen.get("locations").size() + " special place and "
                      + seen.get("enemies").size() + " enemies and " 
                      + seen.get("allies").size() + " allies.");
    
    // sort enemies by distance and allies around and my abilities
    // sort allies by distance and enemies around and my abilitie
    // sort locations by interest and distance and my abilities
    
    // enemy at the most interesting locations?
    
    // decide:
    //  - compute attack score according to enemy and ally number
    //  - location score according to distance and enemy presence
    //  - combine... and decide !
    
    return action(objective);
  }
  
  /**
   * 
   * @param objective
   * @return 
   */
  @Override
  protected Coordinates action(Coordinates objective){
    // go to coordinates and attack or defend according to what's there, if there is
    return null;
  }
}
