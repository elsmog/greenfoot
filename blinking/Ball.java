import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    private GreenfootImage ballImage;
    private boolean ballOn = true;
    private int timeToPlaySound;
    private int timeToFade;
    
    public Ball()
    {
       ballImage =  new GreenfootImage("ball.png");
       setImage(ballImage);
       ballImage.setTransparency(255);
    }
    
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        GreenfootSound oink = new GreenfootSound("oinky.wav");
        int transparency = ballImage.getTransparency();
        
        if (ballOn)
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
                ballImage.setTransparency(1);
                transparency = ballImage.getTransparency();
                timeToFade = 100;
            }
            else if (timeToFade <1 && transparency == 1)
            {
                ballImage.setTransparency(255);
                timeToFade = 100; 
            }
            else if (timeToFade >= 1)
            {
                timeToFade--;
            }
            
        } 
        
        else if (!ballOn)
        {
            oink.stop();
            ballImage.setTransparency(255);
        }
    }    
} 
