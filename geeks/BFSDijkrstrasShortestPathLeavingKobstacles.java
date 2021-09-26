/*
https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/

You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.

Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.

 

Example 1:

Input: 
grid = 
[[0,0,0],
 [1,1,0],
 [0,0,0],
 [0,1,1],
 [0,0,0]], 
k = 1
Output: 6
Explanation: 
The shortest path without eliminating any obstacle is 10. 
The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
Example 2:

Input: 
grid = 
[[0,1,1],
 [1,1,1],
 [1,0,0]], 
k = 1
Output: -1
Explanation: 
We need to eliminate at least two obstacles to find such a walk.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 40
1 <= k <= m * n
grid[i][j] == 0 or 1
grid[0][0] == grid[m - 1][n - 1] == 0



*/
//BFS
class Solution {
    int[] dirs = {0, 1, 0, -1, 0};
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        if (k >= m+n-2) return m+n-2; // if we can go by manhattan distance -> let's go

        boolean[][][] visited = new boolean[m][n][k+1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, k, 0}); // r, c, k, dist
        visited[0][0][k] = true;

        while (!q.isEmpty()) {
            int[] top = q.poll();
            int r = top[0], c = top[1], curK = top[2], dist = top[3];
            if (r == m - 1 && c == n - 1) return dist; // Found the result
            for (int i = 0; i < 4; i++) {
                int nr = r + dirs[i], nc = c + dirs[i + 1];
                if (nr < 0 || nr == m || nc < 0 || nc == n) continue; // skip out of bound cells!
                int newK = curK - grid[nr][nc];
                if (newK >= 0 && !visited[nr][nc][newK]) {
                    visited[nr][nc][newK] = true;
                    q.offer(new int[]{nr, nc, newK, dist + 1});
                }
            }
        }
        return -1; // Not found
    }
}
//Dijkstra's

class Solution {
    int n, m, k;
    int[][] grid;
    
	// direction to go {down, right, up, left}
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    int dijkstra(int sx, int sy, int ex, int ey) {
        boolean[][] isVisited = new boolean[m][n];
        int[][] cost = new int[m][n];
        
        for (int i=0;i<m;i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        
		// PQ prioritized by cost, then obs (obstacle count)
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.cost == b.cost) {
                return a.obs - b.obs;
            }
            return a.cost - b.cost;
        });
        pq.add(new Node(sx, sy, 0, 0));
        cost[sy][sx] = 0;
        
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            
            if (isVisited[node.y][node.x]) {
                continue;
            }
            isVisited[node.y][node.x] = true;
            
            for (int i=0;i<4;i++) {
                int tox = node.x + dx[i];
                int toy = node.y + dy[i];
                
                if (tox >= 0 && tox < n && toy >= 0 && toy < m && node.cost + 1 < cost[toy][tox]) {
                    if (grid[toy][tox] == 0) {
                        cost[toy][tox] = node.cost + 1;
                        pq.add(new Node(tox, toy, node.cost + 1, node.obs));
                    } else {
                        if (node.obs + 1 <= k) {
                            cost[toy][tox] = node.cost + 1;
                            pq.add(new Node(tox, toy, node.cost + 1, node.obs + 1));
                        }
                    }
                }
            }
        }
        return cost[ey][ex];
    }
    
    public int shortestPath(int[][] grid, int k) {
        n = grid[0].length;
        m = grid.length;
        this.k = k;
        this.grid = grid;
        
        int r1 = dijkstra(0, 0, n - 1, m - 1); // dijkstra from (0, 0) to (n-1, m-1)
        int r2 = dijkstra(n - 1, m - 1, 0, 0); // dijkstra from (n-1, m-1) to (0, 0)
        int res = Math.min(r1, r2);
        
        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }
    
    class Node {
        int x, y;
        int cost;
        int obs; // obstacle count
        
        Node(int x, int y, int cost, int obs) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.obs = obs;
        }
    }
}
