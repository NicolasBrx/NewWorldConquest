package worldconquest;

import java.util.ArrayList;
import java.util.Random;
import map.Map;
import player.ArtificialPlayer;
import player.Player;
import tools.Coordinates;
import tools.WCException;
import units.groundunits.Infantry;

/**
 *
 * @author Nicolas Brax
 */
public class WorldConquest {

  private static Map gameMap;
  private static ArrayList<Player> players;
  
  public static void main(String[] args) {
    players = new ArrayList<>();
    test();
    decideStartingLocation();
  }
  
  public static void createPlayers(int nbPlayers, int nbIA){
    Random rand = new Random();
    for(int i = 0 ; i < nbIA ; ++i){
      players.add(new ArtificialPlayer(i+1,"AI"+i+1,(rand.nextInt(2) == 0 ? 1:2)));
    }
    
    for(int i = 0 ; i < (nbPlayers - nbIA) ; ++i){
      players.add(new Player(i + 1 + nbIA,"Player"+i,i + nbIA + 1));
    }
  }
  
  public static void createMap(String mapType, int tailleX, int tailleY) throws WCException{
    gameMap = new Map(tailleX, tailleY);
  }
  
  public static ArrayList<Coordinates> decideStartingLocation(){
    ArrayList<Coordinates> toReturn = new ArrayList<>();
    
    Random rand = new Random();
    int tx = gameMap.getXmax();
    int ty = gameMap.getYmax();
    for(int i = 0 ; i < players.size() ; ++i){
      int nx, ny;
      do{
        nx = rand.nextInt(tx - 1);
        ny = rand.nextInt(ty - 1);
      }while(!checkDistance(nx,ny,toReturn, tx));
      toReturn.add(new Coordinates(nx,ny));
    }
    return toReturn;
  }
  
  // toReturn.stream().allMatch(c -> (Math.abs(c.X - nx) > (tx / 2) && Math.abs(c.Y - nY) > (ty / 2)))
  private static boolean checkDistance(int x, int y, ArrayList<Coordinates> check, int size){
    boolean toReturn = true;
    if(!check.isEmpty()){
      int i = 0;
      do{
        toReturn = (Math.abs(x - check.get(i).X) > (size / 10)) && (Math.abs(y - check.get(i).Y) > (size / 10));
        ++i;
      }while(toReturn && i < check.size());
    }
    return toReturn;
  }
  
  public static void test(){
    
    try{
      int nbPlayers = 3;
      createPlayers(nbPlayers,nbPlayers);
      int tailleX = nbPlayers * 10;
      int tailleY = nbPlayers * 10;
      createMap("test_world",tailleX, tailleY);
      ArrayList<Coordinates> startingPoints = decideStartingLocation();
      for(int i = 0 ; i < startingPoints.size() ; ++i){
        players.get(i).addUnit(new Infantry(players.get(i).getPlayerTeam(),1,
                      startingPoints.get(i).X,startingPoints.get(i).Y,gameMap));
        gameMap.getTile(startingPoints.get(i).X,startingPoints.get(i).Y).
                                      addUnit(players.get(i).getUnits().get(0)); // TODO  : make it better !!
        if(players.get(i).isIsAI())
          players.get(i).getUnits().get(0).activateAI(true);
      }
      
      
      for(Player player : players){
        player.getUnits().get(0).playAI();
      }
      //System.out.println(gameMap.toString());
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
    }
    catch(WCException e){
      // TODO: find a solution...
      System.out.println("TOTO" + e);
    }
  }
  
}
