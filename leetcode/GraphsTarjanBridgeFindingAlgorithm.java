/*
There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:



Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
 

Constraints:

1 <= n <= 10^5
n-1 <= connections.length <= 10^5
connections[i][0] != connections[i][1]
There are no repeated connections.
*/

/*
Idea:
If we think of the network and its connections like an undirected graph and its edges, then a critical connection, as defined by this problem, is the same as a bridge in the graph. To find out which edges are bridges, we can employ Tarjan's Bridge-Finding Algorithm (TBFA).

TBFA is a bit like a combination of a depth-first search (DFS) approach with recursion and a union-find. IN TBFA, we do a recursive DFS on our graph and for each node we keep track of the earliest node that we can circle back around to reach. By doing this, we can identify whether a given edge is a bridge because the far node doesn't lead back to any other earlier node.

To implement our TBFA, the first thing we have to do is to construct an edge map (edgeMap) from the connections list. Each key in our edge map should correspond to a specific node, and its value should be an array of each adjacent node to the key node.

We'll also need separate arrays to store the discovery time (disc) and the lowest future node (low) for each node, as well as a time counter to use with disc.

For our recursive DFS helper (dfs), each newly-visited node should set its initial value for both disc and low to the current value of time before time is incremented. (Note: If we start time at 1 instead of 0, we can use either disc or low as a visited array, rather than having to keep a separate array for the purpose. Any non-zero value in the chosen array will then represent a visited state for the given node.)

Then we recursively call dfs on each of the unvisited adjacent nodes (next) of the current node (curr). If one of the possible next nodes is an earlier node (disc[next] < curr[low]), then we've found a loop and we should update the low value for the current node. As each layer of the recursive function backtracks, it will propagate this value of low back down the chain.

If, after backtracking, the value of low[next] is still higher than low[curr], then there is no looped connection, meaning that the edge between curr and next is a bridge, so we should add it to our answer array (ans).

Once the dfs helper function has completed its traversal, we can return ans.
*/
//sol
class Solution {
    int[] disc, low;
    int time = 1;
    List<List<Integer>> ans = new ArrayList<>();
    Map<Integer,List<Integer>> edgeMap = new HashMap<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        disc = new int[n];
        low = new int[n];
        for (int i = 0; i < n; i++)
            edgeMap.put(i, new ArrayList<Integer>());
        for (List<Integer> conn : connections) {
            edgeMap.get(conn.get(0)).add(conn.get(1));
            edgeMap.get(conn.get(1)).add(conn.get(0));
        }
        dfs(0, -1);
        return ans;
    }
    public void dfs(int curr, int prev) {
        disc[curr] = low[curr] = time++;
        for (int next : edgeMap.get(curr)) {
            if (disc[next] == 0) {
                dfs(next, curr);
                low[curr] = Math.min(low[curr], low[next]);
            } else if (next != prev)
                low[curr] = Math.min(low[curr], disc[next]);
            if (low[next] > disc[curr]) 
                ans.add(Arrays.asList(curr, next));
        }
    }
}
