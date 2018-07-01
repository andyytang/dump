import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monarch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monarch extends Actor
{
    static double speed;
    int loopcount;
    public Monarch(){
        speed = 10;
        loopcount = 0;
        getImage().scale(100,100);
    }
    /**
     * Act - do whatever the Monarch wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(loopcount == 0){
            ButterflyWorld butterflyWorld = (ButterflyWorld) getWorld();
            butterflyWorld.addObject(new TextBox("Ready",200,100),100,500);
            Greenfoot.delay(50);
            butterflyWorld.addObject(new TextBox("Set  ",200,100),100,500);
            Greenfoot.delay(50);
            butterflyWorld.addObject(new TextBox("Go!  ",200,100),100,500);
            Greenfoot.delay(20);
        }
        addPoint();
        motionControl();
        speed = speed*1.00005;
        loopcount++;
    }    
    private void motionControl()
    {
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY() - (int) speed);
        }
        else if(Greenfoot.isKeyDown("down")){
            setLocation(getX(),getY() + (int) speed);
        }
        if(this.getY() < 0 || this.getY() > 400){
            setLocation(getX(),this.getY());
        }    
    }
    private void addPoint(){
        ButterflyWorld world = (ButterflyWorld) getWorld();
        Scoreboard scoreboard = world.getScoreboard();
        scoreboard.updateScore(scoreboard.getPoints() + 1);

    }
}
