package worldconquest;

import java.util.ArrayList;
import java.util.Random;
import map.Map;
import player.Player;
import tools.WCException;
import units.Unit;
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
    
    Random rand = new Random();
    try{
      // test map creation
      int tailleX = 10;
      int tailleY = 10;
      Map test_map = new Map(tailleX,tailleY);
      
      Unit test_cp = new CombatPlane(1,1,rand.nextInt(tailleX - 1),rand.nextInt(tailleY - 1),"",test_map);
      test_map.getTile(test_cp.getCoordinates().X,test_cp.getCoordinates().Y).addUnit(test_cp);
      test_cp.activateAI(true);
      
      Unit test_cp_ally = new CombatPlane(1,2,rand.nextInt(tailleX - 1),rand.nextInt(tailleY - 1),"",test_map);
      test_map.getTile(test_cp_ally.getCoordinates().X,test_cp_ally.getCoordinates().Y).addUnit(test_cp_ally);
      //System.out.println(test_cp_ally.toString());
      
      Unit test_cp_enemy  = new CombatPlane(2,1,rand.nextInt(tailleX - 1),rand.nextInt(tailleY - 1),"",test_map);
      test_map.getTile(test_cp_enemy.getCoordinates().X,test_cp_enemy.getCoordinates().Y).addUnit(test_cp_enemy);
      //System.out.println(test_cp_enemy.toString());
      
      test_cp.playAI();
      //System.out.println(test_cp.toString()); 
     
      /*
      Unit test_cp_enemy1  = new CombatPlane(2,1,rand.nextInt(tailleX - 1),rand.nextInt(tailleY - 1),"",test_map);
      test_map.getTile(test_cp_enemy1.getCoordinates().X,test_cp.getCoordinates().Y).addUnit(test_cp_enemy1);
      System.out.println(test_cp_enemy1.toString());
      Unit test_cp_enemy2  = new CombatPlane(2,1,rand.nextInt(tailleX - 1),rand.nextInt(tailleY - 1),"",test_map);
      test_map.getTile(test_cp_enemy2.getCoordinates().X,test_cp.getCoordinates().Y).addUnit(test_cp_enemy2);
      System.out.println(test_cp_enemy2.toString());
      Unit test_cp_enemy3  = new CombatPlane(2,1,rand.nextInt(tailleX - 1),rand.nextInt(tailleY - 1),"",test_map);
      test_map.getTile(test_cp_enemy3.getCoordinates().X,test_cp.getCoordinates().Y).addUnit(test_cp_enemy3);
      System.out.println(test_cp_enemy3.toString());
      */
      
      // test map display (string style)
      System.out.println(test_map.toString());
    }
    catch(WCException e){
      // TODO: find a solution...
      System.out.println("TOTO" + e);
    }
  }
  
}
