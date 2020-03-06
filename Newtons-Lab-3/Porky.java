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
    private int timeToFade;
    
    public Porky()
    {
       porkyImage =  new GreenfootImage("pig.png");
       setImage(porkyImage);
       porkyImage.setTransparency(255);
    }
    
    /**
     * Act - do whatever the Porky wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        GreenfootSound oink = new GreenfootSound("oinky.wav");
        int transparency = porkyImage.getTransparency();
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
        else if (touched && isTouchingBody) // being touched again
        {
            touched = false;
            porkyOn = false;
        }
        
        if (porkyOn)
        {
            if (timeToPlaySound < 1) 
            {
                oink.play();
                timeToPlaySound = 100;
            }
            else 
            {
                timeToPlaySound--; 
            }
            if (timeToFade <1 && transparency == 255)
            {
                porkyImage.setTransparency(1);
                transparency = porkyImage.getTransparency();
                timeToFade = 40;
            }
            else if (timeToFade <1 && transparency == 1)
            {
                porkyImage.setTransparency(255);
                transparency = porkyImage.getTransparency();
                timeToFade = 40;
            }
            else if (timeToFade >= 1)
            {
                timeToFade--;
            }
        } 
        
        else if (!porkyOn)
        {
            oink.stop();
            porkyImage.setTransparency(255);
        }
    }    
}
