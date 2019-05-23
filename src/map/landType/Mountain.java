package map.landType;

//TODO: add proper javadoc.

import map.Tile;

/**
 *
 * @author nicolas
 */
public class Mountain extends Tile{
  
  private final String landType = "Mountain";
  
  public Mountain(){
    super();
  }
  
  @Override
  public String getLandType(){
    return this.landType;
  }
}
