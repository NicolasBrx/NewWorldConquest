package map;

//TODO: add proper javadoc.

import java.util.ArrayList;
import java.util.HashMap;
import places.Place;
import tools.Coordinates;
import tools.WCException;
import tools.XmlTool;
import units.Unit;

/**
 *
 * @author Nicolas Brax
 */
public abstract class Tile implements TileInterface {
  
  private int visionModifier;
  private int movementModifier;
  private Place specialPlace;
  private ArrayList<Unit> units;
  
  public Tile(){
    specialPlace = null;
    units = null;
    units = new ArrayList<>();
  }
  
  public void createLandType(String landType) throws WCException{
    XmlTool xml = new XmlTool();
    this.visionModifier = xml.loadLand(landType).get(0);
    this.movementModifier = xml.loadLand(landType).get(1);
  }
  
  @Override
  public HashMap<String,Integer> getLandModifiers(){
    HashMap<String,Integer> toReturn = new HashMap<>();
    toReturn.put("vision",this.visionModifier);
    toReturn.put("movement",this.movementModifier);
    return toReturn;
  }
  
  @Override
  public boolean isSpecialPlace(){
    return this.specialPlace != null ;
  }
  
  @Override
  public void addSpecialPlace(Place place){
    this.specialPlace = place;
  }
  
  @Override
  public Place getSpecialPlace(){
    return this.specialPlace;
  }
  
  @Override
  public boolean hasUnit(){
    return !this.units.isEmpty();
  }
  
  @Override
  public void addUnit(Unit unit){
    this.units.add(unit);
  }
  
  @Override
  public ArrayList<Unit> getUnits(){
    return this.units;
  }
}
