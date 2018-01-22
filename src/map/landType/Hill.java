package map.landType;

//TODO: add proper javadoc.

import map.Tile;
import tools.WCException;

/**
 *
 * @author nicolas
 */
public class Hill extends Tile{
  
  private final String landType = "Hill";
  
  public Hill(){
    super();
  }
  
  public Hill(int x, int y) throws WCException{
    super(x,y);
    createLandType(this.landType)  ;
  }
  
  @Override
  public String getLandType(){
    return this.landType;
  }
}
