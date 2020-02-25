import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class Key extends Actor
{
    private boolean isDown;
    private String key;
    private String sound;
    private String upImage;
    private String downImage;

    /**
     * Create a new key.
     */
    public Key(String keyName, String soundFile, String img1, String img2)
    {
        key = keyName;
        sound = soundFile;
        upImage= img1;
        downImage = img2;
        setImage(upImage);
        isDown = false;
    }

    /**
     * Do the action for this key.
     */
    public void act()
    {
        if ( !isDown && Greenfoot.isKeyDown(key) ) {
            setImage (downImage);
            isDown = true;
        }
        if ( isDown && !Greenfoot.isKeyDown(key) ) {
            setImage (upImage);
            play();
            isDown = false;
        }
    }
    
    public void play() 
    {
        Greenfoot.playSound(sound);
    }  
}