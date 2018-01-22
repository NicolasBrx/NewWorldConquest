package map;

/**
 * This class is the software representation of the game area, the map where
 * the units are then set and used.
 * 
 * @author Nicolas Brax
 */
public class Map {
  
  /**
   * 
   */
  public enum geometricForm{HEXAGONAL,PAVEMENT};
  
  /**
   * 
   */
  private final geometricForm tileForms;
  
  /**
   * always a square
   */
  private Tile[][] theMap;
  
  /**
   * 
   */
  public Map(){
    theMap = new Tile[10][10];
    tileForms = geometricForm.PAVEMENT;
  }
  
  /**
   * 
   * @param xMax
   * @param yMax 
   */
  public Map(int xMax, int yMax){
    theMap = new Tile[xMax][yMax];
    tileForms = geometricForm.PAVEMENT;
  }
  
  /**
   * 
   * @param x
   * @param y
   * @return 
   */
  public Tile getTile(int x, int y){
    return theMap[x][y];
  }
  
  /**
   * Depends on the geometrical form wanted...
   * @param x
   * @param y
   * @return 
   */
  public Tile[] getNeighbours(int x, int y){
    return null;
  }
  
  public geometricForm getGeometricForm(){
    return this.tileForms;
  }
  // logical representation
  
  // hex grid:
  // one cell is surrounded by 6 other
  // one cell is given a land type
  
  // map is made of biome generation => related tiles are set more or less close to each other
  
  
  /*
  
  
  How to store the map:
  - matrix?
  - hashmap?
  - logical? => graph?
  
  */
}
