package tools;

/**
 *
 * @author Nicolas Brax
 */
public class Coordinates {
  
  public int X;
  public int Y;
  public int Z;
  
  /**
   * 
   */
  public Coordinates(){
    this.X = -1;
    this.Y = -1;
    this.Z = -1;
  }
  
  /**
   * 
   * @param x
   * @param y 
   */
  public Coordinates(int x, int y){
    this.X = x;
    this.Y = y;
    this.Z = 0;
  }
  
  /**
   * 
   * @param x
   * @param y
   * @param z 
   */
  public Coordinates(int x, int y, int z){
    this.X = x;
    this.Y = y;
    this.Z = z;
  }
  
  /**
   * 
   * @return 
   */
  public int getX(){
    return this.X;
  }
  
  /**
   * 
   * @return 
   */
  public int getY(){
    return this.Y;
  }
  
  /**
   * 
   * @return 
   */
  public int getZ(){
    return this.Z;
  }
  
  /**
   * 
   * @param x 
   */
  public void setX(int x){
    this.X = x;
  }
  
  /**
   * 
   * @param y 
   */
  public void setY(int y){
    this.Y = y;
  }
  
  /**
   * 
   * @param z 
   */
  public void setZ(int z){
    this.Z = z;
  }
  
  /**
   * 
   * @param coord 
   */
  public void receive(Coordinates coord){
    this.X = coord.X;
    this.Y = coord.Y;
    this.Z = coord.Z;
  }
  
}
