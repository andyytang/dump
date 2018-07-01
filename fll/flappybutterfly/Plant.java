import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plant extends Actor
{
    double speed = 10;
    /**
     * Act - do whatever the Plant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        speed = speed*1.0001;
        move();
    }    
    private void respawn(){
        setLocation(800, Greenfoot.getRandomNumber(600));
    }
    private void move(){
        setLocation(getX() - (int) speed,getY());
        if(getX() <= 0){
            respawn();
        }
    }
}
