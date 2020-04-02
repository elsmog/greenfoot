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
    private static final int protonWaveReloadTime = 500; // The minimum delay between firing the proton wave.
    private static final int shieldReloadTime = 600;     // The minimum delay between deploying the shield.
    
    public int reloadDelayCount;               // How long ago we fired the gun the last time.
    public int protonWaveDelayCount; // How long ago we fired the proton wave.
    public int shieldDelayCount;     // How long ago we deployed the shield.
    
    public int shieldDuration = 200;  //How long the shield lasts.
   
    
    private GreenfootImage rocket = new GreenfootImage("rocket.png");    
    private GreenfootImage rocketWithThrust = new GreenfootImage("rocketWithThrust.png");
    private GreenfootImage rocketWithShield = new GreenfootImage("rocket-with-shield.png");
    private GreenfootImage rocketWithThrustAndShield = new GreenfootImage("rocket-thrust-shield.png");
    
    private boolean boosterOn = false;
    
    public boolean shieldActive = false;
    
    public GreenfootImage rocketImage = getImage();
    
    private static final int NUMBER_FRAGMENTS = 15;
    
    
    
    /**
     * Initilise this rocket.
     */
    public Rocket()
    {
        reloadDelayCount = 5;
        protonWaveDelayCount = 500;
        shieldDelayCount = 700;
        addForce(new Vector(0, 0.3));
    }

    /**
     * Do what a rocket's gotta do. (Which is: mostly flying about, and turning,
     * accelerating and shooting when the right keys are pressed.)
     */
    public void act()
    {
        Space space = (Space) getWorld();
        move();
        updateRocketImage();
        updateProtonWaveStatus();
        updateShieldStatus();
        checkKeys();
        checkCollision();
        reloadDelayCount++;
        protonWaveDelayCount++;
        shieldDelayCount++;
        space.newLevel();
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
        
        if (Greenfoot.isKeyDown("z"))
        {
            startProtonWave();
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
            addForce(new Vector (getRotation(), 0.1));
        }
        
        else if (!Greenfoot.isKeyDown("up"))
        {
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
        
        if (intersectingAsteroid != null && shieldActive == true)
        {
         // the asteroids do nothing to the rocket
        }
         
        if (intersectingAsteroid != null && shieldActive == false)
        {
            Space space = (Space) getWorld();
            explode();
            space.removeObject(this);
            space.gameOver();
        }
    }
    
    /**
     * Animate the rocket's destruction with sound.
     */
    public void explode()
    {
        placeDebris(this.getX(), this.getY(), NUMBER_FRAGMENTS);
        Greenfoot.playSound("MetalExplosion.wav");
    }
    
    /**
     * Place individual pieces of debris that once comprised the rocket's hull.
     */
    private void placeDebris(int x, int y, int numberFragments)
    {
        for (int i = 0; i < numberFragments; i++) 
        {
            getWorld().addObject ( new Debris(), x, y);
        }
    }
    
    /**
     * Place a proton wave into the world at the location of the rocket.
     */
    private void startProtonWave()
    {
        if (protonWaveDelayCount >= protonWaveReloadTime)
        {
            ProtonWave protonWave = new ProtonWave();
            getWorld().addObject (protonWave, getX(), getY());
            protonWaveDelayCount = 0;
        }
    }
    
    /**
     * Update the Proton Wave's gauge. When available, a blue circle appears in
     * the bottom left corner. When unavailable, there is no blue circle.
     */
    public void updateProtonWaveStatus()
    {
        Space space = (Space) getWorld();
        if (protonWaveDelayCount >= 500)
        {
            space.protonWaveCounter.showImage();
        }
        else if (protonWaveDelayCount < 500)
        {   
            space.protonWaveCounter.hideImage();
        }
        
    }
    
    /**
     * Update the Shield's gauge. When available, a green circle appears in the
     * bottom left corner. When unavailable, there is no green circle.
     */
    public void updateShieldStatus()
    {
        Space space = (Space) getWorld();
        if (shieldDelayCount >= 700)
        {
            space.shieldCounter.showImage();
        }
        else if (shieldDelayCount < 700)
        {   
            space.shieldCounter.hideImage();
        }
        
    }
    
    public void updateRocketImage()
    {
     // rocket with thrust
        if (Greenfoot.isKeyDown("up") && shieldActive == false)
        {
            setImage(rocketWithThrust);
        }
        
     // rocket with thrust and shield
        else if (Greenfoot.isKeyDown("up") && shieldActive == true)
        {
            setImage(rocketWithThrustAndShield);
            if (shieldDelayCount >= shieldDuration)
            {
                setImage(rocketWithThrust);
                shieldActive = false;
            }
        }
     
     // rocket with shield
        else if (Greenfoot.isKeyDown("c"))
        {
            if (shieldDelayCount >= shieldReloadTime)
            {
                setImage(rocketWithShield);
                shieldActive = true;
                shieldDelayCount = 0;
                if (shieldDelayCount >= shieldDuration)
                {
                    setImage(rocket);
                    shieldActive = false;
                }
            }
        }
        else if (shieldActive == true && !Greenfoot.isKeyDown("up"))
        {
            setImage(rocketWithShield);
            if (shieldDelayCount >= shieldDuration)
            {
                setImage(rocket);
                shieldActive = false;
            }
        }
     
     
     // rocket
        else 
        {   
            setImage(rocket);
        }
    }
    
}