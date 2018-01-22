package map.landType;

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
  
  public Desert(int x, int y){
    super(x,y);
    createLandType(this.landType)  ;
  }
  
  @Override
  public String getLandType(){
    return this.landType;
  }
}
