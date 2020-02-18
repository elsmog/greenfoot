import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lobster extends Actor
{
    public void act()
    {
        moveAround();
        eat();
    }
    public void eat()
    {
        Actor crab = getOneObjectAtOffset(0, 0, Crab.class);
        if (crab != null)
        {
         World world;
         world = getWorld();
         world.removeObject(crab);
         Greenfoot.playSound("yummy.wav");
        }
    }
    public void moveAround()
    {
        move(3);
        if (Greenfoot.getRandomNumber(100) < 10)
        {
        turn(Greenfoot.getRandomNumber(90) - 45);
        }
        if (getX() <= 5 || getX() >= getWorld().getWidth() - 5)
        {
            turn(180);
        }
        if (getY() <= 5 || getY() >= getWorld().getHeight() - 5)
        {
            turn(180);
        }
    }  
}