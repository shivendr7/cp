/*
Spiderman is stuck in a difficult situation. His arch-enemy the Green Goblin has planted several of his infamous Pumpkin Bombs in various locations in a building. 
Help Spiderman activate his Spidey Sense and identify the impact zones. 
He has a blueprint of the building which is a M x N matrix that is filled with the characters ‘O’, ‘B’, and ‘W’ where: 
‘O’ represents an open space.
‘B’ represents a bomb.
‘W’ represents a wall.
You have to replace all of the O’s (open spaces) in the matrix with their shortest distance from a bomb without being able to go through any walls. Also, replace the bombs
with 0 and walls with -1 in the resultant matrix. If no path exists between a bomb and an open space replace the corresponding 'O' with -1.

Example 1:

Input: N = 3, M = 3
A[] = {{O, O, O}, 
       {W, B, B}, 
       {W, O, O}}
Output: {{2, 1, 1}, 
         {-1, 0, 0},  
         {-1, 1, 1}}
Explanation: The walls at (1,0) and (2,0) 
are replaced by -1. The bombs at (1,1) and 
(1,2) are replaced by 0. The impact zone 
for the bomb at (1,1) includes open spaces 
at index (0,0), (0,1) and (2,1) with distance 
from bomb calculated as 2,1,1 respectively.
The impact zone for the bomb at (1,2) 
includes open spaces at index (0,3) and (2,2) 
with distance from bomb calculated as 1,1 
respectively.

Example 2:

IInput: N = 2, M = 2
A[] = {{O, O},
       {O, O}} 
Output: {{-1, -1}
         {-1, -1}
Your Task:  
You don't need to read input or print anything. Complete the function findDistance() which takes the matrix A[], M, and N as input parameters and the resultant matrix

Expected Time Complexity: O(M*N)
Expected Auxiliary Space: O(M*N)


Constraints:
1 ≤ N*M ≤ 106

hint-BFS
*/
//sol
class Solution
{
    public static int[][] findDistance(char mat[][], int m,int n)
    {
        // Your code goes here
        boolean visited[][]=new boolean[m][n];
        int ans[][]=new int[m][n];
        for(int i=0;i<m;i++) 
            for(int j=0;j<n;j++) 
                ans[i][j]=-1;
        
        Queue<ele> q=new LinkedList<>();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j]=='B') {
                    ele e=new ele(i,j,0);
                    
                    ans[i][j]=0;
                    q.add(e);
                    visited[i][j]=true;
                }
            }
        }
  

        
        while(q.size()>0) {
            
            ele e=q.poll();
            int i=e.x,j=e.y,d=e.dist;
            
            if(mark(i+1,j,d+1,visited,ans,mat)) {
                ele newe=new ele(i+1,j,d+1);
                q.add(newe);
            }
            if(mark(i-1,j,d+1,visited,ans,mat)) {
                ele newe=new ele(i-1,j,d+1);
                q.add(newe);
            }
            if(mark(i,j+1,d+1,visited,ans,mat)) {
                ele newe=new ele(i,j+1,d+1);
                q.add(newe);
            }
            if(mark(i,j-1,d+1,visited,ans,mat)) {
                ele newe=new ele(i,j-1,d+1);
                q.add(newe);
            }
            
        }
        
        return ans;
    }
    
    public static boolean mark(int i,int j,int d,boolean visited[][],int ans[][],char mat[][]) {
        int m=visited.length;
        int n=visited[0].length;
        
        if(i<0||i>m-1||j<0||j>n-1) {
            return false;
        }
        if(mat[i][j]!='O') 
            return false;
        if(visited[i][j]) {
            return false;
        }
        ans[i][j]=d;
        visited[i][j]=true;
        return true;
    }
}

class ele {
     int x;
     int y;
     int dist;
    public ele(int x,int y,int d) {
        this.x=x;
        this.y=y;
        dist=d;
    }
}


