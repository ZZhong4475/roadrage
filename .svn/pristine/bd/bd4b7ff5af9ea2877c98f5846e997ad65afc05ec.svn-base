/**
 * Child Class inherited from AbstractedVehicle 
 * It stores information of truck vehicle
 */

package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 * @author Zheng Zhong
 * @version 02/07/2020
 *
 */
public class Truck extends AbstractVehicle{
    /**
     * Static variable of truck death time.
     */
    private static final int MY_DEATHE_TIME = 0;
    
    /**Constructs truck type.
     * @param theX X-coordinate.
     * @param theY Y-coordinate.
     * @param theDirection Facing Direction.
     */
    public Truck(final int theX, final int theY, final Direction theDirection) {
        super(theX, theY, theDirection, MY_DEATHE_TIME);
    }

    /**
     *Restricts the truck behavior.
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        final boolean canPass;
        if (theTerrain == Terrain.STREET
                        || theTerrain == Terrain.LIGHT
                        || theTerrain == Terrain.CROSSWALK
                        && theLight != Light.RED
        ) {
            canPass = true;
        } else {
            canPass = false;
        }
        
        return canPass;
       
    
    }
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        final ArrayList<Direction> randomArray = new ArrayList<Direction>();
        final int dirNum;
        final Direction goDirection;
        final Random goRanDir = new Random();
        if (theNeighbors.get(getDirection()) == Terrain.CROSSWALK
                        || theNeighbors.get(getDirection()) == Terrain.STREET
                        || theNeighbors.get(getDirection()) == Terrain.LIGHT
            ) {
            randomArray.add(getDirection()); 
        }
        
        if (theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK
                        || theNeighbors.get(getDirection().left()) == Terrain.STREET
                        || theNeighbors.get(getDirection().left()) == Terrain.LIGHT
            ) {
            randomArray.add(getDirection().left());
        }
                        
                       
        if (theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK
                        || theNeighbors.get(getDirection().right()) == Terrain.STREET
                        || theNeighbors.get(getDirection().right()) == Terrain.LIGHT
            ) {
            randomArray.add(getDirection().right());
        }     
        if (!randomArray.isEmpty()) {
            dirNum = goRanDir.nextInt(randomArray.size());
            goDirection = randomArray.get(dirNum);
        } else {
            goDirection = getDirection().reverse();
        }
//           

// 
        return goDirection;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("The truck located at: ");
        sb.append(this.getX() + " . " + this.getY() + "\n");
        sb.append("Is it alive? ");
        sb.append(this.isAlive() + "\n");
        sb.append("The death time: ");
        sb.append(MY_DEATHE_TIME + "\n");
        sb.append("The facing Direction: ");
        sb.append(this.getDirection());
     
        return sb.toString();
    
    }
}
