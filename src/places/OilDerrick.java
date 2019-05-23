package places;

import tools.Coordinates;
import tools.WCException;

/**
 *
 * @author nicolas
 */
public class OilDerrick extends Place {
  
  /****************************************************************************/
  /** Constant Attributes                                                    **/
  /****************************************************************************/
  
  /**
   * The generic and constant name of the place. This is also used to load the 
   * several values related to the place in the file data/base_places.xml.
   */
  private final String GENERIC_NAME = "Oil Derrick";
  
  
  /****************************************************************************/
  /** Constructor Methods                                                    **/
  /****************************************************************************/
  
  /**
   * 
   */
  public OilDerrick() throws WCException{
    super();
    createPlace(GENERIC_NAME,-1);
  }
  
  /**
   * 
   * @param x
   * @param y
   * @param z 
   * @param nb 
   */
  public OilDerrick(int nb) throws WCException{
    super();
    createPlace(GENERIC_NAME,nb);
  }
  
  
  /****************************************************************************/
  /** Getter and Setter Methods                                              **/
  /****************************************************************************/
  
  /**
   * Give the generic name of the place. This name is the one used to refer 
   * to the file in which all initial values and scores are set for places.
   * 
   * @return the generic name.
   */
  public String getGenericName(){
    return this.GENERIC_NAME;
  }
}