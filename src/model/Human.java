/**
 * Child Class inherited from AbstractedVehicle 
 * It stores information of Human
 */
package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class Human extends AbstractVehicle {
    /**
     * Static variable for bicycle death time.
     */
    private static final int MY_DEATH_TIME = 45;
    
   
    
    /**
     * @param theX
     * @param theY
     * @param theDirection
     */
    public Human(final int theX, final int theY, final Direction theDirection) {
        super(theX, theY, theDirection, MY_DEATH_TIME);
       
    }
    /**
     *
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean canPass = false;
        if (theTerrain == Terrain.GRASS || theTerrain == Terrain.CROSSWALK 
                        && theLight != Light.GREEN) {
            canPass = true;
        }
        if (theTerrain == Terrain.CROSSWALK && theLight == Light.GREEN) {
            canPass = false;
        }
       
        return canPass;

    }
   
    /**
     *Return human behaviors to GUI.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        
        final ArrayList<Direction> randomArray = new ArrayList<Direction>();
        final int dirNum;
        Direction goDirection = Direction.random();
        final Random goRanDir = new Random();
        final boolean emptyA;
        if (theNeighbors.get(getDirection()) == Terrain.CROSSWALK) {
            goDirection = getDirection();
            
        } else {
            
            if (theNeighbors.get(getDirection()) == Terrain.GRASS) { 
            
                randomArray.add(getDirection());
            
            } else if (theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK
                         || theNeighbors.get(getDirection().left()) == Terrain.GRASS) {
           
            
                randomArray.add(getDirection().left());
            
            } else if (theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK
                         || theNeighbors.get(getDirection().right()) == Terrain.GRASS) {
            
            
                randomArray.add(getDirection().right());
            
                     
            } else if (!randomArray.isEmpty()) {
                dirNum = goRanDir.nextInt(randomArray.size());
                goDirection = randomArray.get(dirNum);
            } else if (theNeighbors.get(getDirection().right()) != Terrain.CROSSWALK
                            || theNeighbors.get(getDirection().right()) != Terrain.GRASS) {
                goDirection = getDirection().reverse();
            }
        }
        return goDirection;
    }
        

    @Override
public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("The human located at: ");
        sb.append(this.getX() + " . " + this.getY() + "\n" );
        sb.append("Is it alive? ");
        sb.append(this.isAlive() + "\n");
        sb.append("The death time: ");
        sb.append(MY_DEATH_TIME + "\n");
        sb.append("The facing Direction: ");
        sb.append(this.getDirection());
     
        return sb.toString();
    }   
}

