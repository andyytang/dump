
import java.io.*;
import java.util.*;

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
TASK: namenum
*/

/**
 * Ideas for finding permutations of a number
 * Maybe turn into numbers A=1 then change?
 * A=1, B=2
 **/
public class namenum {
    public static char[][] toStr(String num){
        //change number
        int length = num.length();
        int[] num2 = new int[length];
        char[][] num3 = new char[length][3];
        for(int i = 0; i < num.length(); i++){
            num2[i] = (Integer.parseInt(Character.toString(num.charAt(i))) % 10);
        }
        for(int j = 0; j < length; j++){
            switch(num2[j]){
                case 2:
                    num3[j][0] = 'A';
                    num3[j][1] = 'B';
                    num3[j][2] = 'C';
                    break;
                case 3:
                    num3[j][0] = 'D';
                    num3[j][1] = 'E';
                    num3[j][2] = 'F';
                    break;
                case 4:
                    num3[j][0] = 'G';
                    num3[j][1] = 'H';
                    num3[j][2] = 'I';
                    break;
                case 5:
                    num3[j][0] = 'J';
                    num3[j][1] = 'K';
                    num3[j][2] = 'L';
                    break;
                case 6:
                    num3[j][0] = 'M';
                    num3[j][1] = 'N';
                    num3[j][2] = 'O';
                    break;
                case 7:
                    num3[j][0] = 'P';
                    num3[j][1] = 'R';
                    num3[j][2] = 'S';
                    break;
                case 8:
                    num3[j][0] = 'T';
                    num3[j][1] = 'U';
                    num3[j][2] = 'V';
                    break;
                case 9:
                    num3[j][0] = 'W';
                    num3[j][1] = 'X';
                    num3[j][2] = 'Y';
                    break;
            }
        }
        return num3;
    }
    public static String[] permutations(String[][] str) {
        String[] str2 = new String[(int) Math.pow(3, str.length)];
        for(int i = 0; i < str2.length; i++){
            str2[i] = "";
        }
        int num = 3;
        for(int i = 0; i < str.length; i++) {
            if(i%3 == 0){
                str2[i] += str[i][0];
            }
            else if(i%3 == 1){
                str2[i] += str[i][1];
            }
            else{
                str2[i] += str[i][2];
            }
        }
        return str2;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
        BufferedReader f2 = new BufferedReader(new FileReader("dict.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("namenum.out"));
        ArrayList<String> s = new ArrayList<String>();
        String g = f2.readLine();
        while(g != null){
            s.add(g);
            g = f2.readLine();
        }
        char[][] choices = toStr(f.readLine());
        for(int i = 0; i < s.size(); i++){
            if(s.get(i).length() != choices.length){
                s.remove(i);
                i--;
            }
        }
        for(int i = 0; i < s.size(); i++){
            for(int j = 0; j < s.get(i).length(); j++){
                if(s.get(i).charAt(j) != choices[j][0] && s.get(i).charAt(j) != choices[j][1] && s.get(i).charAt(j) != choices[j][2]){
                    s.remove(i);
                    i--;
                    break;
                }
            }
        }
        if(s.size() == 0){
            s.add("NONE");
        }
        for(int i = 0; i < s.size(); i++){
            out.println(s.get(i));
        }
        out.close();
    }
}
