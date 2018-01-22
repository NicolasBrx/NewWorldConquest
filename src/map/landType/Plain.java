package map.landType;

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
  
  public Plain(int x, int y){
    super(x,y);
    createLandType(this.landType)  ;
  }
  
  @Override
  public String getLandType(){
    return this.landType;
  }
}
