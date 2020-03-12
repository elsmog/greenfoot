import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)


import java.util.Calendar;

/**
 * The ScoreBoard is used to display results on the screen. It can display some
 * text and several numbers.
 * 
 * @author M Kolling
 * @version 1.0
 */
public class ScoreBoard extends Actor
{
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    
    public ScoreBoard()
    {
        
        this(100);
    }
    
    public ScoreBoard(int score)
    {
        Counter counter = new Counter();
        counter.getGameScore();
        makeImage("Blast!", "Final Score:", counter.gameScore);
    }
    /**
     * Make the score board image.
     */
    public void makeImage(String title, String prefix, int score)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        image.setColor(new Color(200, 0, 0, 128));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(0, 0, 200, 128));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(70f);
        image.setFont(font);
        image.setColor(Color.GREEN);
        image.drawString(title, 110, 130);
        font = font.deriveFont(22.0f);
        image.setFont(font);
        image.drawString(prefix + score, 120, 220);
        setImage(image);
    }
}
