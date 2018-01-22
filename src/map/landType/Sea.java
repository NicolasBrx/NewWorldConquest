package map.landType;

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
  
  public Sea(int x, int y){
    super(x,y);
    createLandType(this.landType)  ;
  }
  
  @Override
  public String getLandType(){
    return this.landType;
  }
}
