import greenfoot.*;

/**
 * Write a description of class Nivel03 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel03 extends World
{
    static GreenfootSound backgroundMusic = new GreenfootSound("Level3.mp3");
    private final int movingBrick = 2;
    private final int stillBrick = 1;
    private final int left = 1;
    private final int right = 2;
    private final int floor = 548;
    private static int marioLives;

    /**
     * Constructor for objects of class Nivel03.
     * 
     */
    public Nivel03(int lives)
    {        
        super(900,600, 1);
        putBricks();
        putEnemys();
        putOthers();
        marioLives=lives;
        Greenfoot.setSpeed(40);
    }
    
    public void act()
    {
        backgroundMusic.play();
    }
    
    public void putBricks()
    {
        addObject(new trippleBrick(stillBrick, 0, 0), 600,400);
        addObject(new trippleBrick(stillBrick, 0, 0), 120,520);
        addObject(new trippleBrick(stillBrick, 0, 0), 260,520);
        addObject(new trippleBrick(stillBrick, 0, 0), 400,520);
        addObject(new trippleBrick(stillBrick, 0, 0), 720,420);
        addObject(new trippleBrick(stillBrick, 0, 0), 820,500);
        addObject(new doubleBrick(stillBrick, 0, 0), 180,440);
        addObject(new doubleBrick(stillBrick, 0, 0), 300,410);
        addObject(new Brick(stillBrick, 0, 0), 410,410);
        addObject(new Brick(stillBrick, 0, 0), 490,410);
       
    }
    
    public void putEnemys()
    {
        addObject(new Bowser(), 700, floor-18);
    }
    
    public void putOthers()
    {
        addObject(new Mario(floor), 50, floor);
        addObject(new LifeCounter(), 830, 30);
        addObject(new Flag(), 830, 460);
    }
    
    public static void stopSong()
    {
        backgroundMusic.stop();
    }
    
    public static int getLives()
    {
        return(marioLives);
    }
    
    public static void setLives(int lives)
    {
        marioLives=lives;
    }  
}