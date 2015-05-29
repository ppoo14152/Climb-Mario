import greenfoot.*;

/**
 * Write a description of class Flag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flag extends Actor
{
    GreenfootSound levelComplete = new GreenfootSound("levelComplete.mp3");
    private Mario mario;
    private World level;
    private World levelMusic;
    private static int marioLives;
    
     /**
     * Constructor de la clase Flagg, se inicaliza la clase Mario en null
     * 
     */
    public Flag()
    {
        mario=null;
    }
    
     /**
     * En el método "Act" inicializamos la posición de mario y validamos si Mario toca la Bandera.
     * 
     */
    public void act() 
    {
        initializeMario();
        marioGetsFlag();
    }
    
     /**
     * En este método se revisa en que mundo estamos para parar la música, se pone la canción de transición 
     * de nivel y dependiendo el nivel en el que estemos se avanza al siguiente.
     */
    public void marioGetsFlag() 
    {
        if(hitMario())
        {
            levelMusic=getWorld();
            if(levelMusic instanceof Nivel01)
                Nivel01.stopSong();
            if(levelMusic instanceof Nivel02)
                Nivel02.stopSong();
            if(levelMusic instanceof Nivel03)
                Nivel03.stopSong();
            levelComplete.play();
            Greenfoot.delay(115);   
            if(getWorld() instanceof Nivel01)
                Greenfoot.setWorld(new Nivel02(marioLives));
            if(getWorld() instanceof Nivel02)
                Greenfoot.setWorld(new Nivel03(marioLives));
            if(getWorld() instanceof Nivel03)
                Greenfoot.setWorld(new greetings());
        }
        
    }
    
      /**
     * Método para inicializar a mario, saber en donde esta y cuantas vidas tiene restantes para pasarlas al siguiente nivel
     * 
     */
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
    
     /**
     * Método para validar si Mario toca la bandera
     * 
     */
     private boolean hitMario()
    {
        return(isTouching(Mario.class));
    }
}
