package map;

//TODO: add proper javadoc.

import java.util.ArrayList;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;
import map.landType.*;
import places.*;
import tools.Coordinates;
import tools.WCException;

/**
 * This class is the software representation of the game area, the map where
 * the units are then set and used.
 * 
 * TODO: add save/load of a map to avoid new calculation each time + premade maps?
 * 
 * @author Nicolas Brax
 */
public class Map {
  
  /**
   * 
   */
  private final int XMAX = 9;
  private final int YMAX = 9;
  private final int BIOME_CHANGE_FACTOR = 3;
  
  /**
   * 
   */
  private int xmax;
  private int ymax;
  
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
    this.xmax = this.XMAX;
    this.ymax = this.YMAX;
    this.theMap = new Tile[this.xmax][this.ymax];
    this.tileForms = geometricForm.PAVEMENT;
    mapGeneration();
  }
  
  /**
   * 
   * @param xMax
   * @param yMax 
   * @throws tools.WCException 
   */
  public Map(int xMax, int yMax) throws WCException{
    this.xmax = xMax;
    this.ymax = yMax;
    this.theMap = new Tile[xMax][yMax];
    this.tileForms = geometricForm.PAVEMENT;
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
    int startingX = (int)(this.getXmax() / 2);
    int startingY = (int)(this.getYmax() / 2);
    
    // generate the starting point
    Random rand = new Random();
    int n = rand.nextInt(5);
    switch(n){
      case 0: theMap[startingX][startingY] = new Desert();  break;
      case 1: theMap[startingX][startingY] = new Hill();    break;
      case 2: theMap[startingX][startingY] = new Mountain();break;
      case 3: theMap[startingX][startingY] = new Plain();   break;
      case 4: theMap[startingX][startingY] = new Sea();     break;
      default: throw new WCException("Error on randomization for a land type. [generateLands()]");
    }//switch
    int processed = 1 ;
    
    // all others...
    biomeGeneration(startingX,startingY,processed);
  } // end generateLands
  
  /**
   * 
   * @param startingX
   * @param startingY
   * @param processed 
   */
  private void biomeGeneration(int startingX, int startingY,int processed) throws WCException{
    ArrayList<Coordinates> toProcess = new ArrayList<>();
    toProcess.add(new Coordinates(startingX,startingY));
    while(processed < this.xmax * this.ymax){
      ArrayList<Coordinates> newToProcess = new ArrayList<>();
      ArrayList<Coordinates> neighboursToProcess = new ArrayList<>();
      for(int i = 0 ; i < toProcess.size() ; ++i){
        neighboursToProcess = getNeighbours(toProcess.get(i).X,toProcess.get(i).Y);
        for(Coordinates neighbourCoordinate : neighboursToProcess){
          if(this.theMap[neighbourCoordinate.X][neighbourCoordinate.Y] == null){
            // generate a land according to the surrounding lands
            buildStatAndGenerate(neighbourCoordinate.X,neighbourCoordinate.Y);
            newToProcess.add(new Coordinates(neighbourCoordinate.X,neighbourCoordinate.Y));
            ++processed;
          } // end if null
        } // end for neighboursToProcess
        toProcess.clear();
        toProcess.addAll(newToProcess);
      } // end for toProcess
    } // end while processed
  } // end biomeGeneration
  
  /**
   * 
   * @param X
   * @param Y
   * @return 
   */
  private void buildStatAndGenerate(int X, int Y) throws WCException{
    
    ArrayList<Coordinates> surroundings = this.getNeighbours(X,Y);
    int hillChance = 10, mountainChance = 10, 
        plainChance = 10, seaChance = 10, 
        desertChance = 10;
    for(Coordinates coordinate : surroundings){
      if(this.theMap[coordinate.X][coordinate.Y] != null){
        switch(this.theMap[coordinate.X][coordinate.Y].getLandType()){
          case "Desert":   desertChance += (100 / BIOME_CHANGE_FACTOR);   break;
          case "Hill":     hillChance += (100 / BIOME_CHANGE_FACTOR);     break;
          case "Mountain": mountainChance += (100 / BIOME_CHANGE_FACTOR); break;
          case "Plain":    plainChance += (100 / BIOME_CHANGE_FACTOR);    break;
          case "Sea":      seaChance += (100 / BIOME_CHANGE_FACTOR);      break;
          default: throw new WCException("Error on ...");
        }
      }// if !null
    }
    
    RandomCollection rc = new RandomCollection();
    rc.add(desertChance,"Desert").add(hillChance, "Hill")
       .add(mountainChance, "Mountain").add(plainChance, "Plain")
       .add(seaChance, "Sea");
    switch(rc.next()){
      case "Desert":   theMap[X][Y] = new Desert();   break;
      case "Hill":     theMap[X][Y] = new Hill();     break;
      case "Mountain": theMap[X][Y] = new Mountain(); break;
      case "Plain":    theMap[X][Y] = new Plain();    break;
      case "Sea":      theMap[X][Y] = new Sea();      break;
      default:         throw new WCException("Error on randomization for a land type. [generateLands()]");
    }//switch
  }
  
  private void generateSpecialPlaces() throws WCException{
    
    //TODO: make an xml file to generation settings and nothing is then set hard coded
    //TODO: modify to generate proper name (count already added places)
    //TODO: use xml to load right classes => no hard code for name classes...
    
    for(int i = 0; i < theMap.length ; ++i){
      for(int j = 0 ; j < theMap[0].length ; ++j){
    
        if(!theMap[i][j].getLandType().equalsIgnoreCase("Sea")){
          RandomCollection rc = new RandomCollection()
                                .add(50,"None")
                                .add(2,"Airport").add(2,"City").add(2, "Military Camp");
        
          if(theMap[i][j].getLandType().equalsIgnoreCase("Desert")){
            rc.add(20,"Oasis").add(10,"Oil Derrick");
          }
          else if(oneOfNeighboursIs(i,j,"Sea")){
            rc.add(30,"Harbour");
          }
          else{
            rc.add(2,"Oasis").add(2,"Oil Derrick");
          }
        
         switch(rc.next()){
            case "Airport":       theMap[i][j].addSpecialPlace(new Airport(1));      break;
            case "City":          theMap[i][j].addSpecialPlace(new City(1));         break;
            case "Military Camp": theMap[i][j].addSpecialPlace(new MilitaryCamp(1)); break;
            case "Oasis":         theMap[i][j].addSpecialPlace(new Oasis(1));        break;
            case "Oil Derrick":   theMap[i][j].addSpecialPlace(new OilDerrick(1));   break;
            case "Harbour":       theMap[i][j].addSpecialPlace(new Harbour(1));      break;
            case "None":          break; // We don't add any special places to this location.break;
            default:throw new WCException("Error on randomization for a special place. [generateSpecialPlaces()]");
          }//switch rc.next()
        }//if !Sea
      }//for j
    }// for i
  } // end generateSpecialPlaces 
  
  /**
   * Depends on the geometrical form wanted...
   * @param x
   * @param y
   * @return 
   */
  public ArrayList<Coordinates> getNeighbours(int x, int y){
    ArrayList<Coordinates> toReturn = new ArrayList<>();
    
    if(this.tileForms == geometricForm.HEXAGONAL){
      //TODO: add this feature...
    }
    else if(this.tileForms == geometricForm.PAVEMENT){
      for(int i = (x > 0 ? x-1 : x) ; i <= ((x < (this.theMap.length - 1)) ? x+1 : x) ; ++i){
        for(int j = (y > 0 ? y-1 : y) ; j <= ((y < (this.theMap[0].length - 1)) ? y+1 : y) ; ++j){
          if(i != x || j != y){
            toReturn.add(new Coordinates(i,j));
          }
        }//for j
      }// for i
    }
    return toReturn;
  } // end getNeighbours
  
  public boolean oneOfNeighboursIs(int x,int y,String landtype){
    ArrayList<Coordinates> neighbours = getNeighbours(x,y);
    boolean found = false;
    int i = 0;
    while(!found && i < neighbours.size()){
      found = this.getTile(neighbours.get(i).X,neighbours.get(i).Y).getLandType().equalsIgnoreCase(landtype);
      i++;
    }
    return found;
  } // end oneOfNeighboursIs
  
  public geometricForm getGeometricForm(){
    return this.tileForms;
  }
  
  @Override
  public String toString(){
    String toReturn = "";
    for(int i = 0 ; i < (int)(theMap.length) ; ++i)
      toReturn+="*****";
    toReturn += "\r\n";
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
      toReturn += "\r\n";
      for(int k = 0 ; k < (int)(theMap.length) ; ++k)
        toReturn+="*****";
      toReturn += "\r\n";
    }// for i
    
    return toReturn;
  } // end toString

  public int getXmax(){
    return xmax;
  }

  public void setXmax(int xmax){
    this.xmax = xmax;
  }

  public int getYmax(){
    return ymax;
  }

  public void setYmax(int ymax){
    this.ymax = ymax;
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
