package player;

import java.util.ArrayList;
import tools.Coordinates;
import units.ModernUnit;
import units.Unit;

/**
 *
 * @author Nicolas Brax
 */
public class Player {
  
  protected int playerId;
  protected String pseudonyme;
  protected int playerTeam;
  protected ArrayList<ModernUnit> unitList;
  protected ArrayList<Coordinates> locationList;
  
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
  
  public ArrayList<ModernUnit> getUnits(){
    return this.unitList;
  }
  public ArrayList<Coordinates> getLocations(){
    return this.locationList;
  }
}
