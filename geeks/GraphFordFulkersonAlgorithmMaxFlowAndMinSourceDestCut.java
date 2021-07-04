/*
https://practice.geeksforgeeks.org/problems/find-minimum-s-t-cut-in-a-flow-network2902/1/

Given a weighted graph of N vertices numbered from 0 to N-1 in the form of adjacency matrix A[ ][ ] and two integers S denoting the number of source vertex and T denoting the number of sink vertex. The task is to find minimum capacity s-t cut of the given network. An s-t cut is a cut that requires the source node ‘S’ and the sink node ‘T’ to be in different subsets, and it consists of edges going from the source’s side to the sink’s side. The capacity of an s-t cut is defined by the sum of the capacity of each edge in the cut-set. In other words, you have to find out all the edges which has to be removed to make it impossible to reach the sink node from source node, and the edges you select should have a minimum sum of weights. You have to return all the edges included in the minimum capacity s-t cut and if there are no edges in minimum capacity s-t cut, return "-1".

Example 1:

Input:
N = 2
A[][] = [[0, 3],
         [0, 0]]
S = 0
T = 1
Output:
0 1
Explanation: We have to remove the edge going
from 0th vertex to 1st vertex.
 

Example 2:

Input:
N = 5
A[][] = [[0, 0, 0, 0, 0],
         [0, 0, 2, 3, 0],
         [0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0]]
S = 0
T = 4
Output:
-1
Explanation: There are no edges in 
minimum capacity s-t cut.
Your Task: 
You don't need to read input or print anything. Your task is to complete the function minimumCut() which takes the adjacency matrix A[ ][ ], source node number S, sink node number T and number of vertices N and returns a list of integers res[ ] where res[2*i-1] and res[2*i] denotes an edge in minimum capacity s-t cut where 1 ≤ i ≤ length(res)/2, if there are no edges in minimum capacity s-t cut, return only one integer "-1" in res[ ].

Expected Time Complexity: O(max_flow * N2)
Expected Auxiliary Space: O(N2)


*/
//sol
class Solution{
    
    public boolean bfs(int rgraph[][], int s, int t, int par[]) {
        int n=rgraph.length;
        boolean vis[]=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.add(s);
        par[s]=-1;
        vis[s]=true;
        while(!q.isEmpty()) {
            int v=q.poll();
            for(int i=0;i<n;i++) {
                if(!vis[i] && rgraph[v][i]>0) {
                    par[i]=v;
                    vis[i]=true;
                    q.add(i);
                } 
            }
        }
        return vis[t];
    }
    void dfs(int[][] rGraph, int s, boolean[] visited) {
        visited[s]=true;
        for (int i=0; i<rGraph.length; i++) {
            if (rGraph[s][i] > 0 && !visited[i]) {
                dfs(rGraph, i, visited);
            }
        }
    }
    public int[] minimumCut(ArrayList<ArrayList<Integer>> A, int S, int T, int N) {
        // Your code here
        int n=A.size();
        //Adjacency Matrix Representation
        int graph[][]=new int[n][n];
        int rgraph[][]=new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                graph[i][j]=A.get(i).get(j);
                rgraph[i][j]=A.get(i).get(j);
            }
        }
        
        int u=0, v=0;
        int par[]=new int[n];
        int ans[]=new int[1];
        if(!bfs(rgraph, S, T, par)) { //if no path from S(source) to T(destination) return [-1]
            ans[0]=-1;
            return ans;
        }
        while(bfs(rgraph, S, T, par)) {  //while path exists mark each of node's parent
            int flow=Integer.MAX_VALUE;
            for(v=T; v!=S; v=par[v]) {
                u=par[v];
                flow=Math.min(flow, rgraph[u][v]); //find maxFlow
            }
            for(v=T; v!=S; v=par[v]) { //reduce maxFlow from all nodes
                u=par[v];
                rgraph[u][v] = rgraph[u][v] - flow;
                rgraph[v][u] = rgraph[v][u] + flow;
            }
        }
      
        boolean vis[]=new boolean[n];
        ArrayList<Integer> ansL=new ArrayList<>();
        dfs(rgraph, S, vis);  //visit all residual capacity edges with a dfs
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(graph[i][j] > 0 && vis[i] && !vis[j]) {  //all the edges with visited par and unvisited itself will contribute to answer
                    ansL.add(i);
                    ansL.add(j);
                }
            }
        } //rest is just reporting answer
        ans=new int[ansL.size()];
        for(int i=0;i<ansL.size();i++) {
            ans[i]=ansL.get(i);
        }
        return ans;
    }
}
