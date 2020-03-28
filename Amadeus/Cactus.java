import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cactus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cactus extends Actor
{
    
    
    /**
     * Act - do whatever the Cactus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveAround();
    }    
    
    public void moveAround()
    {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if (mouseInfo != null)
        {
            // move randomly
            if (Greenfoot.mouseClicked(this))
            {
                setLocation(Greenfoot.getRandomNumber(400), Greenfoot.getRandomNumber(300));
                Greenfoot.playSound("eating.wav");
            
            }
            
            else if (!Greenfoot.mouseClicked(this))
            {
                int buttonClicked = mouseInfo.getButton();
            
                //move to the right
                if (buttonClicked == 1) 
                {
                    setRotation(0);
                    move(10);
                    Greenfoot.playSound("beebo.wav");
                }
            
                //move to the left
                if (buttonClicked == 3)
                {
                    setRotation(0);
                    move(-10);
                    Greenfoot.playSound("maclunkey.wav");
                }
            }
        }
    }
}
