import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class TextBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextBox extends Actor
{
    int time;
    public TextBox(String text, int xsize, int ysize){
        time = 0;
        GreenfootImage image = new GreenfootImage(xsize, ysize);
        image.setColor(Color.white);
        image.fill();
        Font font = new Font("Courier New", Font.BOLD, 20);
        image.setFont(font);
        image.setColor(Color.red);
        image.drawString(text,xsize/2,ysize/2);
        setImage(image);
    }
    /**
     * Act - do whatever the TextBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        ButterflyWorld world = (ButterflyWorld) getWorld();
        world.removeObject(this);
    }    
}
