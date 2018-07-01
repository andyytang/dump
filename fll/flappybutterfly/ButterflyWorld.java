import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButterflyWorld extends World
{
    Scoreboard scoreboard;
    public Monarch monarch;
    Net net;
    GoodFlower goodflower;
    int rand = Greenfoot.getRandomNumber(5);
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public ButterflyWorld()
    {        
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false);
        GreenfootImage image = new GreenfootImage(800,600);
        Color green = new Color(160,82,45);
        image.setColor(green);
        image.fill();
        for(int i = 0; i < 50; i++){
            addObject(new Plant(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(600));
        }
        setBackground(image);
        Monarch monarch = new Monarch();
        addObject(monarch,100,300);
        Scoreboard scoreboard = new Scoreboard(0);
        addObject(scoreboard, 400, 100);
        net = new Net(monarch);
        goodflower = new GoodFlower(monarch);
        for(int i = 0; i < 10; i++){
            addObject(net, getWidth(), Greenfoot.getRandomNumber(600));
            addObject(goodflower, getWidth(), Greenfoot.getRandomNumber(600));
        }
        this.scoreboard = scoreboard;
        this.monarch = monarch;
        setPaintOrder(Scoreboard.class, Monarch.class, Net.class);
    }
    
    public Scoreboard getScoreboard(){
        return scoreboard;
    }
    //Gameover method
    public void gameOver(){
        //remove Objects
        removeObjects(getObjects(Scoreboard.class));
        Net.speed = 10;
        removeObjects(getObjects(Net.class));
        GoodFlower.speed = 10;
        removeObjects(getObjects(GoodFlower.class));
        removeObjects(getObjects(Monarch.class));
        removeObjects(getObjects(Notification.class));
        if(GoodFlower.liveon == true){
            addObject(new WinScreen(scoreboard.getPoints(), true), getWidth()/2, getHeight()/4);
            addObject(new InfoBox(), getWidth()/2, 3*getHeight()/4);
        }
        else{    
            addObject(new WinScreen(scoreboard.getPoints(), false), getWidth()/2, getHeight()/4);
            addObject(new InfoBox(), getWidth()/2, 3*getHeight()/4);
        }
        GoodFlower.liveon = false;
    }
}
