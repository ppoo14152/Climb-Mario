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
     * Act - do whatever the quadraBrick wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public quadraBrick(int brickType, int movementWay, int steps)
    {
        type = brickType;
        direction = movementWay;
        distance = steps;
        
    }
        
    public void act() 
    {
        moveBrick();
    }
    
    private void moveBrick()
    {
        if(direction == right)
            moveRight();
        if(direction == left)
            moveLeft();
    }
        
    private void moveRight()
    {   
        if(getX()<=840)
        {
            setLocation(getX()+speed, getY());
        }
        else
            direction=left;
        
    }
    
    private void moveLeft()
    {
        if(getX()>=60)
            setLocation(getX()-speed, getY());
        else
            direction=right;
        
    }
    
}