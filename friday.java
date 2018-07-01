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
TASK: friday
*/
import java.io.*;

class friday {
        public static boolean calcLeap(int year){
        if(year%4 == 0){
            if(year%100 != 0){
                return true;
            }
            else{
                return year%400 == 0;
            }
        }
        else{
            return false;
        }
    }  
    public static void main (String [] args) throws IOException {
        
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        int[] reg13ths = {13,44,72,103,133,164,194,225,256,286,317,347}; //Regular thirteenths
        int[] leap13ths = {13,44,73,104,134,165,195,226,257,287,318,348}; //Leap year 13ths
        int years = Integer.parseInt(f.readLine());
        int d1s = 0;
        int d2s = 0;
        int d3s = 0;
        int d4s = 0;
        int d5s = 0;
        int d6s = 0;
        int d7s = 0;
        
        for(int i = 0; i < years; i++){
            int daysToJ1 = 0;
            for(int j = 0; j < i; j++){
                if(calcLeap(1900+j)){
                    daysToJ1+=366;
                }
                else{
                    daysToJ1+=365;
                }
            }
            if(calcLeap(1900+i)){
                for(int k = 0; k < leap13ths.length; k++){
                    switch ((daysToJ1+leap13ths[k])%7) {
                        case 0:
                            d1s++;
                            break;
                        case 1:
                            d2s++;
                            break;
                        case 2:
                            d3s++;
                            break;
                        case 3:
                            d4s++;
                            break;
                        case 4:
                            d5s++;
                            break;
                        case 5:
                            d6s++;
                            break;
                        default:
                            d7s++;
                            break;
                    }
                }
            }
            else{
                for(int k = 0; k < reg13ths.length; k++){
                    switch ((daysToJ1+reg13ths[k])%7) {
                        case 0:
                            d1s++;
                            break;
                        case 1:
                            d2s++;
                            break;
                        case 2:
                            d3s++;
                            break;
                        case 3:
                            d4s++;
                            break;
                        case 4:
                            d5s++;
                            break;
                        case 5:
                            d6s++;
                            break;
                        default:
                            d7s++;
                            break;
                    }
                }
            }
        }
        out.println(d7s + " " + d1s + " " + d2s + " " + d3s + " " + d4s + " " + d5s + " " + d6s);
        out.close(); 
    }
}