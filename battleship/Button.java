import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    String string;
    int width;
    int height;
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Button(String string, int width, int height){
        GreenfootImage image = new GreenfootImage(width,height);
        Color cyan = new Color(0,255,255);
        image.setColor(cyan);
        image.fill();
        Font font = new Font("Georgia", Font.BOLD, 20);
        Color black = new Color(0,0,0);
        image.setColor(black);
        image.setFont(font);
        image.drawString(string, width/3 , height/3);
        setImage(image);
        
    }
    public void act() 
    {
        // Add your action code here.
        if(mouseX > width && mouseY > height){
        }
    }    
}