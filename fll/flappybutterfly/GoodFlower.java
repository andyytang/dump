import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class GoodFlower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoodFlower extends Actor
{
    Monarch monarch;
    static double speed = 10;
    static boolean liveon = false;
    public static double bonus = 100;
    int mult = Greenfoot.getRandomNumber(10);
    String[] names = {"Alyssum","Calendula","Daylily","Dianthus","Fennel","Goldenrod","Milkweed","Phlox","Sage","Stonecrop","Zinnia"};
    public GoodFlower(Monarch monarch){
        this.monarch = monarch;
        GreenfootImage image = new GreenfootImage(30,200);
        Font serif = new Font("Times New Roman", Font.BOLD, 25);
        image.setFont(serif);
        image.setColor(Color.blue);
        image.fill();
        setImage(image);
    }
    /**
     * Act - do whatever the GoodFlower wants to do. This method is called whenever
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
        Actor monarch2 = getOneIntersectingObject(Monarch.class);
        if(monarch2 != null){
            ButterflyWorld butterflyWorld = (ButterflyWorld) getWorld();
            Scoreboard scoreboard = butterflyWorld.getScoreboard();
            if(mult == 6){
                liveon = true;
                butterflyWorld.addObject(new Notification(mult,true), 400,300);
                scoreboard.updateScore(scoreboard.getPoints() + 100000);
            }
            else{
                butterflyWorld.addObject(new Notification(mult,false), 400,300);
                scoreboard.updateScore(scoreboard.getPoints() + 1000*(mult + 1));
            }
            butterflyWorld.addObject(new GoodFlower(monarch), 800, Greenfoot.getRandomNumber(600));
            butterflyWorld.removeObject(this);
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
