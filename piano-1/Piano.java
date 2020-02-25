import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A piano that can be played with the computer keyboard.
 * 
 * @author: M. Kolling
 * @version: 0.1
 */
public class Piano extends World
{
    private String[] whiteKeys = 
        {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "[", "]"};
    private String[] whiteNotes = 
        {"2c", "2d", "2e", "2f", "2g", "3a", "3b", "3c", "3d", "3e", "3f", "3g"};
    private String [] blackKeys = 
        {"2", "3", "", "5", "6", "7", "", "9", "0", "", "="};
    private String [] blackNotes = 
        {"2c#", "2d#", "", "2f#", "2g#", "3a#", "", "3c#", "3d#", "", "3f#"};
        /**
     * Make the piano.
     */
    public Piano() 
    {
        super(800, 340, 1);
        makeKeys();
    }
    
    /**
     * Makes white keys for piano.
     */
    private void makeKeys() 
    {
        for (int i = 0; i < whiteKeys.length; i++) {
            Key key = new Key(whiteKeys[i], whiteNotes[i] + ".wav", "white-key.png", "white-key-down.png");
            addObject(key, i*63 + 50, 140);
        }
        
        for (int i= 0; i < blackKeys.length; i++) {
            if (!blackKeys[i].equals("") ) {
              Key key = new Key(blackKeys[i], blackNotes[i] + ".wav", "black-key.png", "black-key-down.png" );
              addObject(key, i*63 + 80, 80);
            }
        }
    }
}