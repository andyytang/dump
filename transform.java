/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.Arrays;

/*
ID: andy.sc1
LANG: JAVA
TASK: transform
*/

public class transform {
    public static int[][] changeToArray(String[] str){
        int[][] array = new int[str.length][str.length];
        for(int i = 0; i < str.length; i++){
            int[] temp = new int[str[i].length()];
            for(int j = 0; j < str[i].length(); j++){
                if(str[i].charAt(j) == '@'){
                    temp[j] = 0;
                }
                else{
                    temp[j] = 1;
                }
            }
            array[i] = temp;
        }
        return array;
    }
    public static int[][] rotatearray(int[][] array){
        int[][] arr2 = new int[array.length][array.length];
        for(int i = 0; i < arr2.length; i++){
            for(int j = 0; j < arr2.length; j++){
                arr2[i][j] = array[array.length- j - 1][i];
            }
        }
        return arr2;
    }
    public static int[][] reflectarray(int[][] array){
        int[][] ret = new int[array.length][array.length];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                ret[i][j] = array[i][array[i].length-j-1];
            }
        }
        return ret;
    }
    public static int whichtransform(int[][] array1, int[][] array2){
        
        if(Arrays.deepEquals(rotatearray(array1), array2)){
            return 1;
        }
        else if(Arrays.deepEquals(rotatearray(rotatearray(array1)), array2)){
            return 2;
        }
        else if(Arrays.deepEquals(rotatearray(rotatearray(rotatearray(array1))), array2)){
            return 3;
        }
        else if(Arrays.deepEquals(reflectarray(array1), array2)){
            return 4;
        }
        else if(Arrays.deepEquals(reflectarray(rotatearray(array1)), array2) || Arrays.deepEquals(reflectarray(rotatearray(rotatearray(array1))), array2) || Arrays.deepEquals(reflectarray(rotatearray(rotatearray(rotatearray(array1)))), array2)){
            return 5;
        }
        else if(Arrays.deepEquals(array1, array2)){
            return 6;
        }
        else{
            return 7;
        }
    }
    public static void main(String[] args) throws IOException{
       
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        int num = Integer.parseInt(f.readLine());
        String[] str = new String[num];
        String[] str2 = new String[num];
        for(int i = 0; i < num; i++){
            str[i] = f.readLine();
        }
        for(int i = 0; i < num; i++){
            str2[i] = f.readLine();
        }
        int[][] arraynum = changeToArray(str);
        int[][] arraynum2 = changeToArray(str2);
        out.println(whichtransform(arraynum, arraynum2));
        out.close();
    }
}
