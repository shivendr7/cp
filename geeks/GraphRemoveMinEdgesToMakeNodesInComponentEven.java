/*
https://practice.geeksforgeeks.org/problems/divisibility-tree1902/1/

Given a tree with n nodes and edge connection between them . The tree is rooted at node 1. Your task is to remove minimum number of edges from the given tree such that the tree converts into disjoint union tree so that nodes of connected component left is divisible by 2.
 

Example 1:

Input: n = 10, edges = {{2,1},{3,1},{4,3},{5,2}
,{6,1},{7,2},{8,6},{9,8},{10,8}}
Output: 2
Explanation: Take two integers at a time i.e. 2 
is connected with 1, 3 is connected with 1,4 is 
connected with 3, 5 is connected with 2 and so 
on. Fig will understand you better.
Original tree:
   
After removing edge 1-3 and 1-6. So ans is 2
because all nodes are even

 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function minimumEdgeRemove() which takes n and edges as input parameter and returns the minimum number of edges which is removed to make the tree disjoint union tree such that the tree converts into disjoint union tree so that nodes of connected component left is divisible by 2.
 

Expected Time Compelxity: O(n)
Expected Space Comeplxity: O(1)
 

Constraints:
1 <= n <= 104
*/
//sol
class Solution
{
    public int minimumEdgeRemove(int n, int[][] edges)
    {
        // Code here 
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i <n-1; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        int[] chidCount = new int[n+1];
        int[] parent = new int[n+1];
        parent[1] = 1;
        boolean[] vis = new boolean[n+1];
        childCount(chidCount,parent,1,graph,vis);
//        System.out.println(Arrays.toString(chidCount));
//        System.out.println(Arrays.toString(parent));
        int count = 0;
        for (int i = 2; i < chidCount.length; i++) {
            if (chidCount[i]%2==0) {
                chidCount[parent[i]] -= chidCount[i];
                parent[i] = i;
                count++;
            }
        }
//        System.out.println(Arrays.toString(chidCount));
//        System.out.println(Arrays.toString(parent));
//        System.out.println(count);
        return count;
    }
    static int childCount(int[] childCount,int[] parent,int root,ArrayList<ArrayList<Integer>> graph, boolean[] vis) {
        if (vis[root]) return 0;
        vis[root] = true;
        childCount[root] += 1;
        for (Integer child : graph.get(root)) {
            if (!vis[child]) {
                childCount[root] += childCount(childCount,parent, child, graph, vis);
                parent[child] = root;
            }
        }
        return childCount[root];
    }
}
