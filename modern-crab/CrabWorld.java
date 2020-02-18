import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the world for the modern crab scenario.
 * 
 * @elyssaKober
 * @2/18/20
 */
public class CrabWorld extends World
{

    /**
     * Constructor for objects of class CrabWorld.
     * 
     */
    public CrabWorld()
    {    
        super(560, 560, 1); 
        populateWorld();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void populateWorld()
    {
        addObject( new Crab(), 150, 100 );
        addObject( new Lobster(), 450, 475 );
        addObject( new Lobster(), 350, 100 );
        addObject( new Lobster(), 100, 300 );
        addObject( new Worm(), greenfoot.Greenfoot.getRandomNumber(550), greenfoot.Greenfoot.getRandomNumber(550) );
        addObject( new Worm(), greenfoot.Greenfoot.getRandomNumber(550), greenfoot.Greenfoot.getRandomNumber(550) );
        addObject( new Worm(), greenfoot.Greenfoot.getRandomNumber(550), greenfoot.Greenfoot.getRandomNumber(550) );
        addObject( new Worm(), greenfoot.Greenfoot.getRandomNumber(550), greenfoot.Greenfoot.getRandomNumber(550) );
        addObject( new Worm(), greenfoot.Greenfoot.getRandomNumber(550), greenfoot.Greenfoot.getRandomNumber(550) );
        addObject( new Worm(), greenfoot.Greenfoot.getRandomNumber(550), greenfoot.Greenfoot.getRandomNumber(550) );
        addObject( new Worm(), greenfoot.Greenfoot.getRandomNumber(550), greenfoot.Greenfoot.getRandomNumber(550) );
        addObject( new Worm(), greenfoot.Greenfoot.getRandomNumber(550), greenfoot.Greenfoot.getRandomNumber(550) );
        addObject( new Worm(), greenfoot.Greenfoot.getRandomNumber(550), greenfoot.Greenfoot.getRandomNumber(550) );
        addObject( new Worm(), greenfoot.Greenfoot.getRandomNumber(550), greenfoot.Greenfoot.getRandomNumber(550) );
    }
}
