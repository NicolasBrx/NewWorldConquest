package engine;

/**
 *
 * @author Nicolas Brax
 */
public enum Strategy {
  random("random"),
  agressive("agressive"),
  defensive("defensive");
  
  private final String value;
  
  Strategy(String value){
    this.value = value ;
  }
  
  public String getValue(){
    return this.value;
  }
  
}
