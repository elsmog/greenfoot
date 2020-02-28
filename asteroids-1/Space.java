import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)


/**
 * Space. Something for rockets to fly in.
 * 
 * @author Michael Kolling
 * @version 1.0
 */
public class Space extends World
{
    private Counter scoreCounter;
    private int startAsteroids = 3;

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
        addObject(scoreCounter, 60, 380);

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
        // TODO: show the score board here. Currently missing.
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
}