package map;

//TODO: add proper javadoc.

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;
import map.landType.*;
import places.*;
import tools.WCException;

/**
 * This class is the software representation of the game area, the map where
 * the units are then set and used.
 * 
 * @author Nicolas Brax
 */
public class Map {
  
  /**
   * 
   */
  public enum geometricForm{HEXAGONAL,PAVEMENT};
  
  /**
   * 
   */
  private final geometricForm tileForms;
  
  /**
   * always a square
   */
  private Tile[][] theMap;
  
  /**
   * 
   * @throws WCException
   */
  public Map() throws WCException{
    theMap = new Tile[10][10];
    tileForms = geometricForm.PAVEMENT;
    mapGeneration();
  }
  
  /**
   * 
   * @param xMax
   * @param yMax 
   * @throws tools.WCException 
   */
  public Map(int xMax, int yMax) throws WCException{
    theMap = new Tile[xMax][yMax];
    tileForms = geometricForm.PAVEMENT;
    mapGeneration();
  }
  
  /**
   * 
   * @param x
   * @param y
   * @return 
   */
  public Tile getTile(int x, int y){
    return theMap[x][y];
  }
  
  private void mapGeneration() throws WCException{
    
    generateLands();
    generateSpecialPlaces();
    
  }
  
  private void generateLands() throws WCException{
    for(int i = 0; i < theMap.length ; ++i){
      for(int j = 0 ; j < theMap[0].length ; ++j){
        Random rand = new Random();
        int n = rand.nextInt(5);
        switch(n){
          case 0:
            theMap[i][j] = new Desert(i,j);
            break;
          case 1:
            theMap[i][j] = new Hill(i,j);
            break;
          case 2:
            theMap[i][j] = new Mountain(i,j);
            break;
          case 3:
            theMap[i][j] = new Plain(i,j);
            break;
          case 4:
            theMap[i][j] = new Sea(i,j);
            break;
          default:
            throw new WCException("Error on randomization for a land type. [generateLands()]");
        }//switch
      }// for j
    }// for i
  }
  
  private void generateSpecialPlaces() throws WCException{
    //TODO: make an xml file to generation settings and nothing is then set hard coded
    //TODO: modify to generate proper name (count already added places)
    //TODO: use xml to load right classes => no hard code for name classes...
    
    for(int i = 0; i < theMap.length ; ++i){
      for(int j = 0 ; j < theMap[0].length ; ++j){
    
        //TODO: better this or add a remove function?!
        RandomCollection rc = new RandomCollection()
                              .add(50,"None")
                              .add(2,"Airport").add(2,"City").add(2, "Military Camp");
        
        if(theMap[i][j].getLandType().equalsIgnoreCase("Desert")){
          rc.add(25,"Oasis").add(25,"Oil Derrick");
        }
        else if(theMap[i][j].getLandType().equalsIgnoreCase("Sea")){
          rc.add(25,"Harbour");
        }
        else{
          rc.add(2,"Oasis").add(2,"Oil Derrick").add(2,"Harbour");
        }
        
        switch(rc.next()){
          case "Airport":
            theMap[i][j].addSpecialPlace(new Airport(i,j,0,1));
            break;
          case "City":
            theMap[i][j].addSpecialPlace(new City(i,j,0,1));
            break;
          case "Military Camp":
            theMap[i][j].addSpecialPlace(new MilitaryCamp(i,j,0,1));
            break;
          case "Oasis":
            theMap[i][j].addSpecialPlace(new Oasis(i,j,0,1));
            break;
          case "Oil Derrick":
            theMap[i][j].addSpecialPlace(new OilDerrick(i,j,0,1));
            break;
          case "Harbour":
            theMap[i][j].addSpecialPlace(new Harbour(i,j,0,1));
            break;
          case "None":
            // We don't add any special places to this location.
            break;
          default:
            throw new WCException("Error on randomization for a land type. [generateLands()]");
        }//switch rc.next()
        
      }//for j
    }// for i
  }
  
  /**
   * Depends on the geometrical form wanted...
   * @param x
   * @param y
   * @return 
   */
  public Tile[] getNeighbours(int x, int y){
    return null;
  }
  
  public geometricForm getGeometricForm(){
    return this.tileForms;
  }
  
  @Override
  public String toString(){
    String toReturn = "";
    toReturn += "**************************************************\r\n";
    for(int i = 0; i < theMap.length ; ++i){
      for(int j = 0 ; j < theMap[0].length ; ++j){
        toReturn += "|" + theMap[i][j].getLandType().charAt(0);
        if(theMap[i][j].hasUnit()){
          toReturn += theMap[i][j].getUnits().get(0).getName().charAt(0);
        }
        else{
          toReturn += " ";
        }
        if(theMap[i][j].isSpecialPlace()){
          toReturn += theMap[i][j].getSpecialPlace().getName().charAt(0);
        }
        else{
          toReturn += " ";
        }
        toReturn += "|";
      }// for j
      toReturn += "\r\n**************************************************\r\n";
    }// for i
    
    return toReturn;
  }
  // logical representation
  
  // hex grid:
  // one cell is surrounded by 6 other
  // one cell is given a land type
  
  // map is made of biome generation => related tiles are set more or less close to each other
  
  /**
   * 
   */
  class RandomCollection {
    private final NavigableMap<Double, String> map = new TreeMap<>();
    private final Random random;
    private double total = 0;

    public RandomCollection() {
        this(new Random());
    }

    public RandomCollection(Random random) {
        this.random = random;
    }

    public RandomCollection add(double weight, String result) {
        if (weight <= 0) return this;
        total += weight;
        map.put(total, result);
        return this;
    }

    public String next() {
        double value = random.nextDouble() * total;
        return map.higherEntry(value).getValue();
    }
  }//class RandomCollection
}
