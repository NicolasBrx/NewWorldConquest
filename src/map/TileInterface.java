package map;

//TODO: add proper javadoc.

import java.util.ArrayList;
import java.util.HashMap;
import places.Place;
import units.Unit;

/**
 *
 * @author Nicolas Brax
 */
public interface TileInterface {
  
  public String getLandType();
  public HashMap<String,Integer> getLandModifiers();
  
  public boolean isSpecialPlace();
  public void addSpecialPlace(Place place);
  public Place getSpecialPlace();
  
  public boolean hasUnit();
  public void addUnit(Unit unit);
  public ArrayList<Unit> getUnits();
  
}
