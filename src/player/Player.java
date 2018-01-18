package player;

import java.util.ArrayList;
import places.Place;
import units.ModernUnit;

/**
 *
 * @author Nicolas Brax
 */
public class Player {
  
  private int playerId;
  private String pseudonyme;
  private int playerTeam;
  private ArrayList<ModernUnit> unitList;
  private ArrayList<Place> locationList;
  
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
  
  public void addUnit(ModernUnit unit){
    
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
  public ArrayList<Place> getLocations(){
    return this.locationList;
  }
}
