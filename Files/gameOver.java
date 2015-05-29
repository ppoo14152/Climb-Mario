import greenfoot.*;

/**
 * Write a description of class gameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameOver extends World
{
    GreenfootSound backgroundMusic = new GreenfootSound("gameOver.mp3");
    
    /**
     * Constructor for objects of class greetings.
     * 
     */
    public gameOver()
    {    
        super(900,600, 1);  
        backgroundMusic.play();
    }
    
    public void act()
    {
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