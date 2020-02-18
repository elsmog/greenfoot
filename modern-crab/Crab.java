import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Crab extends Actor
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    private int wormsEaten;
    private int movesMade;
    
    public Crab()
    {
        image1 = new GreenfootImage("crab.png");
        image2 = new GreenfootImage("crab2.png");
        setImage(image1);
        wormsEaten = 0;
        movesMade = 0;
    }
   
    /**
     * Act - do whatever the Crab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       moveAndTurn();
       eat();
       switchImage();
       movesMade = movesMade + 1;
    }    
        
    public void moveAndTurn()
    {
       move(4); 
       
       if (Greenfoot.isKeyDown("left"))
       {
           turn(-3);
       }
       if (Greenfoot.isKeyDown("right"))
       {
           turn(3);
        }
    }
    
    public void eat()
    {
       Actor worm;
       worm = getOneObjectAtOffset(0, 0, Worm.class);
       if (worm != null)
       {
        World world;
        world = getWorld();
        world.removeObject(worm);
        Greenfoot.playSound("eating.wav");
        wormsEaten = wormsEaten + 1;
       }
       if (wormsEaten == 8)
       {
        Greenfoot.playSound("fanfare.wav");
        Greenfoot.stop();
        }
    }    
    
    public void switchImage()
    {
       if (movesMade == 4 )
       {
         if (getImage() == image1 )
          {
             setImage(image2);
          }
         else
          {
             setImage(image1);
          }
         movesMade = 0;
       }
       
    }
}