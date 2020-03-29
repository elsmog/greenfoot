import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shield here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shield extends Actor
{
    public GreenfootImage shield;
    
    public int shieldDelayCount = 0;
    public int shieldReloadTime = 20;
    
    public Shield()
    {
        shield = new GreenfootImage (60, 60);
        shield.setColor(Color.RED);
        shield.drawOval(0, 0, 55, 55);
        shield.fillOval(0, 0, 55, 55);
        shield.setTransparency(30);
        this.setImage(shield);
    }
   
    public void act() 
    {
        //checkIfShieldEngaged();
    }   
    
}
