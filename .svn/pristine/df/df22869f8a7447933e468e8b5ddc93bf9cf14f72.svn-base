/**TCSS 305 Assignment 02:RoadRage
 * AbstractVehicle class contains contains inheritable methods and constructors for 
 * other vehicle classes.
 * 
 */


package model;



/**
 * @author zhong
 *@version 02/07/2020
 */
public abstract class AbstractVehicle implements Vehicle {
    
    /**
     *Variable stores x-coordinate.
     */
    private int myX;
    /**
     * Variable stores y-coordinate.
     */
    private int myY;
    
    /**
     * Variable stores the direction.
     */
    private Direction myDirection;
    /**
     * Variable determines the living state.
     */
    private boolean myLiving;
    /**
     * Variable stores the death time.
     */
    private int myDeathTime;
    /**
     * Variable stores the revive time.
     */
    private int myPokeTime;
    /**
     * Variable stores initial x-coordinate for reset.
     */
    private final int myInitialX;
    /**
     * Variable stores initial y-coordinate for reset.
     */
    private final int myInitialY;
    /**
     * Varaible stores the initial direction for reset.
     */
    private final Direction myInitialDirection;

  
    /**Constructs a vehicle type.
     * @param theXDir constructs at x-coordinate.
     * @param theYDir constructs at y-coordinate.
     * @param theDir  constrcuts facing direction.
     */
    protected AbstractVehicle(final int theXDir, final int theYDir , final Direction theDir) {
        myPokeTime = 0;
        myLiving = true;
        myX = theXDir;
        this.myInitialX = theXDir;
        myY = theYDir;
        this.myInitialY = theYDir;
        myDirection = theDir;
        this.myInitialDirection = theDir;
                  
                  
    }
   
    /**Overloaded constructs the vehicle.
     * @param theXDir constructs at x-coordinate.
     * @param theYDir constructs at y-coordinate.
     * @param theDir  constructs facing direction.
     * @param theDeathTime constructs death time.
     */
    protected AbstractVehicle(final int theXDir, final int theYDir
                             , final Direction theDir, final int theDeathTime) {
        
        
        myPokeTime = 0;
        myDeathTime = theDeathTime;
        myLiving = true;
        myX = theXDir;
        this.myInitialX = theXDir;
        myY = theYDir;
        this.myInitialY = theYDir;
        myDirection = theDir;
        this.myInitialDirection = theDir;
                   
    }
 
    
    /**
     *Collide methods,more deathtimes surives and less deathtime dies.
     */
    @Override
    public void collide(final Vehicle theOther) {
        if (this.isAlive() && theOther.isAlive()) {
            if (this.myDeathTime > theOther.getDeathTime()) {
                myLiving = false;
                poke();
            } else {
                myLiving = true;
            }
            
            
        }
        
    }
    /**
     *Returns the name of the imgae name to GUI.
     */
    @Override
    public String getImageFileName() {
        final StringBuilder imageFile = new StringBuilder();
        imageFile.append(getClass().getSimpleName().toLowerCase());
        if (this.isAlive()) {
            imageFile.append(".gif");
        } else {
            imageFile.append("_dead.gif");
        }
        
        return imageFile.toString();
        
    }
    /**
     *Returns the direction.
     */
    @Override
   public Direction getDirection() {
        return myDirection; }
    
    /** 
     *Returns the x-coordinate.
     */
    @Override
    public int getX() {
        return myX;
    }
    /**
     *return the y-coordinate.
     */
    @Override
    public int getY() {
        return myY;
    }
    
    /**
     *Returns true is living,dies otherwise.
     */
    @Override
   public boolean isAlive() {
        return myLiving;
      
    }
    /**
     *Counts and times for revive.
     *revive will reset direction
     */
    @Override
   public void poke() {
        if (!this.isAlive()) {
            myPokeTime++;
        }
        if (myDeathTime == myPokeTime) {
            myLiving = true;
            myPokeTime = 0;
            myDirection = Direction.random();
            
        }
           
    }
    @Override
   public int getDeathTime() {
        return myDeathTime;
    }
    @Override
   public void reset() {
        setX(myInitialX);
        setY(myInitialY);
        setDirection(myInitialDirection);
        myPokeTime = 0;
        myLiving = true;
       
       
       
    }
    @Override
   public void setDirection(final Direction theDirection) {
        myDirection = theDirection;
    }
    
    @Override
    public void setX(final int theX) {
        myX = theX;
    }
    @Override
    public void setY(final int theY) {
        myY = theY;
    }
    


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("The Vehicle located at: ");
        sb.append(myX + " . " + myY + "\n");
        sb.append("Is it alive? ");
        sb.append(myLiving+"\n");
        sb.append("The death time: ");
        sb.append(myDeathTime+"\n");
        sb.append("The number of poke of this car: ");
        sb.append(myPokeTime+"\n");
        sb.append("The facing Direction: ");
        sb.append(myDirection);
     
        return sb.toString();
        
    }
    
    
    
}
