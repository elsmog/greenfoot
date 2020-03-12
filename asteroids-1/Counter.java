import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)


import java.awt.Graphics;

/**
 * Counter that displays a text and number.
 * 
 * @author Michael Kolling
 * @version 1.0.1
 */
public class Counter extends Actor
{
    private static final Color textColor = new Color(255, 180, 150);
    
    public int gameScore = 0;
    private int target = 0;
    private String text;
    private int stringLength;
   

    public Counter()
    {
        this("");
    }

    public Counter(String prefix)
    {
        text = prefix;
        stringLength = (text.length() + 2) * 10;

        setImage(new GreenfootImage(stringLength, 16));
        GreenfootImage image = getImage();
        image.setColor(textColor);

        updateImage();
    }
    
    public void act() {
        if(gameScore < target) {
            gameScore++;
            updateImage();
        }
        else if(gameScore > target) {
            gameScore--;
            updateImage();
        }
    }

    public void add(int score)
    {
        target += score;
    }

    public int getValue()
    {
        return target;
    }

    /**
     * Make the image
     */
    public void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + gameScore, 1, 12);
    }
    
    
    public int getGameScore()
    {
        return gameScore;
    } 
}
