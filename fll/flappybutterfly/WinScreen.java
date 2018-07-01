import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class WinScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinScreen extends Actor
{
    String editscore;
    double trans = 0;
    public WinScreen(int score, boolean objectiveComplete){
        //do the coloring and filling and text display
        GreenfootImage image = new GreenfootImage(700,250);
        image.setColor(Color.white);
        image.setTransparency(255);
        image.fill();
        Font font = new Font("Georgia", Font.BOLD, 60);
        //set a font
        image.setFont(font);
        image.setColor(Color.black);
        //Game over
        image.drawString("Game Over", 100, 100);
        //more fonts
        Font font2 = new Font("Courier New", Font.BOLD, 20);
        image.setFont(font2);
        //Objective Complete?
        if(objectiveComplete){
            image.setColor(Color.green);
            if(score > 1000000){
                image.drawString("Objective Complete: Migrated to USA with 1,000,000+ points", 0, 220);
            }
            else if(score > 1000){
                if((score%1000) < 10){
                    editscore = Math.round((float) Math.floor(score/1000)) + ",00" + (score%1000);
                }
                else if((score%1000) < 100){
                    editscore = Math.round((float) Math.floor(score/1000)) + ",0" + (score%1000);
                }
                else{
                    editscore = Math.round((float) Math.floor(score/1000)) + "," + (score%1000);
                }
                image.drawString("Objective Complete: Laid eggs. Your score: " + editscore + " points", 10, 220);
            }
            else{
                image.drawString("Objective Complete: Laid eggs. Your score: " + score + " points", 10, 220);
            }
        }
        else{
            image.setColor(Color.red);
            image.drawString("Objective Failed.", 80, 220);
        }
        //set the image
        setImage(image);
        
    }
    /**
     * Act - do whatever the WinScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        GreenfootImage image2 = getImage();
        image2.setTransparency(255- (int) Math.pow(trans,2));
        trans+=0.01;
        if(trans > 15.9){
            ButterflyWorld butterflyworld = (ButterflyWorld) getWorld();
            butterflyworld.removeObject(this);
        }
    }
}
