package worldconquest;

import java.util.ArrayList;
import map.Map;
import map.Tile;
import map.landType.Desert;
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
    test();
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
  
  public static void test(){
    ModernUnit cp = new CombatPlane(1,1,0,0,"toto");
    System.out.println(cp.toString());
    Place pl = new Harbour();
    System.out.println(pl.toString());
    Tile testTile = new Desert(0,0);
    testTile.addUnit(cp);
    if(testTile.hasUnit()){
      System.out.println("OK");
      System.out.println(testTile.getUnits().get(0).toString());
    }
    else{
      System.out.println("!OK");
    }
    testTile.addSpecialPlace(pl);
    if(testTile.isSpecialPlace()){
      System.out.println("OK");
      System.out.println(testTile.getSpecialPlace().toString());
    }
    else{
      System.out.println("!OK");
    }
  }
  
}
