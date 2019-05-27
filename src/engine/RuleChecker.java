package engine;

/**
 *
 * @author Nicolas Brax
 */
public class RuleChecker {
 // check if rules are followed when a player inputs a course of actions.  
  
  
  // rules of engagement...
  // just a matter of attack vs. defense value
  // with each ally in the vicinity, these values are increasing.
  // no wound, just alive or dead
  
  // rules of unit creation...
  // each city can produce one unit at a time, each unit takes a given number of turns to be created
  // oil derrick can give boost to production
  // one harbour unlocks ships, one airport unlocks aircraft
  // nothing else
  
  // special place usefulness
  // - airport : allows to create and use planes, an airport is mandatory for a plane otherwise it crashes du to lack of maintenance and fuel
  // - city : allows to create units
  // - harbour : allows to create and use ship, allows ground unit to embark
  // - military camp : give defense bonus against attacker
  // - Oasis : give all movemnt score and a small defense bonus while in Desert
  // - Oil Derrick : allows fastest heavy machine (slight) fabrication and movement (large)
  
  // land modifications (lands give bonuses and/or maluses) 
  
  // no upkeep, creation is always possible as long as a city is controlled
  
  // win: control all cities at the end of the turn
  // loss: loose the last city under control and don't regain it before the end of the turn 
  
}
