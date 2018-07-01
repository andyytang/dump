import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Board extends JFrame{
    static Font font = new Font("Helvetica", Font.BOLD, 40);
    static Font font2 = new Font("sans-serif", Font.BOLD, 30);
    static Font font3 = new Font("sans-serif", Font.BOLD, 20);
    private int frames = 0;
    private int turns;
    private List<Card> cards;
    private Card selectedCard;
    private Card c1;
    private Card c2;
    private Timer t;
    private int j = 0;
    int points = 0;
    int clicks = 0;
    int matches = 0;
    static int bonus = 100;
    TextArea help = new TextArea();
    JLabel label = new JLabel("How You Can Help:", JLabel.LEFT);
    public Board(){
        turns = 0;
        int pairs = 6;
        int frames = 0;
        List<Card> cardsList = new ArrayList<>();
        List<String> cardKeys = new ArrayList<>();
        List<Integer> cardVals = new ArrayList<>();
        for (int i = 0; i < pairs; i++){
            cardVals.add(i);
            cardVals.add(i);
        }
        for (int i = 0; i < pairs; i++){
            switch (i) { 
                case 0:
                    cardKeys.add("Tallgrass Prarie");
                    cardKeys.add("1/10 of one percent");
                    break;
                case 1:
                    cardKeys.add("Forest");
                    cardKeys.add("12 percent");
                    break;
                case 2:
                    cardKeys.add("Wetlands");
                    cardKeys.add("10.6 percent");
                    break;
                case 3:
                    cardKeys.add("Tundra");
                    cardKeys.add("71.2 percent");
                    break;
                case 4:
                    cardKeys.add("Savannah");
                    cardKeys.add("50 percent");
                    break;
                case 5:
                    cardKeys.add("Shortgrass Prarie");
                    cardKeys.add("20%");
                    break;
                default:
                    break;
                    
            }
            
        }
        
        for (int val : cardVals){
                Card c = new Card();
                c.setId(val);
                c.setFont(font);
                c.setForeground(Color.BLUE);
                c.setKey(cardKeys.get(j));
                c.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                        selectedCard = c;
                        doTurn();
                    }
                });
                cardsList.add(c);
                j++;
            
        }
        this.cards = cardsList;
        Collections.shuffle(cardsList);

        //set up the timer
        t = new Timer(750, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                checkCards();
            }
        });

        t.setRepeats(false);

        //set up the board itself
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(3, 5));
        for (Card c : cards){
            pane.add(c);
        }
        javax.swing.UIManager.put("OptionPane.font", new Font("Helvetica", Font.BOLD, 30));
        setTitle("Ecosystem");
        JOptionPane.showMessageDialog(this, "Play this simple game by matching the ecosystems with the percentage remaining since pre - industrial \n" + 
                                            "times. When you make a successful match, the game will tell you how to help the ecosystem.");
        
    }

    public void doTurn(){
        if (c1 == null && c2 == null){
            c1 = selectedCard;
            clicks++;
            c1.setText(String.valueOf(c1.getKey()));
        }

        if (c1 != null && c1 != selectedCard && c2 == null){
            c2 = selectedCard;
            clicks++;
            c2.setText(String.valueOf(c2.getKey()));
            turns++;
            t.start();

        }
    }

    public void checkCards(){
        if (c1.getId() == c2.getId()){//match condition
            c1.setEnabled(false); //disables the button
            c2.setEnabled(false);
            c1.setMatched(true); //flags the button as having been matched
            c2.setMatched(true);
            matches++;
            if(c1.getId() == 0){
                JOptionPane.showMessageDialog(this, "Tallgrass Prarie used to be in abundance in the Midwest. However, settlers" + "\n" + "destroyed most of the prarie for farms. You can help restore this habitat with" + "\n" + "Pheasants Forever (https://www.pheasantsforever.org/) and Quail Forever " + "\n" + "(https://quailforever.org/)");
            }
            else if(c1.getId() == 1){
                JOptionPane.showMessageDialog(this, "Before settlers came to America, the entire east coast was blanketed with forests." + "\n" + "Now, most of the forest has been logged or converted to farmland. You can help" + "\n" + "preserve this iconic habitat with American Forests" + "\n" + "(https://www.americanforests.org)");
            
            }
            else if(c1.getId() == 2){
                JOptionPane.showMessageDialog(this, "Wetlands, which can do up to $10,000 worth of services per acre, are disappearing incredibly" + "\n" + "quickly as they are filled, drained, or dumped. Some helpful websites" + "\n" + "on how to preserve wetlands are the NOAA Habitat Webpage (http://www.habitat.noaa.gov/protection/wetlands/whatyoucando.html) " + "\n" + " and the National Wildlife Federation (https://www.nwf.org/What-We-Do/Protect-Habitat/Waters/Wetlands-and-Watersheds.aspx)");
            
            }
            else if(c1.getId() == 3){
                JOptionPane.showMessageDialog(this, "Tundra hasn't been destroyed as much as other ecosystems, but tundras are still worth protecting, as" + "\n" + "it protects the Arctic Ocean and has some endemic species, such as polar bears." + "\n" + " To find out how to help save the tundra, go to the World Wildlife fund website" + "\n" + "(http://wwf.panda.org/wwf_news/?199975/Saving-the-Arctic)");
              
            }    
            else if(c1.getId() == 4){
                JOptionPane.showMessageDialog(this, "Respect and conserve grasslands where you live (many people do not think grassland habitats are as important as forests or wetlands).\n" + "Learn about savannas and teach others about them.\n" +
                             "Volunteer for a savanna restoration project.\n" +
                             "Support conservation organizations that protect savannas and the plants and animals that depend on them.");
            
            }
            else if(c1.getId() == 5){
                JOptionPane.showMessageDialog(this, "Shortgrass Prarie is also covered by Pheasants Forever (https://www.pheasantsforever.org/)");
            
            }
            if (this.isGameWon()){
                points = (matches*10 - clicks*2 + bonus);
                JOptionPane.showMessageDialog(this, "You found 'em all with " + points + " points!"
                        + "                          \n Match Score: " + matches*10 +
                                                    "\n" + "Click Penalty: (" + clicks* 2 + ")" +
                                                    "\n Bonus:            " + bonus +
                                                    "\n________________________________________"+
                                                    "\n Final Score : " + (matches*10 - clicks*2 + bonus));
                System.exit(0);
            }
            else if(turns > 12){
                JOptionPane.showMessageDialog(this, "You lose...");
                System.exit(0);
            }
        }

        else{
            c1.setText(""); //'hides' text
            c2.setText("");
            if(turns > 12){
                JOptionPane.showMessageDialog(this, "You lose...");
                System.exit(0);
            }
        }
        c1 = null; //reset c1 and c2
        c2 = null;
    }

    public boolean isGameWon(){
        for(Card c: this.cards){
            if (c.getMatched() == false){
                return false;
            }
        }
        return true;
    }

}