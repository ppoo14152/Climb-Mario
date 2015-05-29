import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goomba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goomba extends Actor
{
    GreenfootSound marioDies = new GreenfootSound("marioDies.mp3");
    private World levelMusic;
    private int dir;
    private Mario mario;
    private int marioLives;
    private int gameOver;
    
    
    public Goomba(int direccion)
    {
        mario=null;
        dir=direccion;
    }
    
    /**
     * Act - do whatever the Goomba wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        initializeMario();
        moveGoomba();
        goombaHitsMario();
    }    
    
    public void goombaHitsMario()
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
    
    private void moveGoomba()
    {
        int x;
        x=getX();
        
        if(x>=898 || checkBricksOnRight())
            dir=-1;            

        if(x<=1 || checkBricksOnLeft())
            dir=1;  
            
        move(dir);
    }
    
    private boolean hitMario()
    {
        return(isTouching(Mario.class));
    }
    
    private boolean checkBricksOnRight()
    {
        if((getOneObjectAtOffset(0,30,Brick.class)!=null && getOneObjectAtOffset(5,30,Brick.class)==null) ||
        (getOneObjectAtOffset(0,30,doubleBrick.class)!=null && getOneObjectAtOffset(5,30,doubleBrick.class)==null) ||
        (getOneObjectAtOffset(0,30,trippleBrick.class)!=null && getOneObjectAtOffset(5,30,trippleBrick.class)==null) ||
        (getOneObjectAtOffset(0,30,quadraBrick.class)!=null && getOneObjectAtOffset(5,30,quadraBrick.class)==null))
            return true;
        else
            return false;
    }
    
    private boolean checkBricksOnLeft()
    
    {
        if((getOneObjectAtOffset(0,30,Brick.class)!=null && getOneObjectAtOffset(-5,30,Brick.class)==null) ||
        (getOneObjectAtOffset(0,30,doubleBrick.class)!=null && getOneObjectAtOffset(-5,30,doubleBrick.class)==null) ||
        (getOneObjectAtOffset(0,30,trippleBrick.class)!=null && getOneObjectAtOffset(-5,30,trippleBrick.class)==null) ||
        (getOneObjectAtOffset(0,30,quadraBrick.class)!=null && getOneObjectAtOffset(-5,30,quadraBrick.class)==null))
            return true;
        else
            return false;
    }
}
