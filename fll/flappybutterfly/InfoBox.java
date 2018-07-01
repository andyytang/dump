import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class InfoBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InfoBox extends Actor
{
    String editscore;
    double trans = 0;
    public InfoBox(){
        //do the coloring and filling and text display
        GreenfootImage image = new GreenfootImage(700,270);
        image.setColor(Color.white);
        image.setTransparency(255);
        image.fill();
        Font font = new Font("Courier New", Font.BOLD, 20);
        //set a font
        image.setFont(font);
        image.setColor(Color.black);
        //Game over
        image.drawString("Information: How to create a Butterfly Waystation", 40, 50);
        //more fonts
        Font font2 = new Font("Courier New", Font.BOLD, 15);
        image.setFont(font2);
        image.drawString("      In the game you just played, we added several elements \n" +
                         "that educated you on how to help butterflies. One way to help \n" + 
                         "butterflies is by creating a butterfly waystation. These are \n" + 
                         "stations where butterflies that have traveled a long distance \n" + 
                         "can refuel their nectar and lay their eggs. Milkweed is the only \n" + 
                         "plant on which that monarch butterflies can lay their eggs. In \n" + 
                         "addition, the flowers alyssum, calendula, daylily, dianthus, \n" + 
                         "fennel, goldenrod, phlox, sage, stonecrop, and zinnia are high in \n" + 
                         "nectar. We incorporated these in the game. To find other ways \n" + 
                         "to help YOUR habitat, visit the Team Blue Chameleons website \n" +
                         "https://sites.google.com/view/teambluechameleons",40,80);
        //set the image
        setImage(image);
        
    }
    /**
     * Act - do whatever the InfoBox wants to do. This method is called whenever
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
