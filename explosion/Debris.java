import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Debris here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Debris extends SmoothMover
{
    private static final Vector GRAVITY = new Vector(Greenfoot.getRandomNumber(360), 1);
    public Debris()
    {
        int direction = Greenfoot.getRandomNumber(360);
        int speed = Greenfoot.getRandomNumber(10);
        increaseSpeed( new Vector(direction, speed));
        
        GreenfootImage img = getImage();
        int width = Greenfoot.getRandomNumber(10) + 1;
        int height = Greenfoot.getRandomNumber(10) + 1;
        img.scale(width, height);
        
        setRotation (Greenfoot.getRandomNumber(360));
    }
    
    /**
     * Act - do whatever the Debris wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        increaseSpeed(GRAVITY);
        move();
    }    
}
