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
TASK: palsquare
*/

import java.io.*;

public class palsquare {
    public static boolean isPal(String str){
        String reverse = "";
        int length = str.length();
 
        for (int i = length - 1; i >= 0; i--){
            reverse = reverse + str.charAt(i);
        }
        return str.equals(reverse);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        int base = Integer.parseInt(f.readLine());
        for(int i = 1; i < 300; i++){
            String j = Integer.toString(i, base);
            String k = Integer.toString((int) Math.pow(i, 2), base);
            if(isPal(k)){
                out.println(j.toUpperCase() + " " + k.toUpperCase());
            }
        }
        out.close();
    }
}
