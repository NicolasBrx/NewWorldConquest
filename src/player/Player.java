package player;

import java.util.ArrayList;
import locations.Location;
import units.Unit;

/**
 *
 * @author Nicolas Brax
 */
public class Player {
  
  private int playerId;
  private String pseudonyme;
  private int playerTeam;
  private ArrayList<Unit> unitList;
  private ArrayList<Location> locationList;
  
  public Player(){
    this.playerId = -1;
    this.pseudonyme = "none";
    this.playerTeam = -1;
    this.unitList = new ArrayList<>();
    this.locationList = new ArrayList<>();
  }
  
  public Player(int playerId, String pseudo, int team){
    this.playerId = playerId;
    this.pseudonyme = pseudo;
    this.playerTeam = team;
    unitList = new ArrayList<>();
    locationList = new ArrayList<>();
  }
  
  public void addUnit(Unit unit){
    
  }
  
  public int getPlayerId(){
    return this.playerId;
  }  
  public String getPseudonyme(){
    return this.pseudonyme;
  }
  public int getPlayerTeam(){
    return this.playerTeam;
  }
  
  public ArrayList<Unit> getUnits(){
    return this.unitList;
  }
  public ArrayList<Location> getLocations(){
    return this.locationList;
  }
}
