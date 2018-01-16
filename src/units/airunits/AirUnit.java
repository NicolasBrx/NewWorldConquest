package units.airunits;

import tools.Coordinates;
import units.Unit;

/**
 *
 * @author nicolas
 */
public class AirUnit extends Unit{
  
  private final int MAX_FUEL = 10;
  
  private String baseCampId;
  private int currentFuel;
  
  public AirUnit(){
    super(0,new Coordinates(0,0));
    this.baseCampId = null;
    this.currentFuel = 0;
  }
  
  public AirUnit(int team, Coordinates coord, String camp){
    super(0,coord);
    this.baseCampId = camp;
    this.currentFuel = this.MAX_FUEL;
  }

  public void refuel(){
    this.currentFuel = this.MAX_FUEL;
  }
  
  public String getBaseCamp() {
    return baseCampId;
  }

  public void setBaseCamp(String baseCampId) {
    this.baseCampId = baseCampId;
  }

  public int getFuelCapacity() {
    return currentFuel;
  }

  public void setFuelCapacity(int fuelCapacity) {
    this.currentFuel = fuelCapacity;
  }
  
  
  
}
