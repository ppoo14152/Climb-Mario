import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mario extends Actor
{
    GreenfootSound marioJump = new GreenfootSound("marioJump.mp3");
    private int speed = 7;
    private int verticalSpeed = 0;
    private int exel = 2;
    private int jump = -16;
    private int floor;
    private final int left=1;
    private final int right=2;
    private int dir=right;
    private int pasos = 1;
    private int duck=0;

   public Mario(int piso)
   {
       pasos = 1;
       floor=piso;
   }
     
    public void act() 
    {
        keyCheck();
        checkFall();
    }
    
    /**
     * Key Check
     */
    private void keyCheck()
    {
        
        if(Greenfoot.isKeyDown("right"))
        {  
            dir=right;
            if(pasos==1)
            {
                setLocation ( getX() + speed, getY() );  
                if(onGround() || onBrick())
                    setImage("MarioGdeDer.png");
                else
                    setImage("MarioGdeDer.png");
            }
            if(pasos==2)
            {
                setLocation( getX() + speed, getY() );
                if(onGround() || onBrick())
                    setImage("MarioGdeDer1.png");  
                else
                    setImage("MarioGdeDer.png");
            }
            if(pasos==3)
            {
                setLocation( getX() + speed, getY() );
                if(onGround() || onBrick())
                    setImage("MarioGdeDer2.png");
                else
                    setImage("MarioGdeDer.png");
            }
            if(pasos>=3)
                pasos=1;
            else
                pasos++;
        }  
          
        if(Greenfoot.isKeyDown("left"))  
        {  
            dir=left; 
            if(pasos==1)
            {
                setLocation ( getX() - speed, getY() );
                if(onGround() || onBrick())
                    setImage("MarioGdeIzq.png");
                else
                    setImage("MarioGdeIzq.png");
            }
            if(pasos==2)
            {
                setLocation( getX() - speed, getY() );
                if(onGround() || onBrick())
                    setImage("MarioGdeIzq1.png");      
                else
                    setImage("MarioGdeIzq.png");
            }
            if(pasos==3)
            {
                setLocation( getX() - speed, getY() );
                if(onGround() || onBrick())
                    setImage("MarioGdeIzq2.png");
                else
                    setImage("MarioGdeIzq.png");
            }
            if(pasos>=3)
                pasos=1;
            else
                pasos++;
        }  
          
        if(Greenfoot.isKeyDown("up"))  
        {  
            if(onGround() || onBrick())
            {
                marioJump.play();
                verticalSpeed = jump; 
                fall();           
                //marioJump.stop();
            }
        }
        
        
        if(Greenfoot.isKeyDown("down"))
        {
            if(onGround() || onBrick())
            {
                if(dir==right && duck==0)
                {
                    setLocation(getX(), getY()+10);
                    setImage("MarioAgachadoDer.png");
                    duck=1;
                }
                if(dir==left && duck==0)
                {
                    setLocation(getX(), getY()+10);
                    setImage("MarioAgachadoIzq.png");
                    duck=1;
                }
            }
        }
        else
        {
            if(dir==right && duck==1)
            {
                setLocation(getX(), getY()-10);
                setImage("MarioGdeDer.png");
                duck=0;
            }
            if(dir==left && duck==1)
            {
                setLocation(getX(), getY()-10);
                setImage("MarioGdeIzq.png");
                duck=0;
            }
        }        
                
    }
    
    public int getMarioDir()
    {
        return(dir);
    }
        
    /**
     * Fall
     */
    private void fall()  
    {  
        setLocation (getX(), getY() + verticalSpeed);
        verticalSpeed = verticalSpeed + exel;  
    }
    
    /**
     * On Ground
     */
    private boolean onGround()  
    {  
        if(getY()>=floor)
            return true;
        else
            return false;
    }
    
    /**
     * Check Fall
     */
    private void checkFall()  
    {  
        if(onGround() || onBrick()) 
            verticalSpeed=0;
        else
            fall();
  
    }  
    
    /**
     * On Brick
     */
    private boolean onBrick()
    {
       Actor onOneBrick = getOneObjectAtOffset(0, 28, Brick.class);
       Actor onTwoBricks = getOneObjectAtOffset(0, 28, doubleBrick.class);
       Actor onThreeBricks = getOneObjectAtOffset(0, 28, trippleBrick.class);
       Actor onFourBricks = getOneObjectAtOffset(0,28, quadraBrick.class);
        
       if(onOneBrick!=null || onTwoBricks!=null || onThreeBricks!=null || onFourBricks!=null)
            return true;
       else
            return false;
  
    }
     
}
    
