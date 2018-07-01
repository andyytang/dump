import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class InvasiveSpecies here.
 * 
 * @Andy Tang (your name) 
 * @2.0 (a version number or a date)
 */
public class InvasiveSpecies extends Actor
{
    int speed;
    int iarea;
    int lifespan;
    int age = 0;
    int rootsize;
    public InvasiveSpecies(int invasiveness, int iarea, int lifespan){
        speed = invasiveness;
        GreenfootImage image = new GreenfootImage(4,4);
        image.setColor(Color.RED);
        image.fill();
        setImage(image);
        this.iarea = iarea;
        this.lifespan = lifespan;
    }
    /**
     * Act - do whatever the InvasiveSpecies wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int ensureRange(int value, int min, int max) {
        return Math.min(Math.max(value, min), max);
    }
    public void act() 
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        Scoreboard scoreboard = world.getScoreboard();
        rootsize = iarea*age/50;
        ensureRange(rootsize, 16, iarea);
        world.removeObjects(this.getObjectsInRange(rootsize/2,InvasiveSpecies.class));
        world.removeObjects(this.getObjectsInRange(rootsize,NativeSpecies.class));
        if(getX() > 800 || getY() > 800 || getX() < 0 || getY() < 0){
            world.removeObject(this);
        }
        age++;
        if(age > lifespan*1/5){
            for(int i = 1; i < speed; i++){
                world.addObject(new InvasiveSpecies(speed,iarea,lifespan),getX() - 50 + Greenfoot.getRandomNumber(100),getY() - 50 + Greenfoot.getRandomNumber(100));
            }
        }
        if(age > lifespan){
            world.removeObject(this);
        }
        if(world.getObjects(NativeSpecies.class).size()/10 > 100){
            scoreboard.updateScore(scoreboard.getTime(), 100 + "");
        }
        else{
            scoreboard.updateScore(scoreboard.getTime(), world.getObjects(NativeSpecies.class).size()/10 + "");
        }
        if(Integer.parseInt(scoreboard.getesp()) == 0){
            Greenfoot.delay(10);
            world.removeObjects(world.getObjects(InvasiveSpecies.class));
            world.removeObjects(world.getObjects(NativeSpecies.class));
            world.removeObjects(world.getObjects(Timer.class));
            world.removeObjects(world.getObjects(SetVar.class));
            System.out.println("It took " + scoreboard.getTime() + " years for the invasive species to destroy the native species");
            world.removeObjects(world.getObjects(Scoreboard.class));
        }
    }    
}
