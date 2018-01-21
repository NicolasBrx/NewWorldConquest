package map;

import java.util.ArrayList;
import places.Place;
import tools.Coordinates;
import units.Unit;

/**
 *
 * @author nicolas
 */
public abstract class Tile implements TileInterface {
  private final Coordinates tileCoord;
  private Place specialPlace;
  private ArrayList<Unit> units;
  
  public Tile(){
    tileCoord = new Coordinates(0,0);
    specialPlace = null;
    units = null;
  }
  
  public Tile(int x,int y){
    tileCoord = new Coordinates(x,y);
    specialPlace = null;
    units = new ArrayList<Unit>();
  }
  
  public boolean isSpecialPlace(){
    return this.specialPlace != null ;
  }
  
  public void addSpecialPlace(Place place){
    this.specialPlace = place;
  }
  
  public Place getSpecialPlace(){
    return this.specialPlace;
  }
  
  public boolean hasUnit(){
    return !this.units.isEmpty();
  }
  
  public void addUnit(Unit unit){
    this.units.add(unit);
  }
  
  public ArrayList<Unit> getUnits(){
    return this.units;
  }
  
  // cell feature:
  // it can host one special location
  // it can host a given amount of unit
  
  // it can provides bonus and / or malus
  
}
