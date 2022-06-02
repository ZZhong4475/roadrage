/**
 * Child Class inherited from AbstractedVehicle 
 * It stores information of car vehicle
 */
package model;


import java.util.Map;



/**
 * @author Zheng Zhong
 * @version 02/07/2020
 *
 */
public class Car extends AbstractVehicle {
    /**
     * Static field for car death time.
     */
    private static final int MY_DEATH_TIME = 15;
   
    
    /**Constructs car type.
     * @param theX x-coordinates of car.
     * @param theY y-cooridnate of car.
     * @param theDirection car facing direction.
     */
    public Car(final int theX, final int theY, final Direction theDirection) {
        super(theX,  theY , theDirection , MY_DEATH_TIME);
    }

    /**
     *Restricts car behaviors.
     *car only on street,all lights.
     *passes on crosswalk green and stop on traffic red light.
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean canPass = true;
        if (theTerrain == Terrain.STREET || theTerrain == Terrain.LIGHT
                        || theTerrain == Terrain.CROSSWALK) {
            canPass = true;
        }
        if (theTerrain == Terrain.CROSSWALK && theLight != Light.GREEN) {
            canPass = false;
        } else if (theTerrain == Terrain.LIGHT && theLight == Light.RED) {
            canPass = false;
        }    
        return canPass;
    }

    /**
     *Returns direction to GUI for car's behaviors.
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
        sb.append("The Car located at: ");
        sb.append(this.getX()  + " . " + this.getY() + "\n");
        sb.append("Is it alive? ");
        sb.append(this.isAlive() + "\n");
        sb.append("The death time: ");
        sb.append(MY_DEATH_TIME + "\n");
        sb.append("The facing Direction: ");
        sb.append(this.getDirection());
     
        return sb.toString();
    }

}
