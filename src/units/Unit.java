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
  
  public Unit(){
    
  }
  
  public Unit(int team, Coordinates coord){
    this.id = "";
    this.team = team;
    this.coordinates = coord;
  }
  
  public void setTeam(int team){
    this.team = team;
  }
  
  public void setCoordinates(int x,int y){
    this.coordinates.X = x;
    this.coordinates.Y = y;
  }
  
}
