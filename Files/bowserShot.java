import greenfoot.*;

/**
 * Write a description of class bowserShot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bowserShot extends Actor
{
    GreenfootSound marioDies = new GreenfootSound("marioDies.mp3");
    private World levelMusic;
    private int X;
    private int Y;
    private int speed=5;
    private Mario mario;
    private int marioLives;
    private int gameOver;
    
    /**
     * Act - do whatever the bowserShot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       initializeMario();
       fireHitsMario();
       move();
    }    
    
    public void move()
    {
        setLocation(getX()-speed, getY());
        if(getX()<=10)
            getWorld().removeObject(this);
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
    
    private boolean hitMario()
    {
      return(isTouching(Mario.class));
    }
    
    public void fireHitsMario()
    {
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
}

