/*
link-https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3638/
In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:

Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
C_1 is at location (0, 0) (ie. has value grid[0][0])
C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.

 

Example 1:

Input: [[0,1],[1,0]]


Output: 2

Example 2:

Input: [[0,0,0],[1,1,0],[1,1,0]]


Output: 4

 

Note:

1 <= grid.length == grid[0].length <= 100
grid[r][c] is 0 or 1
*/
//sol lit af
class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        y,x = len(grid)-1, len(grid[0])-1
        q = [[0,0,1]]
        if grid[0][0] or grid[y][x]: return -1
        while len(q):
            i,j,d = q.pop(0)
            if i == y and j == x: return d
            for a in range(max(i-1,0),min(i+2,y+1)):
                for b in range(max(j-1,0),min(j+2,x+1)):
                    if grid[a][b] == 0:
                        grid[a][b] = 1
                        q.append([a,b,d+1])
        return -1
