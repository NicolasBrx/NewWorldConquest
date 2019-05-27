package units;

import engine.Strategy;
import java.util.ArrayList;
import java.util.HashMap;
import map.Map;
import tools.Coordinates;

/**
 * This pure abstract class is here for nothing except to act as a super
 * class for all possible unit classes. All other unit class MUST inherit
 * the class Unit and implements the interface UnitInterface in order to be
 * used by the game.
 * 
 * Inheritance allows all children classes to be used by the game without
 * further modifications.
 * 
 * Interface implementations allows the game to use the child class in all the 
 * needed ways.
 * 
 * @author Nicolas Brax
 */
public abstract class Unit implements UnitInterface {
  
  /****************************************************************************/
  /** Protected Attributes                                                   **/
  /****************************************************************************/
  
  /**
   * The unique identification of the unit.
   */
  protected String id;
  
  /**
   * The team to which the unit belongs to.
   */
  protected int team;
  
  /**
   * The current coordinates where to find the unit.
   */
  protected Coordinates coordinates;
  
  /**
   * The experience level of the unit, impact its attack, defense, movement
   * and vision scores.
   */
  protected int level;
  
  /**
   * The attributes of a unit as well as the max they can reach in each one
   */
  protected UnitAttributes attributes;
  
  /**
   * 
   */
  protected Map myMap;
  
  public Unit(){
    
  }
  
  public Unit(String id, int team, Coordinates coord, Map gameMap){
    this.team = team;
    this.level=0;
    coordinates = coord;
    this.myMap = gameMap;
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
  
  
  /****************************************************************************/
  /** Artificial Intelligence Methods to be overrided (MAS style)            **/
  /****************************************************************************/
  
  /**
   * 
   */
  protected boolean activatedAI;
  
  /**
   * 
   */
  protected Strategy strategyType;
  
  /**
   * 
   * @return 
   */
  protected Coordinates perception(){
    
    // perception of the surroundings
    // looks for; allies, ennemies, points of interests
    System.out.println("I have a vision range of: " + getVisionScore() + " and is in " + getCoordinates().X + ";" + getCoordinates().Y);
    HashMap<String,ArrayList<Coordinates>> seen = this.myMap.lookInRange(this.getVisionScore(), coordinates.X, coordinates.Y);
    return decision(seen);
  }
  
  /**
   * 
   * @param activation 
   */
  public void activateAI(boolean activation){
    this.activatedAI = activation;
  }
  
  public void setStratefy(Strategy strategy){
    this.strategyType = strategy;
  }
  
  protected HashMap<String,ArrayList<Coordinates>> checkSurroundings(int range){
    
    return myMap.lookInRange(range,coordinates.X,coordinates.Y);
  }
  
  /**
   * 
   * @return 
   */
  public abstract Coordinates playAI();
  
  /**
   * 
   * @param seen
   * @return 
   */
  protected abstract Coordinates decision(HashMap<String,ArrayList<Coordinates>> seen);
  
  /**
   * 
   * @param objective
   * @return 
   */
  protected abstract Coordinates action(Coordinates objective);
  
}
