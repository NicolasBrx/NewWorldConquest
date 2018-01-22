package map.landType;

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
  
  public Hill(int x, int y){
    super(x,y);
    createLandType(this.landType)  ;
  }
  
  @Override
  public String getLandType(){
    return this.landType;
  }
}
