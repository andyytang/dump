import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Battleworld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Battleworld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        GreenfootImage image = new GreenfootImage(800,600);
        Color seablue = new Color(0,0,100);
        image.setColor(seablue);
        image.fill();
        setBackground(image);
        Button fireButton = new Button("Fire",200,100);
        addObject(fireButton,700,600);
    }
}
