import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.util.*;
/**
 * Write a description of class Notification here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Notification extends Actor
{
    String[] names = {"Alyssum","Calendula","Daylily","Dianthus","Fennel","Goldenrod","Milkweed","Phlox","Sage","Stonecrop","Zinnia"};
    int time = 0;
    public Notification(int mult, boolean milkweed){
        //do the coloring and filling and text display
        GreenfootImage image = new GreenfootImage(500,400);
        image.setColor(Color.white);
        image.setTransparency(200);
        image.fill();
        Font font = new Font("Impact", Font.BOLD, 20);
        //set a font
        image.setFont(font);
        image.setColor(Color.black);
        //Refueled nectar
        if(milkweed){
            image.drawString("You landed on a " + names[mult] + " and laid \n eggs! Bonus " + 100000 + " points!", 100, 100);
        }
        else{
            image.drawString("You landed on a " + names[mult] + " and refueled \n your nectar! Bonus " + 1000*(mult + 1) + " points!", 100, 100);
        }
        //set the image
        setImage(image);
        
    }
    /**
     * Act - do whatever the Notification wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        time+=20;
        getImage().setTransparency(255 - ( (int) Math.pow(time,2)/3200));
        if(time > 800){
            ButterflyWorld butterflyWorld = (ButterflyWorld) getWorld();
            butterflyWorld.removeObject(this);
        }
    }    
}
