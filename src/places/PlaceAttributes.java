package places;

/**
 *
 * @author Nicolas Brax
 */
public class PlaceAttributes {
 
  private int unitCapacity;
  private int attackModifier;
  private int defenseModifier;
  private int movementModifier;
  private int visionModifier;
  
  public PlaceAttributes(){
    this.unitCapacity = -1;
    this.attackModifier = -1;
    this.defenseModifier = -1;
    this.visionModifier = -1;
    this.movementModifier = -1;
  }
  
  public PlaceAttributes(int unitCapacity, int attackModifier, 
          int defenseModifier, int visionModifier, int movementModifier){
    this.unitCapacity = unitCapacity;
    this.attackModifier = attackModifier;
    this.defenseModifier = defenseModifier;
    this.visionModifier = visionModifier;
    this.movementModifier = movementModifier;
  }

  public int getUnitCapacity() {
    return unitCapacity;
  }

  public void setUnitCapacity(int unitCapacity) {
    this.unitCapacity = unitCapacity;
  }

  public int getAttackModifier() {
    return attackModifier;
  }

  public void setAttackModifier(int attackModifier) {
    this.attackModifier = attackModifier;
  }

  public int getDefenseModifier() {
    return defenseModifier;
  }

  public void setDefenseModifier(int defenseModifier) {
    this.defenseModifier = defenseModifier;
  }

  public int getMovementModifier() {
    return movementModifier;
  }

  public void setMovementModifier(int movementModifier) {
    this.movementModifier = movementModifier;
  }

  public int getVisionModifier() {
    return visionModifier;
  }

  public void setVisionModifier(int visionModifier) {
    this.visionModifier = visionModifier;
  }
  
  
}
