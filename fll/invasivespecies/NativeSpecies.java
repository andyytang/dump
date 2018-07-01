import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class NativeSpecies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NativeSpecies extends Actor
{
    int ra;
    public NativeSpecies(int ra){
        GreenfootImage image = new GreenfootImage(4,4);
        image.setColor(Color.BLUE);
        image.fill();
        setImage(image);
        this.ra = ra;
    }
    /**
     * Act - do whatever the NativeSpecies wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        if(Greenfoot.getRandomNumber(10) == 5){
            world.addObject(new NativeSpecies(ra),getX() - 20 + Greenfoot.getRandomNumber(40),getY() - 20 + Greenfoot.getRandomNumber(40));
        }
        
        world.removeObjects(this.getObjectsInRange(ra/2,InvasiveSpecies.class));
        world.removeObjects(this.getObjectsInRange(ra,NativeSpecies.class));
        
    }    
}
