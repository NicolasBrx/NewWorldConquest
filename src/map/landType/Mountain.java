package map.landType;

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
  
  public Mountain(int x, int y){
    super(x,y);
    createLandType(this.landType)  ;
  }
  
  @Override
  public String getLandType(){
    return this.landType;
  }
}
