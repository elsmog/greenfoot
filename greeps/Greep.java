import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.List;

/**
 * A Greep is an alien creature that likes to collect tomatoes.
 * 
 * @author (your name here)
 * @version 0.1
 */
public class Greep extends Creature
{
    // Remember: you cannot extend the Greep's memory. So:
    // no additional fields (other than final fields) allowed in this class!
    
    /**
     * Default constructor for testing purposes.
     */
    public Greep()
    {
        this(null);
    }

    
    /**
     * Create a Greep with its home space ship.
     */
    public Greep(Ship ship)
    {
        super(ship);
    }
    

    /**
     * Do what a greep's gotta do.
     */
    public void act()
    {
        super.act();   // do not delete! leave as first statement in act().
        
        if (getMemory() == 10 && !carryingTomato())
        {
            return;
        }
        else if (getMemory() == 10 && carryingTomato())
        {
            if (atShip()) 
            {
                dropTomato();
                setMemory(0);
            }
            else if (!atShip())
            {
                turnHome();
                if (atWorldEdge() || atWater())
                    {
                        changeDirection();
                        move();
                     }
                else 
                    {
                        move();
                    }
             }
        }
        else if (getMemory() == 0)
        {  
            if (carryingTomato()) 
            {
                if(atShip()) 
                {
                    dropTomato();
                }
                else if (!atShip())
                {
                    turnHome();
                    if (atWorldEdge() || atWater())
                    {
                        changeDirection();
                        move();
                    }
                    else 
                    {
                        move();
                    }
                }
            }
            else 
            {
                move();
                changeDirection();
                checkFood();
            }
        }
    }

    /**
     * Is there any food here where we are? If so, try to load some!
     */
    public void checkFood()
    {
        // check whether there's a tomato pile here
        TomatoPile tomatoes = (TomatoPile) getOneIntersectingObject(TomatoPile.class);
        if(tomatoes != null) 
        {
            waitForGreep();
            loadTomato();
            
            
            // Note: this attempts to load a tomato onto *another* Greep. It won't
            // do anything if we are alone here.
            
        }
       
    }


    /**
     * This method specifies the name of the author (for display on the result board).
     */
    public static String getAuthorName()
    {
        return "Anonymous";  // write your name here!
    }


    /**
     * This method specifies the image we want displayed at any time. (No need 
     * to change this for the competition.)
     */
    public String getCurrentImage()
    {
        if(carryingTomato())
            return "greep-with-food.png";
        else
            return "greep.png";
    }
    
    /**
     * If at world's edge or water's edge, turn 135 degrees to the right.
     */
    
    public void changeDirection()
    {  
         if (atWorldEdge() || atWater())
         {
              turn(135);  
         }
    }
    
    public void waitForGreep()
    {
          List<Greep> greeps = getObjectsInRange(20, Greep.class);
          if (!isTouching(Greep.class))
          {
              setMemory(10);
          }
    }
    
}