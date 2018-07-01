import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Net here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Net extends Actor
{
    Monarch monarch;
    static double speed = 10;
    public Net(Monarch monarch){
        this.monarch = monarch;
        GreenfootImage image = new GreenfootImage(30,200);
        Font serif = new Font("Times New Roman", Font.BOLD, 25);
        image.setFont(serif);
        image.setColor(Color.yellow);
        image.fill();
        setImage(image);
    }
    /**
     * Act - do whatever the Net wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        speed = speed*1.0001;
        move();
        collision();
    }    
    public void collision(){
        Actor monarch = getOneIntersectingObject(Monarch.class);
        if(monarch != null){
            ButterflyWorld butterflyWorld = (ButterflyWorld) getWorld();
            butterflyWorld.gameOver();
        }
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
