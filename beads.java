import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chess
 */
/*
ID: andy.sc1
LANG: JAVA
TASK: beads
*/

public class beads {
    public static String orientation(String string, int startChar){
        String s1 = string.substring(0, startChar);
        String s2 = string.substring(startChar);
        return s2 + s1;
    }
    public static char findbead(String string, int direction){
        if(direction == 0){
            int i = 0;
            while(i < string.length()){
                if(string.charAt(i) == 'b'){
                    return 'r';
                }
                else if(string.charAt(i) == 'r'){
                    return 'b';
                }
                i++;
            }
        }
        else{
            int i = string.length() - 1;
            while(i > 0){
                if(string.charAt(i) == 'b'){
                    return 'r';
                }
                else if(string.charAt(i) == 'r'){
                    return 'b';
                }
                i--;
            }
        }
        return 'w';
    }
    public static int harvestable(String string){
        int fromFront = 0;
        int fromBack = 0;
        if(findbead(string,0) != 'w'){
            char frontbeadtype = findbead(string,0);
            char backbeadtype = findbead(string,1);
            int iter1 = 0;
            int iter2 = string.length() - 1;
            while(iter1 < string.length() - 1 && string.charAt(iter1) != frontbeadtype){
                fromFront++;
                iter1++;
            }
            while(iter2 >= iter1 && string.charAt(iter2) != backbeadtype){
                fromBack++;
                iter2--;
            }
            return fromFront + fromBack;
        }
        return string.length();
    }
    public static void main (String[] args) throws IOException{
        
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
                                                  // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        int length = Integer.parseInt(f.readLine());
        String necklace = f.readLine();
        int total = 0;
        for(int i = 1; i < length; i++){
            String thisOrientation = orientation(necklace,i);
            if(harvestable(thisOrientation) > total){
                total = harvestable(thisOrientation);
            }
        }
        out.println(total);
        out.close();
    }
}
