import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)


import java.awt.Graphics;

/**
 * Counter that time until ProtonWave is ready.
 * 
 */
public class ProtonWaveCounter extends Actor
{
    public GreenfootImage protonWaveGauge;
    
    public ProtonWaveCounter()
    {   
        protonWaveGauge = new GreenfootImage (30, 30);
        protonWaveGauge.setColor(Color.CYAN);
        protonWaveGauge.drawOval(0, 0, 25, 25);
        protonWaveGauge.fillOval(0, 0, 25, 25);
        this.setImage(protonWaveGauge);
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
