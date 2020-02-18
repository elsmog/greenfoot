import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Worm worm = new Worm();
        addObject(worm,324,77);
        Worm worm2 = new Worm();
        addObject(worm2,156,288);
        Worm worm3 = new Worm();
        addObject(worm3,351,453);
        Worm worm4 = new Worm();
        addObject(worm4,97,488);
        Worm worm5 = new Worm();
        addObject(worm5,442,265);
        Crab crab = new Crab();
        addObject(crab,111,150);
    }
}
