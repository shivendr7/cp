/*
https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1#

Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, Find the number of strongly connected components in the graph.
 

Example 1:

Input:

Output:
3
Explanation:

We can clearly see that there are 3 Strongly
Connected Components in the Graph
Example 2:

Input:

Output:
1
Explanation:
All of the nodes are connected to each other.
So, there's only one SCC.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function kosaraju() which takes the number of vertices V and adjacency list of the graph as inputs and returns an integer denoting the number of strongly connected components in the given graph.
 

Expected Time Complexity: O(V+E).
Expected Auxiliary Space: O(V).
 

Constraints:
1 ≤ V ≤ 5000
0 ≤ E ≤ (V*(V-1))
0 ≤ u, v ≤ N-1
Sum of E over all testcases will not exceed 25*106
*/
//sol
class Solution
{
    //Function to find number of strongly connected components in the graph.
    public void fillthestack(ArrayList<ArrayList<Integer>> adj,int src,boolean[] visited,Stack<Integer> st)
    {
        visited[src] = true;
        for(int nbr:adj.get(src))
        {
            if(visited[nbr] == false)
            {
                fillthestack(adj,nbr,visited,st);
            }
        }
        st.push(src);
    }
    public ArrayList<ArrayList<Integer>> reverse(ArrayList<ArrayList<Integer>> adj,int vtces)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i=0;i<vtces;i++)
        {
            res.add(i,new ArrayList<Integer>());
        }
        for(int i=0;i<vtces;i++)
        {
            for(int j=0;j<adj.get(i).size();j++)
            {
                res.get(adj.get(i).get(j)).add(i);
            }
        }
        return res;
    }
    public void scc_component(ArrayList<ArrayList<Integer>> gp,int src,boolean[] visited)
    {
        //System.out.print(src+" ");
        visited[src] = true;
        for(int nbr:gp.get(src))
        {
            if(visited[nbr] == false)
            {
                scc_component(gp,nbr,visited);
            }
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {

        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i] == false)
            {
                fillthestack(adj,i,visited,st);
            }
        }
        ArrayList<ArrayList<Integer>> revres = reverse(adj,V);
       
        visited = new boolean[V];
        int count = 0;
        while(st.size()!=0)
        {
            int i = st.pop();
            if(visited[i] == false)
            {
                scc_component(revres,i,visited);
                count++;
            }
        }
        return count;
    }
}
