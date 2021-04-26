/*
Given an array of integers and another number. Find all the unique quadruple from the given array that sums up to the given number.

Example 1:

Input:
N = 5, K = 3
A[] = {0,0,2,1,1}
Output: 0 0 1 2 $
Explanation: Sum of 0, 0, 1, 2 is equal
to K.
Example 2:

Input:
N = 7, K = 23
A[] = {10,2,3,4,5,7,8}
Output: 2 3 8 10 $2 4 7 10 $3 5 7 8 $
Explanation: Sum of 2, 3, 8, 10 = 23,
sum of 2, 4, 7, 10 = 23 and sum of 3,
5, 7, 8 = 23.
Your Task:
You don't need to read input or print anything. Your task is to complete the function fourSum() which takes the array arr[] and the integer k as its input and returns an array containing all the quadruples in a lexicographical manner. Also note that all the quadruples should be internally sorted, ie for any quadruple [q1, q2, q3, q4] the following should follow: q1 <= q2 <= q3 <= q4.  (In the output each quadruple is separate by $. The printing is done by the driver's code)

Expected Time Complexity: O(N3).
Expected Auxiliary Space: O(N2).

Constraints:
1 <= N <= 100
-1000 <= K <= 1000
-100 <= A[] <= 100
 
*/
//sol
class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] A, int X) {
        // code here
        int l, r; 
  
        // Sort the array in increasing order, using library 
        // function for quick sort 
        Arrays.sort(A); 
        int n = A.length;
         ArrayList<ArrayList<Integer>> list= new ArrayList<>();
        /* Now fix the first 2 elements one by one and find 
           the other two elements */
        for (int i = 0; i < n - 3; i++)  
        { 
            // if (A[i] > 0 && A[i] > X) break;
       
        if (i > 0 && A[i] == A[i - 1]) continue;
            
            for (int j = i + 1; j < n - 2; j++)  
            { 
                // Initialize two variables as indexes of the first and last  
                // elements in the remaining elements 
                if (j > i + 1 && A[j] == A[j - 1]) continue;
                
                l = j + 1; 
                r = n - 1; 
  
                // To find the remaining two elements, move the index  
                // variables (l & r) toward each other. 
                while (l < r)  
                { 
                    int old_l = l;
                    int old_r = r;
                    if (A[i] + A[j] + A[l] + A[r] == X)  
                    { 
                       ArrayList<Integer> aList=new ArrayList<>();
                            aList.add(A[i]);
                            aList.add(A[j]);
                            aList.add(A[l]);
                            aList.add(A[r]);
                            list.add(aList);
                            
                        while (l < r && A[l] == A[old_l]) l++;
                        while (l < r && A[r] == A[old_r]) r--;
                    }  
                    else if (A[i] + A[j] + A[l] + A[r] < X) 
                        l++; 
                    else // A[i] + A[j] + A[l] + A[r] > X 
                        r--; 
                } 
            } 
        }
        return list;
    }
}
