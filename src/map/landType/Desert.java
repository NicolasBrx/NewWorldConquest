package map.landType;

//TODO: add proper javadoc.

import map.Tile;

/**
 *
 * @author nicolas
 */
public class Desert extends Tile{
  
  private final String landType = "Desert";
  
  public Desert(){
    super();
  }
  
  @Override
  public String getLandType(){
    return this.landType;
  }
}
