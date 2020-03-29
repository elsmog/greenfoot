import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.List;

/**
 * Space. Something for rockets to fly in.
 * 
 * @author Michael Kolling
 * @version 1.0
 */
public class Space extends World
{
    public Counter scoreCounter;
    public LevelCounter levelCounter;
    public ProtonCounter protonCounter;
    private int startAsteroids = 2;
    private int points;
    private int level;
    //public int gameScore = 0;
    public int gameLevel = 1;

    public Space() 
    {
        super(600, 400, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        
        createStars(300);
        
        Rocket rocket = new Rocket();
        addObject(rocket, getWidth()/2 - 100, getHeight()/2);
        
        addAsteroids(startAsteroids);
        
        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 580, 380);
        
        levelCounter = new LevelCounter("Level ");
        addObject(levelCounter, 300, 380);
        
        protonCounter = new ProtonCounter();
        addObject(protonCounter, 20, 380);

        Explosion.initializeImages();
        ProtonWave.initializeImages();
       
    }
    
    /**
     * Add a given number of asteroids to our world. Asteroids are only added into
     * the left half of the world.
     */
    private void addAsteroids(int count) 
    {
        for(int i = 0; i < count; i++)
        {
            int x = Greenfoot.getRandomNumber(getWidth()/2);
            int y = Greenfoot.getRandomNumber(getHeight()/2);
            addObject(new Asteroid(), x, y);
        }
    }
    
    /**
     * This method is called when the game is over to display the final score.
     */
    public void gameOver() 
    {
        addObject(new ScoreBoard(scoreCounter.getGameScore()), getWidth()/2, getHeight()/2);
    }

    /**
     * This method will paint stars, determined by the parameter "number", 
     * on the background of the world.
     */
    public void createStars(int number)
    {
        GreenfootImage background = getBackground();
        for (int i = 0; i < number; i++)
        {
            int colorNumber = Greenfoot.getRandomNumber(255);
            Color starColor = new Color (colorNumber, colorNumber, colorNumber);
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight()); 
            background.setColor(starColor);
            background.fillOval(x, y, 2, 2);
        }
    }
    /**
     * Add score to Counter using points deternmined by asteroid size
     * (See Asteroid class method breakUp())
     */
    public void countScore(int points)
    {
        
        scoreCounter.add(points);
        
    }
    
    public void newLevel()
    {
        if (getObjects(Asteroid.class).isEmpty())
            {
                Greenfoot.playSound("fanfare.wav");
                addAsteroids(startAsteroids + gameLevel);
                gameLevel++;
                levelCounter.updateLevel();
            }
    }
    
    public int getLevel()
    {
        return gameLevel;
    }
    
}