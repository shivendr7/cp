/*
Given a Directed Graph with V vertices and E edges, check whether it contains any cycle or not.


Example 1:

Input:



Output: 1
Explanation: 3 -> 3 is a cycle

Example 2:

Input:


Output: 0
Explanation: no cycle in the graph

Your task:
You don’t need to read input or print anything. Your task is to complete the function isCyclic() which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the given directed graph contains a cycle or not.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ V, E ≤ 105
*/
//sol
public:

	bool topoSort(int V, vector<int> adj[])
    { 
     int visited=0;
     int indegree[V] = {0};
     for(int i =0;i<V;i++)
     {
         for(int j =0;j<adj[i].size();j++)
         {
             indegree[adj[i][j]]++;
         }
     }
    
     queue<int> q;
     for(int i =0;i<V;i++)
     {
         if(indegree[i]==0)
         q.push(i);
     }
     while(!q.empty())
     {
         int u =q.front();
         q.pop();
         
         visited++;
         for(int j =0; j <adj[u].size();j++)
         {
             indegree[adj[u][j]]--;
             if(indegree[adj[u][j]]==0)
             q.push(adj[u][j]);
         }
     }
    if(visited<V)
    return true;
    else
    return false;
    }
    
    bool isCyclic(int V, vector<int> adj[])
    {
        return topoSort(V,adj);
    }
