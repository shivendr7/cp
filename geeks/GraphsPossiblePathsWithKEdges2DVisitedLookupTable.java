/*
https://practice.geeksforgeeks.org/problems/possible-paths3834/1/

Given a directed graph and two vertices ‘u’ and ‘v’ in it, count all the possible walks from ‘u’ to ‘v’ with exactly k edges on the walk.
 

Example 1:

Input 1: graph = {{0,1,1,1},{0,0,0,1}, 
{0,0,0,1}, {0,0,0,0}}, u = 0, v = 3, k = 2
Output: 2
Explanation: Let source ‘u’ be vertex 0, 
destination ‘v’ be 3 and k be 2. The output 
should be 2 as there are two walk from 0 to 
3 with exactly 2 edges. The walks are {0, 2, 3}
and {0, 1, 3}.
  
 

Your Task: You don't need to read or print anything. Your task is to complete the function MinimumWalk() which takes graph, u, v and k as input parameter and returns total possible paths from u to v using exactly k edges. 

Note: In graph if graph[i][j] = 1, it means there is an edge between vertex i to j.
 

Expected Time Complexity: O(n3)
Expected Space Complexity: O(n3)
 

Constraints:
1 <= n <= 50
1 <= k <= n
0 <= u, v <= n-1
*/
//sol
/*
For this sol..
Must think-
self loops
loops
all possible paths without stackoverflow (hot)
*/
class Solution
{
    public int dfs(int[][]graph, int[][]visited, int u, int dest, int k) {
        if(u==dest && k==0){
            return 1;
        }    
        
        if(k==0){
            return 0;
        }
        if(visited[u][k]!=-1){
            return visited[u][k];
        }
        
        int count =0;
        
        for(int v=0; v<graph[u].length;v++){
            
            if(graph[u][v]==1){
                count += dfs(graph, visited, v, dest, k-1);        
            }
        }
        
        return visited[u][k] = count;
    }
    
    public int MinimumWalk(int[][] graph, int u, int v, int k) {
        int n = graph.length;
        int m = graph[0].length;
        
        int[][]visited = new int[n][k+1];
        
        for(int[]i : visited){
            Arrays.fill(i,-1);
        }
        
        return dfs(graph, visited, u, v, k);
    }
}
