package units.airunits;

import tools.Coordinates;
import units.UnitInterface;

/**
 *
 * @author Nicolas Brax
 */
public class CombatPlane extends AirUnit implements UnitInterface{
  
  private int MAX_POWER = 10;
  private int MAX_MOVEMENT = 10;
  
  private String name;
  private int power;
  private int movement;
  private int level;
  
  /**
   * 
   */
  public CombatPlane(){
    super(0,new Coordinates(0,0),null);
    this.name = "unknown";
    this.level = 0;
    this.power = 0;
    this.movement = 0;
  }
  
  /**
   * 
   * @param team
   * @param nb
   * @param x
   * @param y
   * @param camp
   */
  public CombatPlane(int team,int nb, int x, int y, String camp){
    super(team,new Coordinates(x,y),camp);
    this.name = "Combat Plane " + (nb < 10 ? "0" : "") + nb;
    this.level = 0;
    this.power = this.MAX_POWER;
    this.movement = this.MAX_MOVEMENT;
  }
  
  /**
   * 
   */
  public void resetPower(){
    this.power = this.MAX_POWER;
  }
  
  /**
   * 
   */
  public void resetMovement(){
    this.movement = this.MAX_MOVEMENT;
  }
  
  /**
   * 
   */
  public void levelUp(){
    this.level = level + 1;
    this.MAX_POWER = this.MAX_POWER + this.level;
    this.power = MAX_POWER;
    this.movement = this.MAX_MOVEMENT;
  }
  
  /***** Getter and Setter overriding Interface *****/
  /**
   * 
   * @param newName 
   */
  @Override
  public void setName(String newName){
    this.name = newName;
  }
  
  /**
   * 
   * @return 
   */
  @Override
  public String getName(){
    return this.name;
  }
  
  /**
   * 
   * @param newPower 
   */
  @Override
  public void setPower(int newPower){
    if(newPower <= this.MAX_POWER){
      this.power = newPower;  
    }
    else{
      this.power = this.MAX_POWER;
    }
  }
  
  /**
   * 
   * @return 
   */
  @Override
  public int getPower(){
    return this.power;
  }
  
  /**
   * 
   * @param newMovement 
   */
  @Override
  public void setMovement(int newMovement){
    if(newMovement <= this.MAX_MOVEMENT){
      this.movement = newMovement;  
    }
    else{
      this.movement = this.MAX_MOVEMENT;
    }
  }
  
  /**
   * 
   * @return 
   */
  @Override
  public int getMovement(){
    return this.movement;
  }
}
