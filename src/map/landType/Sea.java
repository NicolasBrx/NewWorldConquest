package map.landType;

//TODO: add proper javadoc.

import map.Tile;

/**
 *
 * @author nicolas
 */
public class Sea extends Tile{
  
  private final String landType = "Sea";
  
  public Sea(){
    super();
  }
  
  @Override
  public String getLandType(){
    return this.landType;
  }
}
