package places;

/**
 *
 * @author Nicolas Brax
 */
public interface PlaceInterface {
  
  /**
   * 
   * @return 
   */
  int getBaseVision();
  
  /**
   * 
   * @return 
   */
  int getAttackBM();
  
  /**
   * 
   * @return 
   */
  int getDefenseBM();
  
  /**
   * 
   * @return 
   */
  int getVisionBM();
  
  /**
   * 
   * @return 
   */
  int getMovementBM();
  
  /**
   * 
   * @return 
   */
  int getUnitCapacity();
  
  /**
   * 
   * @return 
   */
  int getOwnerTeam();
  
  /**
   * 
   * @param newOwner 
   */
  void setOwnerTeam(int newOwner);
  
}
