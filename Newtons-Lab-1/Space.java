import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Space. The final frontier. 
 * 
 * @author Michael Kolling
 * @version 1.0
 */
public class Space extends World
{

    /**
     * Create space.
     */
    public Space()
    {    
        super(960, 620, 1);
        
        // Uncomment one of the following method calls if you want the objects created automatically:
        
        //sunAndPlanet();
        sunAndTwoPlanets();
        //sunPlanetMoon();
        //sunTwoPlanetsTwoMoons();
    }
    
    /**
     * Set up the universe with a sun and a planet.
     */
    public void sunAndPlanet()
    {
        removeAllObjects();
        addObject (new Body (50, 240.0, new Vector(270, 0.03), new Color(255, 216, 0)), 460, 270);
        addObject (new Body (20, 4.2, new Vector(90, 2.2), new Color(0, 124, 196)), 695, 260);
    }

    /**
     * Set up the universe with a sun and two planets.
     */
    public void sunAndTwoPlanets()
    {
        removeAllObjects();
        addObject (new Body (50, 240.0, new Vector(270, 0.0), new Color(255, 216, 0)), 460, 310);
        addObject (new Body (20, 4.2, new Vector(90, 2.2), new Color(0, 124, 196)), 695, 300);
        addObject (new Body (24, 4.6, new Vector(270, 1.8), new Color(248, 160, 86)), 180, 290);
    }

    /**
     * Set up the universe with a sun, a planet, and a moon.
     */
    public void sunPlanetMoon()
    {
        removeAllObjects();
        addObject (new Body (50, 240.0, new Vector(270, 0.0), new Color(255, 216, 0)), 460, 270);
        addObject (new Body (20, 10.2, new Vector(90, 1.2), new Color(0, 124, 196)), 720, 260);
        addObject (new Body (5, 1.8, new Vector(90, 3.25), new Color(240, 220, 96)), 748, 260);
    }

    public void sunTwoPlanetsTwoMoons()
    {
        removeAllObjects();
        addObject (new Body (50, 240.0, new Vector(270, 0.0), new Color(255, 216, 0)), 460, 310);
        addObject (new Body (20, 4.2, new Vector(90, 2.2), new Color(0, 124, 196)), 695, 300);
        addObject (new Body (24, 4.6, new Vector(270, 1.8), new Color(248, 160, 86)), 180, 290);
        addObject (new Body (5, 2.1, new Vector(90, 3.25), new Color(140, 220, 96)), 683, 260);
        addObject (new Body (5, 2.3, new Vector(270, 2.85), new Color(240, 120, 96)), 195, 260);
    }
    /**
     * Remove all objects currently in the world.
     */
    private void removeAllObjects()
    {
        removeObjects (getObjects(Actor.class));
    }

}
