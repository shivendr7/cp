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
