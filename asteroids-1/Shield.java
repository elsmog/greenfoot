import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shield here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shield extends Actor
{
    /**
     * Act - do whatever the Shield wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int shieldDelayCount = 0;
    public int shieldReloadTime = 20;
    public Shield()
    {
        GreenfootImage shield = new GreenfootImage ("button-green.png");
        shield.setTransparency(30);
        
    }
   
    public void act() 
    {
        //checkIfShieldEngaged();
    }   
    
}
