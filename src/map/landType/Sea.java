package map.landType;

//TODO: add proper javadoc.

import map.Tile;
import tools.WCException;

/**
 *
 * @author nicolas
 */
public class Sea extends Tile{
  
  private final String landType = "Sea";
  
  public Sea() throws WCException{
    super();
    createLandType(landType);
  }
  
  @Override
  public String getLandType(){
    return this.landType;
  }
}
