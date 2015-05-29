import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Brick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class quadraBrick extends Actor
{
    private int type;
    private int direction;
    private int distance;
    private final int movingBrick = 2;
    private final int stillBrick = 1;
    private final int breakingBrick = 3;
    private final int left = 1;
    private final int right = 2;
    private int speed = 3;
    private int xBrick;
    private int yBrick;
    private int moveCounter;
    
    /**
     * Constructor de la clase quadraBrick, recibe como parámetro si es fijo o está en movimiento, hacia 
     * dónde se empieza a mover y cuantos pasos se debe mover
     */
    public quadraBrick(int brickType, int movementWay, int steps)
    {
        type = brickType;
        direction = movementWay;
        distance = steps;
        
    }
    
      /**
    * En el metodo "Act" movemos el ladrillo en caso que sea de tipo de movimiento
    * 
    */
    public void act() 
    {
        moveBrick();
    }
    
      /**
     * Este es el método cambiamos la dirección con la que se mueve el ladrillo
     * 
     */
    private void moveBrick()
    {
        if(direction == right)
            moveRight();
        if(direction == left)
            moveLeft();
    }
        
       /**
     * Con este método movemos el ladrillo hacia la derecha
     * 
     */
    private void moveRight()
    {   
        if(getX()<=840)
        {
            setLocation(getX()+speed, getY());
        }
        else
            direction=left;
        
    }
    
          /**
     * Con este método movemos el ladrillo hacia la Izquierda
     * 
     */
    private void moveLeft()
    {
        if(getX()>=60)
            setLocation(getX()-speed, getY());
        else
            direction=right;
        
    }
    
}