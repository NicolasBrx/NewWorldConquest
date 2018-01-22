package map.landType;

//TODO: add proper javadoc.

import map.Tile;
import tools.WCException;

/**
 *
 * @author nicolas
 */
public class Desert extends Tile{
  
  private final String landType = "Desert";
  
  public Desert(){
    super();
  }
  
  public Desert(int x, int y) throws WCException{
    super(x,y);
    createLandType(this.landType)  ;
  }
  
  @Override
  public String getLandType(){
    return this.landType;
  }
}
