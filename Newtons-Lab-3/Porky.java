import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Porky here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Porky extends Actor
{
    private GreenfootImage porkyImage;
    private boolean touched = false;
    private boolean porkyOn = false;
    private int timeToPlaySound;
    private int timeToBlink = 40;
    
    
    public Porky()
    {
       porkyImage =  new GreenfootImage("pig.png");
       setImage(porkyImage);
    }
    
    /**
     * Act - do whatever the Porky wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        GreenfootSound oink = new GreenfootSound("snort.wav");
        
        boolean isTouchingBody = isTouching(Body.class);
        if (touched && !isTouchingBody)   // not touched anymore
        { 
            touched = false;
        }
        else if (!touched && isTouchingBody)   // just being touched now
        {
            touched = true;
            porkyOn = true;
        }
        if (porkyOn)
        {
            if (timeToPlaySound < 1) 
            {
                oink.play();
                timeToPlaySound = 300;
            }
            else 
            {
                timeToPlaySound--; 
            }
            if (timeToBlink < 1)
            {
               porkyImage.setTransparency(0);
               timeToBlink = 100;
            }
            else
            {
                timeToBlink--;
            }
        } 
        else if (!porkyOn)
        {
            oink.stop();
        }
    }    
}
