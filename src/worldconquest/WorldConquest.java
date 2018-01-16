package worldconquest;

import java.util.ArrayList;
import map.Map;
import player.Player;
import units.airunits.CombatPlane;

/**
 *
 * @author NicolasBrax
 */
public class WorldConquest {

  private Map gameMap;
  private ArrayList<Player> players;
  
  public static void main(String[] args) {
    createPlayers(2);
    createMap("world");
    decideStartingLocation();
    
    // run a fuckin" thread!
  }
  
  public static void createPlayers(int nbPlayers){
    
  }
  
  public static void createMap(String mapType){
    
  }
  
  public static void decideStartingLocation(){
    
  }
  
}
