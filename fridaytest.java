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

class fridaytest {
    public static boolean calcLeap(int year){
        if(year%4 == 0){
            if(year%100 != 0){
                return true;
            }
            else{
                if(year%400 == 0){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        else{
            return false;
        }
    }  
    public static void main (String [] args) throws IOException {
        
        int[] reg13ths = {13,44,72,103,133,164,194,225,256,286,317,347}; //Regular thirteenths
        int[] leap13ths = {13,44,73,104,134,165,195,226,257,287,318,348}; //Leap year 13ths
        int years = 100000;
        int mondays = 0;
        int tuesdays = 0;
        int wednesdays = 0;
        int thursdays = 0;
        int fridays = 0;
        int saturdays = 0;
        int sundays = 0;
        
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
                    if((daysToJ1+leap13ths[k])%7 == 0){
                        mondays++;
                    }
                    else if((daysToJ1+leap13ths[k])%7 == 1){
                        tuesdays++;
                    }
                    else if((daysToJ1+leap13ths[k])%7 == 2){
                        wednesdays++;
                    }
                    else if((daysToJ1+leap13ths[k])%7 == 3){
                        thursdays++;
                    }
                    else if((daysToJ1+leap13ths[k])%7 == 4){
                        fridays++;
                    }
                    else if((daysToJ1+leap13ths[k])%7 == 5){
                        saturdays++;
                    }
                    else{
                        sundays++;
                    }
                }
            }
            else{
                for(int k = 0; k < reg13ths.length; k++){
                    if((daysToJ1+reg13ths[k])%7 == 0){
                        mondays++;
                    }
                    else if((daysToJ1+reg13ths[k])%7 == 1){
                        tuesdays++;
                    }
                    else if((daysToJ1+reg13ths[k])%7 == 2){
                        wednesdays++;
                    }
                    else if((daysToJ1+reg13ths[k])%7 == 3){
                        thursdays++;
                    }
                    else if((daysToJ1+reg13ths[k])%7 == 4){
                        fridays++;
                    }
                    else if((daysToJ1+reg13ths[k])%7 == 5){
                        saturdays++;
                    }
                    else{
                        sundays++;
                    }
                }
            }
        }
        System.out.println(mondays+ " " + tuesdays + " " + wednesdays + " " + thursdays + " " + fridays + " " + saturdays + " " + sundays);
    }
}