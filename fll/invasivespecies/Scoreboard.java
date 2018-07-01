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
    String time;
    String esp;
    int counter = 0;
    public Scoreboard(String time, String esp){
        GreenfootImage img_field = new GreenfootImage(800,35);
        Font serif = new Font("Garamond", Font.BOLD, 25);
        img_field.setFont(serif);
        img_field.setColor(Color.YELLOW);
        img_field.drawString(time + " years later        " + esp + "% of species remaining", 75, 30);
        setImage(img_field);
        this.esp = esp;
        this.time = time;
    }
    public void updateScore(String time, String esp){
        GreenfootImage img_field = getImage();
        img_field.clear();
        Font serif = new Font("Garamond", Font.BOLD, 25);
        img_field.setFont(serif);
        img_field.setColor(Color.YELLOW);
        img_field.drawString(time + " years later        " + esp + "% of species remaining", 75, 30);
        
        this.esp = esp;
        this.time = time;
    }
    public String getTime(){
        return this.time;
    }
    public String getesp(){
        return this.esp;
    }
    public void act(){
        if(counter%10 == 0){
            System.out.println(this.esp);
        }
        counter++;
        if(Integer.parseInt(time) == 1){
            Greenfoot.delay(100000);
        }
        if(Integer.parseInt(time) == 10){
            Greenfoot.delay(100000);
        }
        if(Integer.parseInt(time) == 100){
            Greenfoot.delay(100000);
        }
        
	}
}
