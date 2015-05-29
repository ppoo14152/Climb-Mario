import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class trippleBrick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class trippleBrick extends Actor
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
     * Act - do whatever the trippleBrick wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveBrick();
    }
    
    public trippleBrick(int brickType, int movementWay, int steps)
    {
        type = brickType;
        direction = movementWay;
        distance = steps;
        
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
        if(getX()<=850)
        {
            setLocation(getX()+speed, getY());
        }
        else
            direction=left;
        
    }
    
    private void moveLeft()
    {
        if(getX()>=50)
            setLocation(getX()-speed, getY());
        else
            direction=right;
        
    }
    
}