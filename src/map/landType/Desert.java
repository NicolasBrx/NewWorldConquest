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
  
  public Desert() throws WCException{
    super();
    createLandType(landType);
  }
  
  @Override
  public String getLandType(){
    return this.landType;
  }
}
