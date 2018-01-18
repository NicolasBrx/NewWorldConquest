package units;

import tools.Coordinates;

/**
 * This interface presents the several methods that should be implemented by
 * each and every new unit class that are dedicated to be used in NewWorldConquest.
 * 
 * Fullfilling it will ensure the unit is then usable in every other aspect of 
 * the software, meaning:
 * - the user interface;
 * - the game representation;
 * - the IA engine.
 * - anything that can come to mind...
 * 
 * It goes without saying that a constructor is also needed...
 * 
 * @author Nicolas Brax
 */
public interface UnitInterface {
  
  /**
   * This method gives the opportunity to set a specific name for the unit. This
   * name is used in the user interface for user friendly feature.
   * 
   * @param newName the name wanted for the unit.
   */
  void setName(String newName);
  
  /**
   * This method allows to retrieve the specific name of the unit, generically
   * built or set by the user. It is used in the user interface.
   * 
   * @return the name of the unit.
   */
  String getName();
  
  /**
   * This method gives the type of unit. This is useful according to the type
   * of game you want to play. For instance, in a modern game, this type can be
   * 'air', 'ground' or 'sea'.
   * This is also used to check the movement possibility on the map.
   * 
   * @return the type of the unit.
   */
  String getType();
  
  /**
   * This method gives the attack score of the unit as computed according to its
   * own inner method. This score is used when attacking anoter unit and will
   * be compared to its opponent defense score. 
   * Specificity of the engagement rules are given in the user manual.
   * 
   * @return the attack score of the unit
   */
  int getAttackScore();
  
  /**
   * This method gives the defense score of the unit as computed according to its
   * own inner method. This score is used when defending agaist anoter unit and 
   * will be compared to its opponent attack score. 
   * Specificity of the engagement rules are given in the user manual.
   * 
   * @return the defense score of the unit
   */
  int getDefenseScore();
  
  /**
   * This method gives the movement score of the unit as computed according to its
   * own inner method. This score is used to know the movement range of the unit
   * on the map.
   * Specificity of the movement rules are given in the user manual.
   * 
   * @return the movement score of the unit
   */
  int getMovementScore();
  
  /**
   * This method gives the vision score of the unit as computed according to its
   * own inner method. This score is used to know the vision range of the unit
   * on the map.
   * Specificity of the vision rules are given in the user manual.
   * 
   * @return the vision score of the unit
   */
  int getVisionScore();
  
  /**
   * This method is used to determine the damage taken by a unit according to its
   * opponent Damage Value (DV).
   * The DV is computed according to the rules explained in the user manual.
   * 
   * If the unit has sustained too much damage, it is destroyed and the method
   * give -1 as a result. Otherwiser, the result is 1.
   * 
   * @param attackerDV the opponent Damage Value (DV) after engagement resolution.
   * @return -1 if the unit is destroyed, 1 if the unit is still alive.
   */
  int damage(int attackerDV);
  
  /**
   * This method allows the unit to be moved accross the map, no more, no less.
   * @param newCoord the new coordinates where the unit should stand.
   */
  void updateCoordinates(Coordinates newCoord);
  
  /**
   * This method defines what are the benefits of a sufficient amount of
   * experience by the unit. This can goes from a simple heal to a super boost
   * of all stats.
   */
  void levelUp();
  
}
