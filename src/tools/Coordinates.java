package tools;

/**
 *
 * @author Nicolas Brax
 */
public class Coordinates {
  
  public int X;
  public int Y;
  
  public Coordinates(){
    this.X = -1;
    this.Y = -1;
  }
  
  public Coordinates(int x, int y){
    this.X = x;
    this.Y = y;
  }
  
  public int getX(){
    return this.X;
  }
  public int getY(){
    return this.Y;
  }
  public void setX(int x){
    this.X = x;
  }
  public void setY(int y){
    this.Y = y;
  }
  
}
