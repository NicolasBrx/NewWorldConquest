/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.util.ArrayList;

import places.Place;
import units.Unit;

/**
 *
 * @author nicolas
 */
public interface TileInterface {
  
  /*
  public String getLandType();
  public HashMap<String,Integer> getLandModifiers();
  */

  public boolean isSpecialPlace();
  public void addSpecialPlace(Place place);
  public Place getSpecialPlace();
  
  public boolean hasUnit();
  public void addUnit(Unit unit);
  public ArrayList<Unit> getUnits();
  
}
