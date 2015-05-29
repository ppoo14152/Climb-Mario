import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;

/**
 * Write a description of class LifeCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LifeCounter extends Actor
{
    private Mario mario;
    private int marioLives;
    
     /**
     * Constructor de la clase LifeCounter en la cual dibujamos la cara y el número de vidas restantes
     * 
     */
    public LifeCounter()
    {
        GreenfootImage lifeSign = new GreenfootImage(100,40); 
        GreenfootImage marioFace = super.getImage();
        
       // marioFace.scale(80,30);
        
        Font myFont = new Font("Calibri", Font.BOLD,30); 
        lifeSign.setFont(myFont); 
        
        lifeSign.setColor(Color.black); 
        lifeSign.drawString("  X ",20, 24);
        
        lifeSign.drawImage(marioFace, 0, 0);
        setImage(lifeSign);
  
    }
   
     /**
     * En el método "Act" revisamos en que mundo estamos y actualizamos las vidas restantes
     * 
     */
    public void act() 
    {
      
        if(getWorld() instanceof Nivel01)
                marioLives=Nivel01.getLives();
        if(getWorld() instanceof Nivel02)
                marioLives=Nivel02.getLives();
        if(getWorld() instanceof Nivel03)
                marioLives=Nivel03.getLives();  
        update();
    }
    
     /**
     * En el método actualizamos el número de vidas restantes.
     * 
     */
    private void update()
    {
        GreenfootImage lifeSign = new GreenfootImage(100,40); 
        GreenfootImage marioFace = super.getImage();
        
       // marioFace.scale(80,30);
        
        Font myFont = new Font("Calibri", Font.BOLD,30); 
        lifeSign.setFont(myFont); 
        
        lifeSign.setColor(Color.black); 
        lifeSign.drawString("  X "+marioLives,20, 24);
        
        lifeSign.drawImage(marioFace, 0, 0);
        setImage(lifeSign);
    }
    
}
