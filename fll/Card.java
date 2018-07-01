import javax.swing.*;

@SuppressWarnings("serial")
public class Card extends JButton{
    private int id;
    private String key;
    private boolean matched = false;


    public void setId(int id){
        this.id = id;
    }

    
    public int getId(){
        return this.id;
    }
    
    public void setKey(String id){
        this.key = id;
    }

    
    public String getKey(){
        return this.key;
    }

    public Card getCard(){
        return this;
    }
    
    public void setMatched(boolean matched){
        this.matched = matched;
    }

    public boolean getMatched(){
        return this.matched;
    }
}