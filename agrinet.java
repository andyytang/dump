
import java.io.*;
import java.util.*;

/*
ID: andy.sc1
LANG: JAVA
TASK: agrinet
*/

public class agrinet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("agrinet.in"));
        PrintWriter out = new PrintWriter(new FileWriter("agrinet.out"));
        
        int N = Integer.parseInt(f.readLine());
        int[] arr = new int[(int) Math.pow(N, 2)];
        
        String s;
        int counter = 0;
        while((s = f.readLine()) != null){
            StringTokenizer st = new StringTokenizer(s);
            while(st.hasMoreTokens()){
                arr[counter] = Integer.parseInt(st.nextToken());
                counter++;
            }
        }
        
        //arr: (x, y) --> x + Ny
        int[] distance = new int[N];
        boolean[] intree = new boolean[N];
        int[] source = new int[N];
        
        for(int i = 0; i < N; i++){
            distance[i] = Integer.MAX_VALUE;
            intree[i] = false;
        }
        
        int treesize = 1;
        int treecost = 0;
        intree[0] = true;
        
        for(int i = 0; i < N; i++){
            distance[i] = arr[i];
            source[i] = 0;
        }
        
        while(treesize < N){
            int best = Integer.MAX_VALUE;
            int position = -1;
            for(int i = 0; i < N; i++){
                if(intree[i] == false && distance[i] < best){
                    best = distance[i];
                    position = i;
                }
            }
            
            treesize = treesize + 1;
            treecost = treecost + distance[position];
            intree[position] = true;
            
            
            for(int i = 0; i < N; i++){
                if(arr[N*position + i] < distance[i]){
                    distance[i] = arr[N*position + i];
                    source[i] = position;
                }
            }
        }
        out.println(treecost);
        out.close();
    }
    
}
