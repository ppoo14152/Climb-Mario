import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;  

/**
 * Write a description of class KingBoo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KingBoo extends Actor
{
    GreenfootSound marioDies = new GreenfootSound("marioDies.mp3");
    private World levelMusic;
    private Mario mario;
    private final int left=1;
    private final int right=2;
    private int marioDir;
    private int marioX;
    private int marioY;
    private int marioLives;
    private int gameOver;
    
    public KingBoo()
    {
        mario=null;
    }
    
    /**
     * Act - do whatever the KingBoo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        initializeMario();
        chaseMario();  
        kingBooHitsMario();
    }
    
    public void chaseMario()  
    {    
        if(mario != null)  
        {  
            marioX = mario.getX();
            marioY = mario.getY();
            marioDir=mario.getMarioDir();
            
            turnTowards(marioX, marioY);
            mooveKingBoo(marioX);
        }  
    }
    
    private void initializeMario()
    {
        if(mario == null)  
        {  
            if(!getWorld().getObjects(Mario.class).isEmpty())  
            {  
                mario = (Mario) getWorld().getObjects(Mario.class).get(0);
                if(getWorld() instanceof Nivel01)
                    marioLives=Nivel01.getLives();
                if(getWorld() instanceof Nivel02)
                    marioLives=Nivel02.getLives();
                if(getWorld() instanceof Nivel03)
                    marioLives=Nivel03.getLives();  
            }  
        }
    }
    
    private void mooveKingBoo(int Xmario)
    {
        //Moves Mario if hi is not facing KingBoo
        if(Xmario<getX() && marioDir!=right)
            move(1);
        else
            move(0);
        if(Xmario>getX() && marioDir!=left)
            move(1);
        else
            move(0);
           
        //This conditions change KingBoo's image depending on his and Mario's posotion        
        if(Xmario>getX())
            setImage("KingBooIzq.png");
        if(Xmario<getX())
            setImage("KingBooDer.png");
    }
    
    private void kingBooHitsMario()
    {
        //If KingBoo hits mario he looses a life and starts over
        if(hitMario())
        {
            levelMusic=getWorld();
            if(levelMusic instanceof Nivel01)
            {
                Nivel01.stopSong();
                Nivel01.setLives(marioLives--);
                gameOver=Nivel01.getLives();
            }
            if(levelMusic instanceof Nivel02)
            {
                Nivel02.setLives(marioLives--);
                Nivel02.stopSong();
                gameOver=Nivel02.getLives();
            }
            if(levelMusic instanceof Nivel03)
            {
                Nivel03.setLives(marioLives--);
                Nivel03.stopSong();
                gameOver=Nivel03.getLives();
            }
            marioDies.play();
            Greenfoot.delay(50);
            if(gameOver>0)
            {
                if(getWorld() instanceof Nivel01)
                    Greenfoot.setWorld(new Nivel01(marioLives));
                if(getWorld() instanceof Nivel02)
                    Greenfoot.setWorld(new Nivel02(marioLives));
                if(getWorld() instanceof Nivel03)
                    Greenfoot.setWorld(new Nivel03(marioLives));
            }
            else
                Greenfoot.setWorld(new gameOver());
        }
    }
        
    private boolean hitMario()
    {
        return(isTouching(Mario.class));
    }
}  
        
    


