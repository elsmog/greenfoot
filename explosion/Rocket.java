import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    private static final int NUMBER_FRAGMENTS = 15;
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        String key = Greenfoot.getKey();
        if (key != null)
        {
            explode();
        }
    }   
    
    public void explode()
    {
        placeDebris(getX(), getY(), NUMBER_FRAGMENTS);
        getWorld().removeObject(this);
    }
    
    private void placeDebris(int x, int y, int numberFragments)
    {
        for (int i = 0; i < numberFragments; i++) 
        {
            getWorld().addObject ( new Debris(), x, y);
        }
    }
}
