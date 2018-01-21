package map;

import java.sql.Time;

/**
 * This class is the software representation of the game area, the map where
 * the units are then set and used.
 * 
 * @author Nicolas Brax
 */
public class Map {
  
  /**
   * always a square
   */
  private Tile[][] theMap;
  
  /**
   * 
   */
  public Map(){
    theMap = new Tile[10][10];
  }
  
  /**
   * 
   * @param xMax
   * @param yMax 
   */
  public Map(int xMax, int yMax){
    theMap = new Tile[xMax][yMax];
  }
  
  /**
   * 
   * @param x
   * @param y
   * @return 
   */
  public Tile getTile(int x, int y){
    return null;
  }
  
  /**
   * 
   * @param x
   * @param y
   * @return 
   */
  public Tile[] getNeighbours(int x, int y){
    return null;
  }
  // logical representation
  
  // hex grid:
  // one cell is surrounded by 6 other
  // one cell is given a land type
  
  
  
  /*
  
  
  How to store the map:
  - matrix?
  - hashmap?
  - logical? => graph?
  
  */
}
