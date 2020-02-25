import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * A 'Body' is any kind of object in space that has a mass. It could be a star, or a planet, 
 * or anything else that floats around in space.
 * 
 * @author Michael Kolling 
 * @version 0.1
 */
public class Body extends SmoothMover
{
    // constants
    private static final double GRAVITY = 5.8;
    private static final Color defaultColor = new Color(255, 216, 0);
    
    // fields
    private double mass;
    
    /**
     * Construct a Body with default size, mass, movement and color.
     */
    public Body()
    {
        this (20, 300, new Vector(180, 1.0), defaultColor);
    }
    
    /**
     * Construct a Body with a specified size, mass, movement and color.
     */
    public Body(int size, double mass, Vector movement, Color color)
    {
        this.mass = mass;
        addForce(movement);
        GreenfootImage image = new GreenfootImage (size, size);
        image.setColor (color);
        image.fillOval (0, 0, size-1, size-1);
        setImage (image);
    }
    
    /**
     * Act. That is: apply  the gravitation forces from
     * all other bodies around, and then move.
     */
    public void act() 
    {
        applyForces();
        move();
    }
    /**
     * Apply the forces of gravity from all other celestial bodies 
     * in this universe.
     */
    private void applyForces()
    {
        List<Body> bodies = getWorld().getObjects(Body.class);
        for(Body body : bodies) 
        {
            if (body != this)
            {
                applyGravity(body);
            }
        }
    }
    
    /**
     * Apply the gravity force of a give body to this one.
     */
    private void applyGravity(Body other)
    {
        double dx = other.getExactX() - this.getExactX();
        double dy = other.getExactY() - this.getExactY();
        Vector force = new Vector (dx, dy);
        double distance = Math.sqrt (dx * dx + dy * dy);
        double strength = GRAVITY * this.mass * other.mass / 
                          (distance * distance);
        double acceleration = strength / this.mass;
        force.setLength (acceleration);
        addForce (force);
    }
    /**
     * Return the mass of this body.
     */
    public double getMass()
    {
        return mass;
    }
}
