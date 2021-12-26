/*    MUST DO
link:https://practice.geeksforgeeks.org/problems/max-rectangle/1#

Given a binary matrix. Find the maximum area of a rectangle formed only of 1s in the given matrix.

Example 1:

Input:
n = 4, m = 4
M[][] = {{0 1 1 0},
         {1 1 1 1},
         {1 1 1 1},
         {1 1 0 0}}
Output: 8
Explanation: For the above test case the
matrix will look like
0 1 1 0
1 1 1 1
1 1 1 1
1 1 0 0
the max size rectangle is 
1 1 1 1
1 1 1 1
and area is 4 *2 = 8.
Your Task: 
Your task is to complete the function maxArea which returns the maximum size rectangle area in a binary-sub-matrix with all 1’s. The function takes 3 arguments the first argument is the Matrix M[ ] [ ] and the next two are two integers n and m which denotes the size of the matrix M. 

Expected Time Complexity : O(n*m)
Expected Auixiliary Space : O(m)

Constraints:
1<=n,m<=1000
0<=M[][]<=1
*/
class GfG {
    public int maxArea(int a[][], int m, int n) {
        // add code here.
        /*
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }*/
        
        for(int i=1;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(a[i][j]==1) {
                    a[i][j]+=a[i-1][j];
                }
            }
        }
        /*
        System.out.println();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }*/
        
        int maxar=0;
        for(int i=0;i<m;i++) {
            Stack<Integer> ra=new Stack<Integer>();
            int rowar=0;
            int j=0;
            while(j<n) {
                if(ra.empty()||a[i][ra.peek()]<=a[i][j]) {
                    ra.push(j++);
                }
                
                else {
                    int start=0;
                    if(!ra.empty()) {
                        int h=a[i][ra.peek()];
                        start=ra.peek();
                        ra.pop();
                        int ar=h*j;
                        if(!ra.empty())
                            ar=h*(j-ra.peek()-1);
                        rowar=rowar<ar?ar:rowar;
                        //ra.push(j);
                    }
                }
            }
            while(!ra.empty()) {
                int h=a[i][ra.peek()];
                int start=ra.peek();
                ra.pop();
                int ar=h*j;
                if(!ra.empty())
                    ar=h*(j-ra.peek()-1);
                rowar=rowar<ar?ar:rowar;
            }
            
            maxar=maxar<rowar?rowar:maxar;
            //System.out.println("row="+i+" rowar="+rowar);
        }
        return maxar;
        
    }
}

/*
https://practice.geeksforgeeks.org/problems/find-the-largest-rectangle-of-1s-with-swapping-of-columns-allowed0243/1

Given a matrix mat of size R*C with 0 and 1’s, find the largest rectangle of all 1’s in the matrix. The rectangle can be formed by swapping any pair of columns of given matrix.

Example 1:

Input: 
R = 3, C = 5
mat[][] = {{0, 1, 0, 1, 0},
           {0, 1, 0, 1, 1},
           {1, 1, 0, 1, 0}};
Output: 6
Explanation: The largest rectangle's area
is 6. The rectangle can be formed by
swapping column  2 with 3. The matrix
after swapping will be
     0 0 1 1 0
     0 0 1 1 1
     1 0 1 1 0
Example 2:

Input:
R = 4, C = 5
mat[][] = {{0, 1, 0, 1, 0},
           {0, 1, 1, 1, 1},
           {1, 1, 1, 0, 1},
           {1, 1, 1, 1, 1}};
Output: 9
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxArea() which takes the 2D array of booleans mat, r and c as parameters and returns an integer denoting the answer.

Expected Time Complexity: O(R*(R + C))
Expected Auxiliary Space: O(R*C)

Constraints:
1<= R,C <=103
0 <= mat[i][j] <= 1
*/
//sol
class Solution {
    
    int maxArea(boolean[][] mat, int r, int c) {
        int bar[][] = new int[r][c];
        for(int i=0; i<r ; i++ ){
            for(int j=0;j<c;j++){
                bar[i][j] = (mat[i][j]== true)? 1:0;
                if( i > 0){
                    if(bar[i][j] != 0 ){
                        bar[i][j] += bar[i-1][j];
                    }
                }
            }
        }
        int ans = 0;
        for(int []a:bar){
            ans = Math.max(ans, getMaxArea(a, c));
        }
        return ans;
    }
    
    int getMaxArea( int []a, int n ){
        // since we can swap any columns
        Arrays.sort(a);
        int ans = 0;
        for(int i=0; i< n ; i++ ){
            ans= Math.max(ans, (a[i] * (n-i))  );
        }    
        return ans;
    }
}
