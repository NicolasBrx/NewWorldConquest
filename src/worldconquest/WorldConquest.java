package worldconquest;

import java.util.ArrayList;
import map.Map;
import places.Harbour;
import places.Place;
import player.Player;
import units.ModernUnit;
import units.airunits.CombatPlane;

/**
 *
 * @author Nicolas Brax
 */
public class WorldConquest {

  private Map gameMap;
  private ArrayList<Player> players;
  
  public static void main(String[] args) {
    createPlayers(2);
    createMap("world");
    decideStartingLocation();
  }
  
  public static void createPlayers(int nbPlayers){
    
  }
  
  public static void createMap(String mapType){
    
  }
  
  public static void decideStartingLocation(){
    
  }
  
  public void test(){
    ModernUnit cp = new CombatPlane(1,1,0,0,"toto");
    System.out.println(cp.toString());
    Place pl = new Harbour();
    System.out.println(pl.toString());
  }
  
}
