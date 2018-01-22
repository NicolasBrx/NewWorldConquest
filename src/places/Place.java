package places;

//TODO: add proper javadoc to class as well as for all children of this class.

import java.util.ArrayList;
import tools.Coordinates;
import tools.WCException;
import tools.XmlTool;

/**
 *
 * @author Nicolas Brax
 */
public abstract class Place implements PlaceInterface{
  
  /****************************************************************************/
  /** Private Attributes                                                     **/
  /****************************************************************************/
  
  /**
   * 
   */
  private String placeId;
  
  /**
   * The name of the place. This name can be modified by the user.
   */
  private String name;
  
  /**
   * 
   */
  private int ownerTeam;
  
  /**
   * 
   */
  private final int baseVision;
  
  /**
   * 
   */
  private Coordinates coordinates;
  
  /**
   * 
   */
  protected PlaceAttributes scoreModifiers;
  
  
  /****************************************************************************/
  /** Constructor Methods                                                    **/
  /****************************************************************************/
  
  /**
   * 
   */
  public Place(){
    coordinates.receive(new Coordinates(0,0));
    this.ownerTeam = -1;
    this.baseVision = -1;
  }
  
  /**
   * 
   * @param coordinates 
   */
  public Place(Coordinates coordinates){
    this.coordinates = new Coordinates(coordinates.X,coordinates.Y,coordinates.Z);
    this.ownerTeam = 0;
    this.baseVision = 2;
  }
  
  /**
   * 
   * @param placeName 
   * @param nb 
   * @throws tools.WCException 
   */
  protected void createPlace(String placeName, int nb) throws WCException{
    XmlTool loader = new XmlTool();
    ArrayList<Integer> place = loader.loadPlace(placeName);
    this.scoreModifiers = new PlaceAttributes(place.get(0),place.get(1),
            place.get(2),place.get(3),place.get(4));
    this.name = placeName + " " + (nb < 10 ? "0" : "") + nb;
  }
  
  
  /****************************************************************************/
  /** Getter and Setter Methods                                              **/
  /****************************************************************************/
  
  /**
   * 
   * @param placeId 
   */
  public void setPlaceId(String placeId){
    this.placeId = placeId;
  }
  
  /**
   * 
   * @return 
   */
  public String getPlaceId(){
    return this.placeId;
  }
  
  /**
   * Modify the name of the place.
   * @param newName The new name of the place.
   */
  public void setName(String newName){
    this.name = newName;
  }
  
  /**
   * Give the name of the place.
   * @return the name of the place.
   */
  public String getName(){
    return this.name;
  }
  
  
  /****************************************************************************/
  /** Overrided methods from PlaceInterface                                  **/
  /****************************************************************************/
  
  /**
   * 
   * @param newOwner 
   */
  @Override
  public void setOwnerTeam(int newOwner){
    this.ownerTeam = newOwner;
  }
  
  /**
   * 
   * @return 
   */
  @Override
  public int getOwnerTeam(){
    return this.ownerTeam;
  }
  
  /**
   * 
   * @return 
   */
  @Override
  public int getUnitCapacity(){
    return this.scoreModifiers.getUnitCapacity();
  }
  
  /**
   * 
   * @return 
   */
  @Override
  public int getAttackBM(){
    return this.scoreModifiers.getAttackModifier();
  }
  
  /**
   * 
   * @return 
   */
  @Override
  public int getDefenseBM(){
    return this.scoreModifiers.getDefenseModifier();
  }
  
  /**
   * 
   * @return 
   */
  @Override
  public int getMovementBM(){
    return this.scoreModifiers.getMovementModifier();
  }
  
  /**
   * 
   * @return 
   */
  @Override
  public int getVisionBM(){
    return this.scoreModifiers.getVisionModifier();
  }
  
  /**
   * 
   * @return 
   */
  @Override
  public int getBaseVision(){
    return this.baseVision;
  }
  
  /**
   * 
   * @return 
   */
  public Coordinates getCoordinates(){
    return this.coordinates;
  }
}