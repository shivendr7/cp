"""
https://practice.geeksforgeeks.org/problems/biconnected-graph2528/1/


Given a graph with n vertices, e edges and an array arr[] denoting the edges connected to each other, check whether it is Biconnected or not.
Note: The given graph is Undirected.

 

Example 1:

Input:
n = 2, e = 1
arr = {0, 1}
Output:
1
Explanation:
       0
      /
     1
The above graph is Biconnected.
Example 2:

Input:
n = 3, e = 2
arr = {0, 1, 1, 2}
Output:
0
Explanation:
       0
      /
     1
      \
       2
The above graph is not Biconnected.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function biGraph() which takes 2 Integers n, and e and an array arr of length 2*e as input and returns 1 if the graph is biconnected else returns 0.

 

Expected Time Complexity: O(n+e)
Expected Auxiliary Space: O(n)

 

Constraints:
1 <= e <= 100
2 <= n <= 100
"""
class Solution:
    def biGraph(self, arr, n, e):
        # code here 
        adj=[[] for i in range(n)]
        for i in range(0, len(arr), 2):
            adj[arr[i]].append(arr[i+1])
            adj[arr[i+1]].append(arr[i])
        return self.findAP(n, adj)
    
    def dfs(self, adj, vis, disc, low, par, time, s, bridges):
        vis[s]=1
        disc[s]=low[s]=time[0]
        time[0]+=1
        for i in adj[s]:
            if vis[i]==-1:
                par[i]=s
                self.dfs(adj, vis, disc, low, par, time, i, bridges)
                low[s]=min(low[s], low[i])
                if low[i]>disc[s]:
                    bridges.append([par[i], i])
            elif i!=par[s]:
                low[s]=min(low[s], disc[i])
    
    def findAP(self, n, adj):
        vis, disc, low, par=[-1]*n, [-1]*n, [-1]*n, [-1]*n
        time=[1]
        bridges=[]
        self.dfs(adj, vis, disc, low, par, time, 0, bridges)
        bpoints=set()
        for bridge in bridges:
            bpoints.add(bridge[0])
            bpoints.add(bridge[1])
        ap=[]
        for point in bpoints:
            if len(adj[point])>1:
                ap.append(point)
        if len(ap) or sum(vis)!=n:
            return 0
        return 1
