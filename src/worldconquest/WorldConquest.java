package worldconquest;

import java.util.ArrayList;
import java.util.Random;
import map.Map;
import player.Player;
import tools.WCException;
import units.ModernUnit;
import units.airunits.*;

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
    
    
    Random rand = new Random();
    try{
      Map test = new Map(20,20);
      ModernUnit cp = new CombatPlane(1,1,rand.nextInt(10),rand.nextInt(10),"");
      test.getTile(cp.getCoordinates().X,cp.getCoordinates().Y).addUnit(cp);
      ModernUnit cs = new TransportPlane(1,1,rand.nextInt(10),rand.nextInt(10),"");
      test.getTile(cs.getCoordinates().X,cs.getCoordinates().Y).addUnit(cs);
      System.out.println(test.toString());
    }
    catch(WCException e){
      // TODO: find a solution...
      System.out.println("TOTO");
    }
    
    
    
    /*
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
    */
  }
  
}
