import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;

/**
 * A 'Body' is any kind of object in space that has a mass. It could be a star, or a planet, 
 * or anything else that floats around in space.
 * 
 * @author Michael K�lling 
 * @version 1.1
 */
public class Body extends SmoothMover
{
    private static final double GRAVITY = 3.3;
    private static final Color defaultColor = new Color(255, 216, 0);
    private boolean wasTouchingObstacleLastAction = false;
    
    private double mass;
    
    /**
     * Construct a Body with default size, mass, movement and color.
     */
    public Body()
    {
        this (20, 300, new Vector(0, 0.0), defaultColor);
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
        bounceAtEdge();
        boolean isTouchingObstacleNow = isTouching(Obstacle.class);
        if (!wasTouchingObstacleLastAction && isTouchingObstacleNow) 
        {
            changeToRandomColor();
            wasTouchingObstacleLastAction = true;
        }
        else if (wasTouchingObstacleLastAction && !isTouchingObstacleNow)
        {
            wasTouchingObstacleLastAction = false;
        }
    }
    
    /**
     * Check whether we have hit the edge of the universe. If so, bounce off it.
     */
    private void bounceAtEdge()
    {
        if (getX() == 0 || getX() == getWorld().getWidth()-1) {
            setLocation((double)getX(), (double)getY());
            getMovement().revertHorizontal();
            accelerate(0.9);
            changeToRandomColor();
        }
        else if (getY() == 0 || getY() == getWorld().getHeight()-1) {
            setLocation((double)getX(), (double)getY());
            getMovement().revertVertical();
            accelerate(0.9);
            changeToRandomColor();
        }
    }
    
    /**
     * Apply the forces of gravity from all other celestial bodies in this universe.
     */
    private void applyForces()
    {
        List<Body> bodies = (List<Body>) getWorld().getObjects(Body.class);
        
        for (Body body : bodies) 
        {
            if (body != this) 
            {
                applyGravity (body);
            }
        }
        
        // ensure that we don't get too fast: If the current speed  is very fast, decelerate a bit.
        if (getSpeed() > 6) 
        {
            accelerate (0.5);  // acceleration with factor < 1 is actually slowing down.
        }
    }
    
    /**
     * Apply the gravity force of a given body to this one.
     */
    private void applyGravity(Body other)
    {
        double dx = other.getExactX() - this.getExactX();
        double dy = other.getExactY() - this.getExactY();
        Vector force = new Vector (dx, dy);
        double distance = Math.sqrt (dx*dx + dy*dy);
        double strength = GRAVITY * this.mass * other.mass / (distance * distance);
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
    
    private void changeToRandomColor()
    {
        int r = Greenfoot.getRandomNumber(255);
        int g = Greenfoot.getRandomNumber(255);
        int b = Greenfoot.getRandomNumber(255);
        Color randomColor = new Color(r, g, b);
        GreenfootImage image = getImage();
        image.setColor(randomColor);
        int height = image.getHeight();
        int width = image.getWidth();
        image.fillOval (0, 0, width-1, height-1);
    }
}
