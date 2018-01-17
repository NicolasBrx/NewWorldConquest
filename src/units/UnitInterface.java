package units;

import tools.Coordinates;

/**
 *
 * @author Nicolas Brax
 */
public interface UnitInterface {
  
  void setName(String newName);
  String getName();
  String getType();
  
  int getAttackScore();
  int getDefenseScore();
  int getMovementScore();
  int getVisionScore();
  
  int damage(int attackerDV);
  void updateCoordinates(Coordinates newCoord);
  void levelUp();
  
}
