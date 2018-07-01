import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class SetVar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SetVar extends Actor
{
    int varvalue;
    int varon = 0;
    boolean entered = false;
    Object[] vars;
    String[] varnames;
    String a;
    public SetVar(String[] varnames, Object[] vars){
        GreenfootImage image = new GreenfootImage(800,35);
        image.setFont(new Font("Garamond", Font.BOLD, 25));
        image.setColor(Color.YELLOW);        
        image.drawString(varnames[varon%vars.length] + ": " + varvalue,50,20);
        setImage(image);
        this.varnames = varnames;
        this.vars = vars;
        this.varvalue = (int) vars[0];
    }
    
    public void updateScore(){
        GreenfootImage image = getImage();
        image.clear();
        image.setFont(new Font("Garamond", Font.BOLD, 25));
        image.setColor(Color.YELLOW);
        image.drawString(varnames[varon%varnames.length] + ": " + varvalue,50,20);
    }
    /**
     * Act - do whatever the SetVar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        a = Greenfoot.getKey();
        if(a == "w"){
            varvalue+=20;
        }
        else if(a == "s"){
            varvalue-=20;
        }
        else if(a == "up"){
            varvalue++;
        }
        else if(a == "down"){
            varvalue--;
        }
        else if(a == "right"){
            vars[varon%varnames.length] = varvalue;
            varon++;
            varvalue = (int) world.vars[varon%varnames.length];
        }
        if(Greenfoot.isKeyDown("enter") && !entered){
            world.startSim();
            entered = true;
        }
        updateScore();
    }    
}
