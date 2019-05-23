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
      // test map creation
      Map test = new Map();
      
      // test unit creation
      ModernUnit cp = new CombatPlane(1,1,rand.nextInt(9),rand.nextInt(9),"");
      test.getTile(cp.getCoordinates().X,cp.getCoordinates().Y).addUnit(cp);
      ModernUnit cs = new TransportPlane(1,1,rand.nextInt(9),rand.nextInt(9),"");
      test.getTile(cs.getCoordinates().X,cs.getCoordinates().Y).addUnit(cs);
      
      // test map display (string style)
      System.out.println(test.toString());
    }
    catch(WCException e){
      // TODO: find a solution...
      System.out.println("TOTO" + e);
    }
  }
  
}
