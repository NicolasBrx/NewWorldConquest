package units;

/**
 * This class allows the management of a set of attributes. Theses attributes 
 * might be used to give and compute several scores for the unit they are
 * related to.
 * 
 * It has to be noted that the modifiers are designed to be the modifiers of
 * the unit only, not the ones that could be given by field or external factors.
 * 
 * @author Nicolas Brax
 */
public class UnitAttributes {
  
  /****************************************************************************/
  /** Private Attributes                                                     **/
  /****************************************************************************/
  
  /**
   * The max attack score that can be reached.
   */
  private int maxAttack;
  
  /**
   * The current attack score.
   */
  private int attack;
  
  /**
   * The current modifier on the attack score.
   */
  private int currentAttackBM;
  
  /**
   * The max defense score that can be reached.
   */
  private int maxDefense;
  
  /**
   * The current defense score.
   */
  private int defense;
  
  /**
   * The current modifier on the defense score.
   */
  private int currentDefenseBM;
  
  /**
   * The max movement score that can be reached.
   */
  private int maxMovement;
  
  /**
   * The current movement score.
   */
  private int movement;
  
  /**
   * The current modifier on the movement score.
   */
  private int currentMovementBM;
  
  /**
   * The max vision score that can be reached.
   */
  private int maxVision;
  
  /**
   * The current vision score.
   */
  private int vision;
  
  /**
   * The current modifier on the vision score.
   */
  private int currentVisionBM;
  
  
  /****************************************************************************/
  /** Constructor Methods                                                    **/
  /****************************************************************************/
  
  /**
   * Default Constructor 
   * The default construtor set all values to -1.
   */
  public UnitAttributes(){
    this.maxAttack = -1;
    this.attack = -1;
    this.currentAttackBM = -1;
    this.maxDefense = -1;
    this.defense = -1;
    this.currentDefenseBM = -1;
    this.maxMovement = -1;
    this.movement = -1;
    this.currentMovementBM = -1;
    this.maxVision = -1;
    this.vision = -1;
    this.currentVisionBM = -1;
  }
  
  /**
   * This is the classic constructor that allows to set max level for all
   * the attributes and for this set of attributes and then each other 
   * attributes is set to its related max score.
   * The modifier are set so they do not interfere with the scores.
   * 
   * @param maxAttack   the max attack score allowed.
   * @param maxDefense  the max defense score allowed. 
   * @param maxMovement the max movement score allowed.
   * @param maxVision   the max vision score allowed.
   */
  public UnitAttributes(int maxAttack,int maxDefense, int maxMovement, int maxVision){
    this.maxAttack = maxAttack;
    this.attack = this.maxAttack;
    this.currentAttackBM = 0;
    this.maxDefense = maxDefense;
    this.defense = this.maxDefense;
    this.currentDefenseBM = 0;
    this.maxMovement = maxMovement;
    this.movement = this.maxMovement;
    this.currentMovementBM = 0;
    this.maxVision = maxVision;
    this.vision = this.maxVision;
    this.currentVisionBM = 0;
  }
  
  /**
   * This constructor allows to set each attributes with its max score and its
   * current score. This can be used to load a previous state for instance.
   * The modifier are set so they do not interfere with the scores.
   * 
   * @param attack      the current attack score.
   * @param maxAttack   the max attack score allowed.
   * @param defense     the current defense score.
   * @param maxDefense  the max defense score allowed.
   * @param movement    the current movement score.
   * @param maxMovement the max movement score allowed.
   * @param vision      the current vision score.
   * @param maxVision   the max vision score allowed.
   */
  public UnitAttributes(int attack,int maxAttack,int defense,int maxDefense,
          int movement, int maxMovement,int vision,int maxVision){
    this.maxAttack = maxAttack;
    this.attack = attack;
    this.currentAttackBM = 0;
    this.maxDefense = maxDefense;
    this.defense = defense;
    this.currentDefenseBM = 0;
    this.maxMovement = maxMovement;
    this.movement = movement;
    this.currentMovementBM = 0;
    this.maxVision = maxVision;
    this.vision = vision;
    this.currentVisionBM = 0;
  }

  
  /****************************************************************************/
  /** Getter and Setter Methods                                              **/
  /****************************************************************************/
  
  /**
   * 
   * @return 
   */
  public int getMaxAttack() {
    return maxAttack;
  }

  /**
   * 
   * @param maxAttack 
   */
  public void setMaxAttack(int maxAttack) {
    this.maxAttack = maxAttack;
  }

  /**
   * 
   * @return 
   */
  public int getAttack() {
    return attack + this.currentAttackBM;
  }

  /**
   * 
   * @param attack 
   */
  public void setAttack(int attack) {
    this.attack = attack;
  }

  /**
   * 
   * @return 
   */
  public int getMaxDefense() {
    return maxDefense;
  }

  /**
   * 
   * @param maxDefense 
   */
  public void setMaxDefense(int maxDefense) {
    this.maxDefense = maxDefense;
  }

  /**
   * 
   * @return 
   */
  public int getDefense() {
    return defense + this.currentDefenseBM;
  }

  /**
   * 
   * @param defense 
   */
  public void setDefense(int defense) {
    this.defense = defense;
  }

  /**
   * 
   * @return 
   */
  public int getMaxMovement() {
    return maxMovement;
  }

  /**
   * 
   * @param maxMovement 
   */
  public void setMaxMovement(int maxMovement) {
    this.maxMovement = maxMovement;
  }

  /**
   * 
   * @return 
   */
  public int getMovement() {
    return movement + this.currentMovementBM;
  }

  /**
   * 
   * @param movement 
   */
  public void setMovement(int movement) {
    this.movement = movement;
  }

  /**
   * 
   * @return 
   */
  public int getMaxVision() {
    return maxVision;
  }

  /**
   * 
   * @param maxVision 
   */
  public void setMaxVision(int maxVision) {
    this.maxVision = maxVision;
  }
  
  /**
   * 
   * @return 
   */
  public int getVision() {
    return vision + this.currentVisionBM;
  }

  /**
   * 
   * @param vision 
   */
  public void setVision(int vision) {
    this.vision = vision;
  }

  /**
   * 
   * @param currentAttackBM 
   */
  public void setCurrentAttackBM(int currentAttackBM) {
    this.currentAttackBM = currentAttackBM;
  }

  /**
   * 
   * @param currentDefenseBM 
   */
  public void setCurrentDefenseBM(int currentDefenseBM) {
    this.currentDefenseBM = currentDefenseBM;
  }

  /**
   * 
   * @param currentMovementBM 
   */
  public void setCurrentMovementBM(int currentMovementBM) {
    this.currentMovementBM = currentMovementBM;
  }

  /**
   * 
   * @param currentVisionBM 
   */
  public void setCurrentVisionBM(int currentVisionBM) {
    this.currentVisionBM = currentVisionBM;
  }
}
