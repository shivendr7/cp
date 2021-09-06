/*
https://leetcode.com/problems/sum-of-distances-in-tree/

There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.

You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.

Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.

 

Example 1:


Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
Output: [8,12,6,10,10,10]
Explanation: The tree is shown above.
We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
equals 1 + 1 + 2 + 2 + 2 = 8.
Hence, answer[0] = 8, and so on.
Example 2:


Input: n = 1, edges = []
Output: [0]
Example 3:


Input: n = 2, edges = [[1,0]]
Output: [1,1]
 

Constraints:

1 <= n <= 3 * 104
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
The given input represents a valid tree.
*/
//sol
class Solution {
    /*
    void dfs(int u, ArrayList<ArArrayList<ArrayList<Integer>>rayList<Integer>> adj, int d[], int D) {
        if(d[u]!=-1) return;
        d[u]=D;
        for(int v:adj.get(u)) 

           dfs(v, adj, d, D+1);
           }
               

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) 
            adj.add(new ArrayList<Integer>());
        for(int i=0;i<n-1;i++) {
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            }
        int d[]=new int[n];
        Arrays.fill(d, -1);
        dfs(0, adj, d, 0);
        int s=0;
        for(int i=0;i<n;i++) s+=d[i];
        for(int i=0;i<n;i++) 
            d[i]=s-d[i];
        return d;
    }*/
    ArrayList<Integer>[] adj;
    int [] ans;
    int [] subtree;

    int dfs(int v,int par,ArrayList<Integer> adj[], int [] subtree){
        int curr = 0;
        int n = adj[v].size();
        for(int i = 0; i < n; i++){
            int u = adj[v].get(i);
            if(u!=par){
                curr+=dfs(u,v,adj,subtree);
                curr+=subtree[u];
                subtree[v]+=subtree[u];
            }
        }
        return curr;
    }
    void dfs(int v,int par,ArrayList<Integer>  adj[],int [] ans,int [] subtree,int now){
        ans[v] = now;
        for(Integer u:adj[v]){
            if(u!=par)
                dfs(u,v,adj,ans,subtree,now-subtree[u]+subtree[0]-subtree[u]);
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        ans = new int [n];
        subtree = new int [n];
        Arrays.fill(subtree, 1);

        int m = edges.length;
        for(int i = 0; i < m; i++){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        int root_ans = dfs(0,-1,adj,subtree); // consider node 0 as root, so no parent
        dfs(0,-1,adj,ans,subtree,root_ans);
        return ans;
    }
}
