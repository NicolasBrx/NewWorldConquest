package lands;

import tools.Coordinates;

/**
 *
 * @author nicolas
 */
public class Tile {
  private final Coordinates tileCoord;
  
  public Tile(){
    tileCoord = new Coordinates(0,0);
  }
  
  public Tile(int x,int y){
    tileCoord = new Coordinates(x,y);
  }
}
