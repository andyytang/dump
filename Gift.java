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
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {
    
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
    int numpeople = Integer.parseInt(f.readLine()); //Figure out number of people
    String[] names = new String[numpeople]; //Create array for names
    int[] money = new int[numpeople]; //Create array for money
    for(int i = 0; i < numpeople; i++){
        names[i] = f.readLine();
        money[i] = 0;
    }
    for(int i = 0; i < numpeople; i++){
        String giver = f.readLine();
        String givestr = f.readLine();
        int moneygiven = Integer.parseInt(givestr.split(" ")[0]);
        int peopletogive = Integer.parseInt(givestr.split(" ")[1]);
        
        if(peopletogive != 0){
            int remainder = moneygiven%peopletogive;
            for(int j = 0; j < numpeople; j++){
                if(giver.equals(names[j])){
                    money[j]-=(moneygiven-remainder);
                }
            }
            for(int j = 0; j < peopletogive; j++){
                String reciever = f.readLine();
                for(int k = 0; k < numpeople; k++){
                    if(reciever.equals(names[k])){
                        money[k]+=((moneygiven-remainder)/peopletogive);
                    }
                }
            }
        }
    }
    for(int i = 0; i < numpeople; i++){
        out.println(names[i] + " " + money[i]);
    }
    out.close();
  }
}