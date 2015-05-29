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
     * Constructor de Nivel03, recibe como parámetro las vidas de Mario.
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
    
    /**
     * Coloca todos los ladrillos del juego
     * 
     */
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
    
    /**
     * Coloca a todos los enemigos del nivel 
     * 
     */
    public void putEnemys()
    {
        addObject(new Bowser(), 700, floor-18);
    }
    
     /**
     * Coloca a mario, el contador de vidas y la bandera
     * 
     */
    public void putOthers()
    {
        addObject(new Mario(floor), 50, floor);
        addObject(new LifeCounter(), 830, 30);
        addObject(new Flag(), 830, 460);
    }
    
     /**
     * Método para detener la música en caso de morir o pasar un nivel
     * 
     */
    public static void stopSong()
    {
        backgroundMusic.stop();
    }
    
       /**
     * 
     * Método que regresa cuantas vidas tiene Mario
     */
    public static int getLives()
    {
        return(marioLives);
    }
    
     /**
     * Método para modificar las vidas de mario
     * 
     */
    public static void setLives(int lives)
    {
        marioLives=lives;
    }  
}