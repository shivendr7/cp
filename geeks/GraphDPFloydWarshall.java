/*
https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1

The problem is to find the shortest distances between every pair of vertices in a given edge-weighted directed graph. The graph is represented as an adjacency matrix of size n*n. Matrix[i][j] denotes the weight of the edge from i to j. If Matrix[i][j]=-1, it means there is no edge from i to j.
Do it in-place.
*/
class Solution
{
    public void shortest_distance(int[][] dist)
    {
        // Code here 
            
        int k, i, j, V=dist.length;
	    for (k = 0; k < V; k++) { // intermediate vertex
            // Pick all vertices as source one by one
            for (i = 0; i < V; i++) {
                // Pick all vertices as destination for the
                // above picked source
                for (j = 0; j < V; j++) {
                    // If no path through k
                    // continue
                    if (dist[k][j] == -1 || dist[i][k] == -1)
                        continue;
                    // If vertex k is on the shortest path from
                    // i to j, then update the value of
                    // dist[i][j]
                    if (dist[i][j]==-1 || dist[i][j] > (dist[i][k] + dist[k][j]))
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }

}
