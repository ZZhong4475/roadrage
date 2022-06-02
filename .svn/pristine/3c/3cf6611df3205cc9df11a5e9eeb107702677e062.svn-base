/**
 * Child Class inherited from AbstractedVehicle 
 * It stores information of Taxi vehicle
 */

package model;
import java.util.Map;

/**
 * @author Zheng Zhong
 * @version 02/07/2020
 *
 */
public class Taxi extends AbstractVehicle {
    /**
     * Static Variable for taxi time.
     */
    private static final int MY_DEATH_TIME = 15;
    /**
     * Variable to store clock time.
     */
    private int myClock;
    

   
    /**Constructs taxi variable.
     * @param theX X-coordinate.
     * @param theY Y-coordinate.
     * @param theDirection Facing Direction.
     */
    public Taxi(final int theX,  final int theY, final Direction theDirection) {
        super(theX, theY, theDirection, MY_DEATH_TIME);
        myClock = 0;

     
    }

    /**
     *Restrict taxi behaviors.
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        final int maxNum = 3;
        boolean canPass = true;
        if (theTerrain == Terrain.STREET || theTerrain == Terrain.LIGHT
                        || theTerrain == Terrain.CROSSWALK) {
            canPass = true;
          
          
        } else if (theTerrain == Terrain.LIGHT && theLight == Light.RED) {
            canPass = false;
        } else if (theTerrain == Terrain.CROSSWALK && theLight == Light.RED) {
            canPass = false;
            myClock++;
            if (myClock == maxNum) {
                myClock = 0;
                canPass = true;
            }
        }
        
        return canPass;
        
    
    }
    /**
     *Return direction to GUI for Taxi beaviors.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        final Direction goDirection;
        if (theNeighbors.get(getDirection()) == Terrain.CROSSWALK
                        || theNeighbors.get(getDirection()) == Terrain.STREET
                        || theNeighbors.get(getDirection()) == Terrain.LIGHT
            ) {
            goDirection = getDirection();
        } else if (theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK
                        || theNeighbors.get(getDirection().left()) == Terrain.STREET
                        || theNeighbors.get(getDirection().left()) == Terrain.LIGHT
        ) {
            goDirection = getDirection().left();
                        
        } else if (theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK
                        || theNeighbors.get(getDirection().right()) == Terrain.STREET
                        || theNeighbors.get(getDirection().right()) == Terrain.LIGHT
        ) {
            goDirection = getDirection().right();
                        
        } else {
            goDirection = getDirection().reverse();
                    
        }
        return goDirection;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("The Taxi located at: ");
        sb.append(this.getX() + " . " + this.getY() + "\n");
        sb.append("Is it alive? ");
        sb.append(this.isAlive() + "\n");
        sb.append("The death time: ");
        sb.append(MY_DEATH_TIME + "\n");
        sb.append("The facing Direction: ");
        sb.append(this.getDirection());
        sb.append("My Clock time is: ");
        sb.append(this.myClock);
     
        return sb.toString();
    }

}
