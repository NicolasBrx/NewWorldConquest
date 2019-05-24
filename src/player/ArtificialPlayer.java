/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import java.util.ArrayList;
import tools.Coordinates;
import units.Unit;

/**
 *
 * @author nibrax
 */
public class ArtificialPlayer extends Player{
  // Artificial Intelligence Player
  // all its unit have an intelligence engine of their own... mouhahahaha !
  public ArtificialPlayer(){
    super();
  }
  
  public ArtificialPlayer(int playerId, String pseudo, int team){
    super(playerId,pseudo,team);
  }
  
  @Override
  public void addUnit(Unit unit){
    unit.activateAI(true);
    super.addUnit(unit);
  }
  
  public void deactivateAI(){
    for(Unit unit : unitList){
      unit.activateAI(false);
    }
  }
  
  public void gameTurn(){
    ArrayList<Coordinates> gainedLocations = new ArrayList<>();
    for(Unit unit : unitList){
      Coordinates newLocation = new Coordinates();
      newLocation = unit.playAI();
      if(newLocation.X != -1 && newLocation.Y != -1){
        gainedLocations.add(newLocation);
      }
    }
    
    // process gainedLocation: store, unit creation, add to defense priorities, whatever...
    
  }
}
