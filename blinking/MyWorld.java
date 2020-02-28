import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public MyWorld()
    {    
        super(600, 400, 1);
        createBall();
    }
    
    public void createBall()
    {
        addObject (new Ball (), 300, 200);
    }
}
