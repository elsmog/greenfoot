import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Space. The final frontier. 
 * 
 * @author Michael K�lling
 * @version 1.1
 */
public class Space extends World
{
    private String[] soundFiles = { "2c", "eating", "2g", "eating", "2b", "eating", "3d", "eating", "3f", "eating"};
    
    /**
     * Constructor for objects of class Space.
     * 
     */
    public Space()
    {    
        super(960, 620, 1);
        
        createObstacles();
        createPorky();
        randomBodies(10);
    }
    
    public void act()
    {
        newBody();
    }
    /**
     * Create a row of abstacles across the middle of our world.
     */
    public void createObstacles()
    {
        int i = 0;
        while (i < soundFiles.length) {
            addObject (new Obstacle (soundFiles[i] + ".wav"), 50 + i*90, i * 20 + 210);
            i++;
        }
    }
    
    /**
     * Create a given number of bodies in the universe. Each body has a random initial state (size,
     * mass, direction, speed, color, location).
     */
    public void randomBodies(int number)
    {
        while (number > 0) {
            int size = 20 + Greenfoot.getRandomNumber(30);
            double mass = size * 7.0;
            int direction = Greenfoot.getRandomNumber(360);
            double speed = Greenfoot.getRandomNumber(150) / 100.0;
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            int r =  Greenfoot.getRandomNumber(255);
            int g =  Greenfoot.getRandomNumber(255);
            int b =  Greenfoot.getRandomNumber(255);
            addObject (new Body (size, mass, new Vector(direction, speed), new Color(r, g, b)), x, y);
            number--;
        }
    }
    
    public void newBody()
    {   
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (Greenfoot.mouseClicked(null))
        {
            int newX = mouse.getX();
            int newY = mouse.getY();
            int size = 20 + Greenfoot.getRandomNumber(30);
            double mass = size * 7.0;
            int direction = Greenfoot.getRandomNumber(360);
            double speed = Greenfoot.getRandomNumber(150) / 100.0;
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            int r =  Greenfoot.getRandomNumber(255);
            int g =  Greenfoot.getRandomNumber(255);
            int b =  Greenfoot.getRandomNumber(255);
            addObject (new Body (size, mass, new Vector(direction, speed), new Color(r, g, b)), newX, newY);
        }
    }
    
    /**
     * Create a porky that gets switched on by being hit. When on, it continuously
     * blinks and produces a sound at fixed intervals.
     */
    public void createPorky()
    {
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        addObject (new Porky (), x, y);
    }
}
