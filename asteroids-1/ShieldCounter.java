import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)


import java.awt.Graphics;

/**
 * Counter that time until shield is ready.
 * 
 */
public class ShieldCounter extends Actor
{
    public GreenfootImage shieldGauge;
    
    public ShieldCounter()
    {   
        shieldGauge = new GreenfootImage (30, 30);
        shieldGauge.setColor(Color.GREEN);
        shieldGauge.drawOval(0, 0, 25, 25);
        shieldGauge.fillOval(0, 0, 25, 25);
        this.setImage(shieldGauge);
    }
    
    public void act() 
    {
         
    }

    /**
     * Make the image
     */
    public void showImage()
    {
        getImage().setTransparency(255);
    }
    
    public void hideImage()
    {
        getImage().setTransparency(0);
    }
}