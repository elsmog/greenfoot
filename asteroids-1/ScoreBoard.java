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
    public static final int WIDTH = 300;
    public static final int HEIGHT = 250;
    private int worldWidth;
    private int worldHeight;
    
    /**
     * Create a score board with dummy result for testing.
     */
    public ScoreBoard()
    {
        this(100);
    }

    /**
     * Create a score board for the final result.
     */
    public ScoreBoard(int score)
    {
        makeImage("Blast!", "Final Score: ", score);
    }

    /**
     * Make the score board image.
     */
    private void makeImage(String title, String prefix, int score)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        //Space space = (Space) getWorld();
        //worldWidth = space.getWidth();
        //worldHeight = space.getHeight();
        image.setColor(new Color(100,100,100, 128));
        image.fillRect(200, 100, WIDTH, HEIGHT);
        image.setColor(new Color(200, 200, 200, 128));
        image.fillRect(205, 105, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(70f);
        image.setFont(font);
        image.setColor(Color.GREEN);
        image.drawString(title, 62, 100);
        font = font.deriveFont(22.0f);
        image.setFont(font);
        image.drawString(prefix + score, 68, 180);
        setImage(image);
    }
}
