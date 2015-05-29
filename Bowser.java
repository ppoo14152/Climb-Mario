import greenfoot.*;

/**
 * Write a description of class Bowser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bowser extends Actor
{
    GreenfootSound marioDies = new GreenfootSound("marioDies.mp3");
    private World levelMusic;
    private int verticalSpeed = 0;
    private int exel = 2;
    private int jump = -30;
    private int floor=528;
    private int counter;    
    private int marioLives;
    private Mario mario;
    private int counterShot;
    private int shootOrNot;
    private int gameOver;
    
    /**
     * Act - do whatever the Bowser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        initializeMario();
        move();
        bowserHitsMario();
        checkFall();    
    }    
    
    private void move()
    {
        counter++;
        counterShot++;
        if (counter >= 50) 
        { 
            if(onGround())
            {
                verticalSpeed = jump; 
                fall();                
            }
            counter=0;
        }
        if(counterShot >= 13)
        {
           shootOrNot = Greenfoot.getRandomNumber(5);
           if(shootOrNot==0 || shootOrNot==2 || shootOrNot==4)
                getWorld().addObject(new bowserShot(), getX()-40, getY());
           counterShot=0;
        }
        
    }
    
    private void fall()  
    {  
        setLocation (getX(), getY() + verticalSpeed);
        verticalSpeed = verticalSpeed + exel;  
    }
    
    private boolean onGround()  
    {  
        if(getY()>=floor)
            return true;
        else
            return false;
    }
    
    private void checkFall()  
    {  
        if(onGround()) 
            verticalSpeed=0;
        else
            fall();
  
    }  
    
    public void bowserHitsMario()
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
}
