package units;

/**
 *
 * @author nicolas
 */
public interface UnitInterface {
  
  void setName(String newName);
  String getName();
  
  void setPower(int newPower);
  int getPower();
  
  void setMovement(int newMovement);
  int getMovement();
}
