// <editor-fold defaultstate="collapsed" desc="Djikstra's Shortest Path">
/*
# distance(j) is distance from source vertex to vertex j
# parent(j) is the vertex that precedes vertex j in any shortest path
#                  (to reconstruct the path subsequently) 

 1 For all nodes i
 2     distance(i) = infinity         	# not reachable yet
 3     visited(i) = False
 4     parent(i) = nil	# no path to vertex yet 

 5 distance(source) = 0	# source -> source is start of all paths
 6 parent(source) = nil
 7   8 while (nodesvisited < graphsize)
 9     find unvisited vertex with min distance to source; call it vertex i
10     assert (distance(i) != infinity, "Graph is not connected") 

11     visited(i) = True	# mark vertex i as visited 

    # update distances of neighbors of i
12     For all neighbors j of vertex i
13         if distance(i) + weight(i,j) < distance(j) then
14             distance(j) = distance(i) + weight(i,j)
15             parent(j) = i
*/
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Prim's Minimal Spanning Tree">
/*
 # distance(j) is distance from tree to node j
  # source(j) is which node of so-far connected MST
  #                      is closest to node j
 1   For all nodes i
 2     distance(i) = infinity        # no connections
 3     intree(i) = False             # no nodes in tree
 4     source(i) = nil 

 5   treesize = 1                    # add node 1 to tree
 6   treecost = 0                   
 7   intree(1) = True
 8   For all neighbors j of node 1   # update distances
 9      distance(j) = weight(1,j)
10     source(j) = 1 

11   while (treesize < graphsize)
12     find node with minimum distance to tree; call it node i
13     assert (distance(i) != infinity, "Graph Is Not Connected") 

    # add edge source(i),i to MST
14     treesize = treesize + 1
15     treecost = treecost + distance(i)
16     intree(i) = True              # mark node i as in tree 

    # update distance after node i added
17     for all neighbors j of node i
18       if (distance(j) > weight(i,j))
19         distance(j) = weight(i,j)
20         source(j) = i
*/
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Dynamic Programming Tips">
/*
A programming technique that dramatically reduces the runtime of algorithms:
from exponential to polynomial. The basic idea is to try to avoid solving the
same problem or subproblem twice.

Build larger solutions based on previously found solutions. 
This building-up of solutions often yields programs that run very quickly.
For the previous programming challenge, the main subproblem was: 
Find the largest decreasing subsequence (and its first value) for numbers
to the `right' of a given element.
*/
// </editor-fold>

/*
ID: andy.sc1
LANG: JAVA
TASK: fact4
*/

import java.io.*;
import java.util.*;

public class fact4 {
    static int zeroes(int n)
    {
        int count = 0;
        for (int i = 5; n / i >= 1; i *= 5)
            count += n / i;
 
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("fact4.in"));
        PrintWriter out = new PrintWriter(new FileWriter("fact4.out"));

        // TODO code application logic here
        int n = Integer.parseInt(f.readLine());
        //keep the last digit of the number, excluding 2's and 5's
        int count = zeroes(n);
        int lastnonzero = 1;
        for(int i = 1; i <= n; i++){
            int temp = i;
            while(temp%5 == 0){
                temp /= 5;
            }
            while(temp%2 == 0 && count > 0){
                temp /= 2;
                count--;
            }
            lastnonzero*=temp;
            lastnonzero = lastnonzero % 10;
        }
        out.println(lastnonzero);
        out.close();
    }

}
