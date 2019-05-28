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
  
  public Hill() throws WCException{
    super();
    createLandType(landType);
  }
  
  @Override
  public String getLandType(){
    return this.landType;
  }
}
