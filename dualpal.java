/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;

/*
ID: andy.sc1
LANG: JAVA
TASK: dualpal
*/

public class dualpal {
    public static boolean isPal(String str){
        String reverse = "";
        int length = str.length();
 
        for (int i = length - 1; i >= 0; i--){
            reverse = reverse + str.charAt(i);
        }
        return str.equals(reverse);
    }
   public static boolean isDualPal(int num){
       int counter = 0;
       for(int i = 1; i < 10; i++){
           if(isPal(Integer.toString(num, i))){
               counter++;
           }
       }
       return counter>=2;
   }
   public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        
        String params = f.readLine();
        int numints = Integer.parseInt(params.split(" ")[0]);
        int startint = Integer.parseInt(params.split(" ")[1]) + 1;
        int counter = 0;
        while(counter < numints){
            if(isDualPal(startint)){
                out.println(startint);
                counter++;
            }
            startint++;
        }
        out.close();
   }
}
