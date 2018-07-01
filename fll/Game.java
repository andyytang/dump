import java.awt.*;
import javax.swing.*;


public class Game{
    public static void main(String[] args){
        Board b = new Board();
        b.setPreferredSize(new Dimension(1920,1080)); //need to use this instead of setSize
        b.setLocation(0,0);
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.pack();
        b.setVisible(true);
    }   
}
