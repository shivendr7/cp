"""
https://leetcode.com/problems/swim-in-rising-water/

On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).

Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim.

You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?

Example 1:

Input: [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.

You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
Example 2:

Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation:
 0  1  2  3  4
24 23 22 21  5
12 13 14 15 16
11 17 18 19 20
10  9  8  7  6

The final route is marked in bold.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
Note:

2 <= N <= 50.
grid[i][j] is a permutation of [0, ..., N*N - 1].

"""
#naive dfs n**4 TC
class Solution:
    
    def dfs(self, g, i, j, val, vis):
        n=len(g)
        if i>n-1 or i<0 or j>n-1 or j<0:
            return False
        if g[i][j]>val or vis[i][j]:
            return False
        if i==n-1 and j==n-1:
            return True
        vis[i][j]=True
        dx=[1, -1, 0, 0]; dy=[0, 0, -1, 1]
        ans=False
        for k in range(4):
            ans=ans or self.dfs(g, i+dx[k], j+dy[k], val, vis)
        return ans
    
    def swimInWater(self, grid: List[List[int]]) -> int:
        n=len(grid)
        ans=0
        for val in range(n**2):
            vis=[[False]*n for i in range(n)]
            if self.dfs(grid, 0, 0, val, vis):
                ans=val
                break
        return ans
      
#highly optimised dijkstra's algorithm TC n**2*log(n) SC n**2
def swimInWater(self, grid: List[List[int]]) -> int:
        moves=[[0,1], [0,-1], [1,0], [-1,0]]
        i, j, ans, n, pq=0, 0, grid[0][0], len(grid), []
        
        while i<n-1 or j<n-1:
            for a,b in moves:
                ni=i+a; nj=j+b
                if ni<0 or ni>n-1 or nj<0 or nj>n-1 or grid[ni][nj]>2500:
                    continue
                heappush(pq, (grid[ni][nj]<<12) + (ni<<6) + nj)
                grid[ni][nj]=3000
            
            nxt=heappop(pq)
            ans=max(ans, (nxt>>12))
            i=(nxt>>6)&((1<<6)-1)
            j=nxt&((1<<6)-1)
        
        return ans


