import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Graphics;

/**
 * Level Counter that displays a text and number.
 *
 */
public class LevelCounter extends Actor
{
    private static final Color textColor = new Color(255, 180, 150);
    
    private int gameLevel = 1;
    private int target = 0;
    private String text;
    private int stringLength;
   

    public LevelCounter()
    {
        this("");
    }

    public LevelCounter(String prefix)
    {
        text = prefix;
        stringLength = (text.length() + 2) * 10;

        setImage(new GreenfootImage(stringLength, 16));
        GreenfootImage image = getImage();
        image.setColor(textColor);

        updateImage();
    }
    
    public void act() {
        
        if(gameLevel < target) {
            gameLevel++;
            updateImage();
        }
        /*else if(gameLevel > target) {
            gameLevel--;
            updateImage();
        }*/
    }

    public void add(int level)
    {
        target += level;
    }

    public int getValue()
    {
        return target;
    }

    public void updateLevel()
    {
        gameLevel++;
        updateImage();
    }
    /**
     * Make the image
     */
    public void updateImage()
    {
        
     
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + gameLevel, 1, 12);
    }
}
