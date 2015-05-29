import greenfoot.*;
import java.awt.Font;
import java.awt.Color;

/**
 * Write a description of class greetings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class greetings extends World
{
    GreenfootSound backgroundMusic = new GreenfootSound("Ending.mp3");
    
    /**
     * Constructor for objects of class greetings.
     * 
     */
    public greetings()
    {    
        super(900,600, 1);  
    }
    
    public void act()
    {
        backgroundMusic.play();
        if(Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new Nivel01());
            backgroundMusic.stop();
        }
    }
    
    public GreenfootSound getSong()
    {
        return(backgroundMusic);
    }
}
