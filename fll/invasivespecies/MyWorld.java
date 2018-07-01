import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int totalnativespecies = 1000;
    public int invasiveness = 2;
    public int invasiverootarea = 15;
    public int nativerootarea = 9;
    public int lifespan = 150;
    Scoreboard scoreboard;
    SetVar setvar;
    String[] list = {"total native species","invasiveness","invasiverootarea","nativerootarea", "lifespan"};
	Object[] vars = {totalnativespecies, invasiveness, invasiverootarea, nativerootarea, lifespan};
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 800x800 cells with a cell size of 1x1 pixels.
        super(800, 800, 1);
        GreenfootImage image = new GreenfootImage(800,600);
        Color grey = new Color(125,125,125);
        image.setColor(grey);
        image.fill();
        setBackground(image);
        setvar = new SetVar(list,vars);
        addObject(setvar,420,150);
    }
    public Scoreboard getScoreboard(){
        return scoreboard;
    }
    public void startSim(){
        totalnativespecies = (int) setvar.vars[0];
        invasiveness = (int) setvar.vars[1];
        invasiverootarea = (int) setvar.vars[2];
        nativerootarea = (int) setvar.vars[3];
        
		scoreboard = new Scoreboard("0","100");
		addObject(scoreboard, 400, 100);
        for(int i = 0; i < totalnativespecies; i++){
            addObject(new NativeSpecies(nativerootarea), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(800));
        }
        addObject(new InvasiveSpecies(invasiveness,invasiverootarea,lifespan),400,400);
        addObject(new Timer(),400,400);
    }
}
