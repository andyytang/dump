import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Actor
{
    int points;
    public Scoreboard(int points){
        GreenfootImage img_field = new GreenfootImage(800,35);
        Font serif = new Font("Times New Roman", Font.BOLD, 25);
        img_field.setFont(serif);
        img_field.setColor(Color.red);
        img_field.drawString("" + points, 75, 30);
        setImage(img_field);
        
        this.points = points;
    }
    public void updateScore(int points){
        GreenfootImage img_field = getImage();
        img_field.clear();
        Font serif = new Font("Times New Roman", Font.BOLD, 25);
        img_field.setFont(serif);
        img_field.setColor(Color.red);
        img_field.drawString("" + points, 75, 30);
        
        this.points = points;
    }
    public int getPoints(){
        return points;
    }
}
