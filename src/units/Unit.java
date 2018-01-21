package units;

/**
 * This pure abstract class is here for nothing except to act as a super
 * class for all possible unit classes. All other unit class MUST inherit
 * the class Unit and implements the interface UnitInterface in order to be
 * used by the game.
 * 
 * Inheritance allows all children classes to be used by the game without
 * further modifications.
 * 
 * Interface implementations allows the game to use the child class in all the 
 * needed ways.
 * 
 * @author Nicolas Brax
 */
public abstract class Unit implements UnitInterface {
  
  // Nothing to see here...
  
}
