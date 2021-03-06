/**
 * Child Class inherited from AbstractedVehicle 
 * It stores information of Atv vehicle
 */
package model;


import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 * @author Zheng Zhong
 *@version 02/07/2020
 */
public class Atv extends AbstractVehicle {
    /**
     * Static variable of Atv death time.
     */ 
    private static final int MY_DEATH_TIME = 25;
    /**
     * @param theX
     * @param theY
     * @param theDirection
     */
    public Atv(final int theX, final int theY, final Direction theDirection) {
        super(theX, theY , theDirection, MY_DEATH_TIME);
       
    }
    
    /**
     *Restricts Atv behaviors.
     *It can move anywhere except wall.
     */
    @Override
    public boolean canPass(final Terrain theTerrian, final Light theLight) {
        boolean canPass = false;
        if (theTerrian == Terrain.WALL) {
            canPass = false;
        } else {
            canPass = true;
        }
        return canPass;
    }
    

    /**
     *Returns direction to GUI for Atv behaviors.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        final ArrayList<Direction> randomArray = new ArrayList<Direction>();
        final int dirNum;
        final Direction goDirection;
       
        final Random goRanDir = new Random();
        if (theNeighbors.get(getDirection()) != Terrain.WALL) {
            randomArray.add(getDirection());
        } 
        if (theNeighbors.get(getDirection().left()) != Terrain.WALL) {
            randomArray.add(getDirection().left());
        } 
        if (theNeighbors.get(getDirection().right()) != Terrain.WALL) {
            randomArray.add(getDirection().right());
        }

           
        dirNum = goRanDir.nextInt(randomArray.size());
        goDirection = randomArray.get(dirNum);
                
                
                       
     
        return goDirection;
        
       
   
       
                       
        
        
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("The Atv located at: ");
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
