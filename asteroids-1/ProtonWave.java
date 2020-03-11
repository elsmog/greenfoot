import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.List;
/**
 * A proton wave that expands and destroys things in its path.
 * 
 * @author Michael Kolling
 * @version 0.1
 */
public class ProtonWave extends Actor
{
    /** The damage this wave will deal */
    private static final int DAMAGE = 30;
    
    /** How many images should be used in the animation of the wave */
    private static final int NUMBER_IMAGES= 30;
    
    /** 
     * The images of the wave. This is static so the images are not
     * recreated for every object (improves performance significantly).
     */
    private static GreenfootImage[] images;
    private int imageCount = 0;
    
    /**
     * Create a new proton wave.
     */
    public ProtonWave() 
    {
        initializeImages();
        setImage(images[0]);
        Greenfoot.playSound("proton.wav");
    }
    
    /** 
     * Create the images for expanding the wave. Each loop, the width of the 
     * base image is divided using the number of images (NUMBER_IMAGES)
     * and then used to scale the image up.
     */
    public static void initializeImages() 
    {
        if(images == null) 
        {
            GreenfootImage baseImage = new GreenfootImage("wave.png");
            images = new GreenfootImage[NUMBER_IMAGES];
            
            for (int i = 0; i < NUMBER_IMAGES; i++)
            {
                int size = (i+1) * ( baseImage.getWidth() / NUMBER_IMAGES );
                images[i] = new GreenfootImage(baseImage);
                images[i].scale(size, size);
            }
           
        }
    }
    
    /**
     * Check for collision, and if so, place image into world and grow in size.
     */
    public void act()
    { 
        checkCollision();
        grow();
    }
    /**
     * Grow the proton wave in size (animate).
     */
    private void grow()
    {
        if (imageCount >= NUMBER_IMAGES)
        {
            getWorld().removeObject(this);
        }
        else
        {
            setImage(images[imageCount]);
            imageCount++;
        }
        
    }
    /**
     * Check whether the wave touches and asteroid, and cause damage to the 
     * asteroid if it does.
     *
     */
    private void checkCollision()
    {
        int range = getImage().getWidth() * 1/2;
        List<Asteroid> asteroids = getObjectsInRange (range, Asteroid.class);
        for (Asteroid asteroid : asteroids)
        {
            if (asteroid != null)
            {
                asteroid.hit(DAMAGE);
            }
        }
    }
}
