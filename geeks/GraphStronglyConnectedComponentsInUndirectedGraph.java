/*
View the submissions **
https://practice.geeksforgeeks.org/problems/critical-connections/1/

Given an undirected Connected graph of V vertices and E edges.
A critical connection is an edge that, if removed, will make some nodes unable to reach some other nodes. Find all critical connections in the graph.
Note: There are many possible orders for the answer. You are supposed to print the edges in sorted order, and also an edge should be in sorted order 
too. So if there's an edge between node 1 and 2, you should print it like (1,2) and not (2,1).


Example 1:

Input:

Output:
0 1
0 2
Explanation: 
Both the edges in the graph are Crtical
connections.
Example 2:

Input:

Output:
2 3
Explanation:
The edge between nodes 2 and 3 is the only
Critical connection in the given graph.

Your task:
You don’t need to read input or print anything. Your task is to complete the function criticalConnections() which takes the integer V denoting the number of vertices and an adjacency list adj as input parameters and returns  a list of lists containing the Critical connections in the sorted order.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)


*/
//sol
class Solution
{
    ArrayList<ArrayList<Integer>> ans;
    public ArrayList<ArrayList<Integer>> criticalConnections(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        ans=new ArrayList<>();
        boolean vis[]=new boolean[V];
        int par[]=new int[V];
        int disc[]=new int[V];
        int low[]=new int[V];
        par[0]=-1;
        dfs(adj, vis, 0, par, low, disc, 0);
        Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                for(int i=0;i<2;i++) {
                    if(a.get(i)>b.get(i)) return 1;
                    else if(a.get(i)<b.get(i)) return -1;
                }
                return 0;
            }
        });
        return ans;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], int u, int par[], int low[], int disc[], int time) {
        vis[u]=true;
        low[u]=disc[u]=++time;
        for(int v:adj.get(u)) {
            if(!vis[v]) {
                par[v]=u;
                dfs(adj, vis, v, par, low, disc, time);
                low[u]=Math.min(low[u], low[v]);
                if(low[v]>disc[u]) {
                    ArrayList<Integer> t=new ArrayList<>();
                    t.add(u); t.add(v);
                    Collections.sort(t);
                    ans.add(t);
                }
            }
            else if(par[u]!=v) {
                low[u]=Math.min(low[u], disc[v]);
            }
        }
    }
}
