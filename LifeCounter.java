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
   
    public void act() 
    {
        initializeMario();
        if(getWorld() instanceof Nivel01)
                marioLives=Nivel01.getLives();
        if(getWorld() instanceof Nivel02)
                marioLives=Nivel02.getLives();
        if(getWorld() instanceof Nivel03)
                marioLives=Nivel03.getLives();  
        update();
    }
    
    private void initializeMario()
    {
        if(mario == null)  
        {  
            if(!getWorld().getObjects(Mario.class).isEmpty())  
            {  
                mario = (Mario) getWorld().getObjects(Mario.class).get(0);
            }  
        }
    }
    
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
