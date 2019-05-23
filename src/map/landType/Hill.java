package map.landType;

//TODO: add proper javadoc.

import map.Tile;

/**
 *
 * @author nicolas
 */
public class Hill extends Tile{
  
  private final String landType = "Hill";
  
  public Hill(){
    super();
  }
  
  @Override
  public String getLandType(){
    return this.landType;
  }
}
