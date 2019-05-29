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
  protected ArrayList<Unit> unitList;
  protected ArrayList<Coordinates> locationList;
  protected boolean isAI;
  
  public Player(){
    this.playerId = -1;
    this.pseudonyme = "none";
    this.playerTeam = -1;
    this.unitList = new ArrayList<>();
    this.locationList = new ArrayList<>();
    this.isAI = false;
  }
  
  public Player(int playerId, String pseudo, int team){
    this.playerId = playerId;
    this.pseudonyme = pseudo;
    this.playerTeam = team;
    unitList = new ArrayList<>();
    locationList = new ArrayList<>();
    this.isAI = false;
  }
  
  public void addUnit(Unit unit){
    unitList.add(unit);
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
  public ArrayList<Coordinates> getLocations(){
    return this.locationList;
  }

  public ArrayList<Unit> getUnitList(){
    return unitList;
  }

  public void setUnitList(ArrayList<Unit> unitList){
    this.unitList = unitList;
  }

  public ArrayList<Coordinates> getLocationList(){
    return locationList;
  }

  public void setLocationList(ArrayList<Coordinates> locationList){
    this.locationList = locationList;
  }

  public boolean isIsAI(){
    return isAI;
  }

  public void setIsAI(boolean isAI){
    this.isAI = isAI;
  }
  
}
