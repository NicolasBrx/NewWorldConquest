package units;

import tools.Coordinates;

/**
 *
 * @author Nicolas Brax
 */
public class Unit {
  
  private String id;
  private int team;
  private Coordinates coordinates;
  
  /**
   * 
   */
  public Unit(){
    
  }
  
  /**
   * 
   * @param team
   * @param coord 
   */
  public Unit(int team, Coordinates coord){
    this.id = "";
    this.team = team;
    this.coordinates.receive(coord);
  }
  
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
  
}
