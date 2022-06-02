
/**
 * Child Class inherited from AbstractedVehicle 
 * It stores information of car vehicle
 */
package model;


import java.util.Map;

public class Bicycle extends AbstractVehicle {
    /**
     * Static variable for bicycle death time.
     */
    private static final int MY_DEATH_TIME = 35;
   
    
    /**Constructs bicycle class.
     * @param theX X-coordinate.
     * @param theY Y-coordinate.
     * @param theDirection Facing Direcition.
     */
    public Bicycle(final int theX, final int theY , final Direction theDirection) {
        super(theX, theY , theDirection, MY_DEATH_TIME);
    }

    /**
     *Restricts biycle behaviors.
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean canPass = false;
        if (theTerrain != Terrain.WALL && theTerrain != Terrain.GRASS) {
            canPass = true;
        }
        if (theTerrain == Terrain.CROSSWALK && theLight != Light.GREEN) {
            canPass = false;
        } else if (theTerrain == Terrain.LIGHT && theLight != Light.GREEN) {
            canPass = false;
        }
         
        return canPass;
    }

    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        Direction goDirection = Direction.random();
        if (theNeighbors.get(getDirection()) == Terrain.TRAIL) {
            goDirection = getDirection();
        } else if (theNeighbors.get(getDirection().left()) == Terrain.TRAIL) {
            goDirection = getDirection().left();
        } else if (theNeighbors.get(getDirection().right()) == Terrain.TRAIL) {
            goDirection = getDirection().right();
        } else {
            if (theNeighbors.get(getDirection()) == Terrain.STREET
                            || theNeighbors.get(getDirection()) == Terrain.CROSSWALK
                            || theNeighbors.get(getDirection()) == Terrain.LIGHT
                ) {
                goDirection = getDirection();
            } else if (theNeighbors.get(getDirection().left()) == Terrain.STREET
                            || theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK
                            || theNeighbors.get(getDirection().left()) == Terrain.LIGHT) {
                
                goDirection = getDirection().left();
            } else if (theNeighbors.get(getDirection().right()) == Terrain.STREET
                   || theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK
                   || theNeighbors.get(getDirection().right()) == Terrain.LIGHT){
                goDirection = getDirection().right();
            }
            
            
        }
        return goDirection;       
                
               
                
    }
        
            
        

        


 
        
      
        
      

       

                

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("The bicycle located at: ");
        sb.append(this.getX() + " . " + this.getY() + "\n");
        sb.append("Is it alive? ");
        sb.append(this.isAlive() + "\n");
        sb.append("The death time: ");
        sb.append(MY_DEATH_TIME + "\n");
        sb.append("The facing Direction: ");
        sb.append(this.getDirection());
 
        return sb.toString();
    }
}

    
    
