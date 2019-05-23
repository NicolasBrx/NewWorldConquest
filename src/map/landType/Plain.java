package map.landType;

//TODO: add proper javadoc.

import map.Tile;

/**
 *
 * @author nicolas
 */
public class Plain extends Tile{
  
  private final String landType = "Plain";
  
  public Plain(){
    super();
  }
  
  @Override
  public String getLandType(){
    return this.landType;
  }
}
