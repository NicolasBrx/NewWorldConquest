package map.landType;

//TODO: add proper javadoc.

import map.Tile;
import tools.WCException;

/**
 *
 * @author nicolas
 */
public class Plain extends Tile{
  
  private final String landType = "Plain";
  
  public Plain() throws WCException{
    super();
    createLandType(landType);
  }
  
  @Override
  public String getLandType(){
    return this.landType;
  }
}
