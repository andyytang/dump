import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
    public Timer(){
        GreenfootImage image = new GreenfootImage(600,50);
        image.setColor(Color.YELLOW);
        image.setFont(new Font("Garamond",Font.BOLD,15));
        image.drawString("Invasive Species Introduction Site", 320, 20);
        image.drawRect(300,25,5,5);
        image.fillRect(300,25,5,5);
        setImage(image);
    }
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        Scoreboard scoreboard = world.getScoreboard();
        scoreboard.updateScore(Integer.parseInt(scoreboard.getTime()) + 1 + "", scoreboard.getesp());
    }    
}
