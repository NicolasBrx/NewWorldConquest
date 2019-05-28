package map.landType;

//TODO: add proper javadoc.

import map.Tile;
import tools.WCException;

/**
 *
 * @author nicolas
 */
public class Mountain extends Tile{
  
  private final String landType = "Mountain";
  
  public Mountain() throws WCException{
    super();
    createLandType(landType);
  }
  
  @Override
  public String getLandType(){
    return this.landType;
  }
}
