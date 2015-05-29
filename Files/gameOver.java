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
     * Constructor de gameOver
     * 
     */
    public gameOver()
    {    
        super(900,600, 1);  
        backgroundMusic.play();
    }
    
     /**
     * En el Método "Act" espera a que se presione Enter para salir de la pantalla de game Over
     * 
     */
    public void act()
    {
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