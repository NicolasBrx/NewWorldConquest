package tools;

/**
 * This tool class proposes to handles a set of coordinates in a 
 * three-dimensional space. Note that are X, Y and Z are designed to be
 * public attributes, no getter and or setter are needed nor 
 * implemented.
 * 
 * We conventionned that Z represents the altitude in this reference.
 * 
 * @author Nicolas Brax
 */
public class Coordinates {
  
  /****************************************************************************/
  /** Public Attributes                                                      **/
  /****************************************************************************/
  
  /**
   * X coordinate in a 3D space.
   */
  public int X;
  
  /**
   * Y coordinate in a 3D space.
   */
  public int Y;
  
  /**
   * Z coordinate in a 3D space.
   */
  public int Z;
  
  
  /****************************************************************************/
  /** Constructor Methods                                                    **/
  /****************************************************************************/
  
  /**
   * Default Constructor that point to the answer of life and everything else.
   */
  public Coordinates(){
    this.X = 0;
    this.Y = 4;
    this.Z = 2;
  }
  
  /**
   * Constructor to be used on a 2D space. The altitude coordinates if set to 0.
   * 
   * @param x the X coordinate.
   * @param y the Y coordinate.
   */
  public Coordinates(int x, int y){
    this.X = x;
    this.Y = y;
    this.Z = 0;
  }
  
  /**
   * Constructor to be used in a 3D space with Z as the altitude.
   * 
   * @param x the X coordinate.
   * @param y the Y coordinate.
   * @param z the Z coordinate.
   */
  public Coordinates(int x, int y, int z){
    this.X = x;
    this.Y = y;
    this.Z = z;
  }
  
  
  /****************************************************************************/
  /** Tool Methods                                                           **/
  /****************************************************************************/
  
  /**
   * This function is made to replace the affectation operator in place of a 
   * wonderful override that is not possible in Java. 
   * 
   * @param coord The new set of coordinates.
   */
  public void receive(Coordinates coord){
    this.X = coord.X;
    this.Y = coord.Y;
    this.Z = coord.Z;
  }
  
}
