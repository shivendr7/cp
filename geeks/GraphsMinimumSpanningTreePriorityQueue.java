/*
https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1/

Given a weighted, undirected and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.

 

Example 1:

Input:

Output:
4
Explanation:

The Spanning Tree resulting in a weight
of 4 is shown above.
Example 2:

Input:

Output:
5
Explanation:
Only one Spanning Tree is possible
which has a weight of 5.
 

Your task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function  spanningTree() which takes number of vertices V and an adjacency matrix adj as input parameters and returns an integer denoting the sum of weights of the edges of the Minimum Spanning Tree. Here adj[i] contains a list of lists containing two integers where the first integer j denotes that there is an edge between i and j and second integer w denotes that the distance between edge i and j is w.
 

Expected Time Complexity: O(ElogV).
Expected Auxiliary Space: O(V2).
 

Constraints:
2 ≤ V ≤ 1000
V-1 ≤ E ≤ (V*(V-1))/2
1 ≤ w ≤ 1000
Graph is connected and doesn't contain self loops & multiple edges.
*/
class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    class pair implements Comparable<pair> {
        int u, w;
        pair(int u, int w) {
            this.u=u;
            //this.p=p;
            this.w=w;
        }
        public int compareTo(pair ob) {
            return this.w-ob.w;
        }
    }
    
    int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        PriorityQueue<pair> q=new PriorityQueue<>();
        int ans=0;
        q.add(new pair(0, 0));
        boolean vis[]=new boolean[V];
        
        while(!q.isEmpty()) {
            pair out=q.poll();
            
            if(vis[out.u]) continue;
            vis[out.u]=true;
            ans+=out.w;
            
            for(int i=0;i<adj.get(out.u).size();i++) {
                if(!vis[adj.get(out.u).get(i).get(0)]) {
                    int C=adj.get(out.u).get(i).get(0);
                    int W=adj.get(out.u).get(i).get(1);
                    q.add(new pair(C, W));
                }
            }
        }
        return ans;
    }
}
