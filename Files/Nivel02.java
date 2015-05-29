import greenfoot.*;

/**
 * Write a description of class Nivel02 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel02 extends World
{
    static GreenfootSound backgroundMusic = new GreenfootSound("Level2.mp3");
    private final int movingBrick = 2;
    private final int stillBrick = 1;
    private final int left = 1;
    private final int right = 2;
    private final int floor = 520;
    private static int marioLives;
    private int counter;
    private int X;
    private int Y;
    
    /**
     * Constructor for objects of class Nivel02.
     * 
     */
    public Nivel02(int lives)
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
        backgroundMusic.setVolume(100);
        backgroundMusic.play();
        putBala();
    }
    
    public void putBricks()
    {
        addObject(new trippleBrick(stillBrick, 0, 0), 600,240);
        addObject(new quadraBrick(movingBrick, right, 0), 400, 530);
        addObject(new quadraBrick(stillBrick, 0, 0), 593, 472);
        addObject(new quadraBrick(stillBrick, 0, 0), 710, 472);
        addObject(new Brick(stillBrick, 0, 0), 785, 472);
        addObject(new trippleBrick(stillBrick, 0, 0), 460, 420);
        addObject(new doubleBrick(movingBrick, left, 0), 700, 350);
        addObject(new doubleBrick(stillBrick, 0, 0), 140, 470);
        addObject(new doubleBrick(stillBrick, 0, 0), 250, 470);
        addObject(new Brick(stillBrick, 0, 0), 140, 270);
        addObject(new Brick(stillBrick, 0, 0), 200, 220);
        addObject(new Brick(stillBrick, 0, 0), 270, 220);
        addObject(new Brick(stillBrick, 0, 0), 340, 220);
        addObject(new Brick(stillBrick, 0, 0), 420, 220);
        addObject(new Brick(stillBrick, 0, 0), 490, 220);
        addObject(new quadraBrick(stillBrick, 0, 0), 720, 170);
        addObject(new quadraBrick(stillBrick, 0, 0), 560, 90);
        addObject(new quadraBrick(stillBrick, 0, 0), 440, 90);
        addObject(new quadraBrick(stillBrick, 0, 0), 320, 90);
        addObject(new quadraBrick(stillBrick, 0, 0), 200, 90);
    }
    
    public void putEnemys()
    {
        addObject(new Goomba(1), 300, 530);
        addObject(new Goomba(-1), 700, 530);
        addObject(new Goomba(1), 650, 443);
        addObject(new Goomba(1), 160, 442);
        addObject(new Goomba(1), 250, 442);
        addObject(new Goomba(1), 200, 60);
        addObject(new Goomba(-1), 500, 60);
        //addObject(new KingBoo(), 40, 450);
        addObject(new KingBoo(), 850, 400);
    }
    
    public void putOthers()
    {
        addObject(new Mario(floor), 100, floor);
        addObject(new LifeCounter(), 830, 30);
        addObject(new Flag(), 160, 50);
        //addObject(new Flag(), 130, floor);
    }
    
    public void putBala()
    {
        counter++;
        if (counter >= 70) 
        { 
            int lado = Greenfoot.getRandomNumber(2); //get width of screen
            if(lado==1)
                X = 0;
                
            else
                X = 900;
                
            Y = Greenfoot.getRandomNumber(600); // get height of screen
            addObject(new Bala(lado), X, Y); 
            counter =0;
        }
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
