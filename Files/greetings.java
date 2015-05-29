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
    
     /**
     * En el Método "Act" espera a que se presione Enter para salir de la pantalla de "Greetings"
     * 
     */
    public void act()
    {
        backgroundMusic.play();
        if(Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new Nivel01());
            backgroundMusic.stop();
        }
    }
    
     /**
     * Con este método se regresa la canción que se toca en esta pantalla
     * 
     */
    public GreenfootSound getSong()
    {
        return(backgroundMusic);
    }
}
