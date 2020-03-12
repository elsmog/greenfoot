import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)


import java.awt.Graphics;

/**
 * Counter that time until ProtonWave is ready.
 * 
 */
public class ProtonCounter extends Actor
{
    private GreenfootImage protonReady = new GreenfootImage ("blue-draught.png");
    
    public void act() 
    {
        
    }

    /**
     * Make the image
     */
    public void showImage()
    {
        GreenfootImage protonReady = getImage();
    }
    
    public void hideImage()
    {
        protonReady.setTransparency(0);
    }
}
