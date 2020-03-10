import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A rocket that can be controlled by the arrowkeys: up, left, right.
 * The gun is fired by hitting the 'space' key. 'z' releases a proton wave.
 * 
 * @author Poul Henriksen
 * @author Michael Kolling
 * 
 * @version 1.0
 */
public class Rocket extends SmoothMover
{
    private static final int gunReloadTime = 5;         // The minimum delay between firing the gun.
    
    private int reloadDelayCount;               // How long ago we fired the gun the last time.
    
    private GreenfootImage rocket = new GreenfootImage("rocket.png");    
    private GreenfootImage rocketWithThrust = new GreenfootImage("rocketWithThrust.png");

    private boolean boosterOn = false;
    
    private static final int NUMBER_FRAGMENTS = 15;
    
    /**
     * Initilise this rocket.
     */
    public Rocket()
    {
        reloadDelayCount = 5;
        addForce(new Vector(0, 0.3));
    }

    /**
     * Do what a rocket's gotta do. (Which is: mostly flying about, and turning,
     * accelerating and shooting when the right keys are pressed.)
     */
    public void act()
    {
        
        move();
        checkKeys();
        checkCollision();
        reloadDelayCount++;
    }
    
    /**
     * Check whether there are any key pressed and react to them.
     */
    private void checkKeys() 
    {
        ignite(Greenfoot.isKeyDown("up"));
        if (Greenfoot.isKeyDown("space")) 
        {
            fire();
        }

        if (Greenfoot.isKeyDown("left"))
        {
            setRotation(getRotation() - 5);
        }
        
        if (Greenfoot.isKeyDown("right"))
        {
            setRotation(getRotation() + 5);
        }
    }
    
    /**
     * Fire a bullet if the gun is ready.
     */
    private void fire() 
    {
        if (reloadDelayCount >= gunReloadTime) 
        {
            Bullet bullet = new Bullet (getMovement().copy(), getRotation());
            getWorld().addObject (bullet, getX(), getY());
            bullet.move ();
            reloadDelayCount = 0;
        }
    }
    
    /**
     * Change rocket's image to show ignition and move the rocket up or down.
     */
    private void ignite(boolean boosterOn)
    {
        if (Greenfoot.isKeyDown("up"))
        {
            setImage(rocketWithThrust);
            addForce(new Vector (getRotation(), 0.1));
        }
        
        else if (!Greenfoot.isKeyDown("up"))
        {
            setImage(rocket);
            boosterOn = false;
        }
    }
    
    /**
     * Check if the Rocket has collided with an asteroid, and if so, remove 
     * rocket from world and display an explosion. Then display final score.
     */
    private void checkCollision()
    {
        Actor intersectingAsteroid = getOneIntersectingObject(Asteroid.class);
        if (intersectingAsteroid != null)
        {
            Space space = (Space) getWorld();
            explode();
            space.removeObject(this);
            space.gameOver();
        }
    }
    
    public void explode()
    {
        placeDebris(this.getX(), this.getY(), NUMBER_FRAGMENTS);
        Greenfoot.playSound("MetalExplosion.wav");
    }
    
    private void placeDebris(int x, int y, int numberFragments)
    {
        for (int i = 0; i < numberFragments; i++) 
        {
            getWorld().addObject ( new Debris(), x, y);
        }
    }
}