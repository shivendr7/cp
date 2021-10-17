/*
https://practice.geeksforgeeks.org/problems/minimum-insertions-to-make-two-arrays-equal/1

Given two Arrays A[] and B[] of length N and M respectively. Find the minimum number of insertions and deletions on the array A[], required to make both the arrays identical.
Note: Array B[] is sorted and all its elements are distinct.

 

Example 1:

Input:
N = 5, M = 3
A[] = {1, 2, 5, 3, 1}
B[] = {1, 3, 5}
Output:
4
Explanation:
We need to delete 2 and replace it with 3.
This costs 2 steps. Further, we will have to
delete the last two elements from A to
obtain an identical array to B. Overall, it
results in 4 steps.
Example 2:
Input:
N = 2, M = 2
A[] = {1, 4}
B[] = {1, 4}
Output :
0
Explanation:
Both the Arrays are already identical.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function minInsAndDel() which takes two integers N and M, and two arrays A of size N and B of size M respectively as input and returns the minimum insertions and deletions required.


Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 105
1 ≤ A[i], B[i] ≤ 105
*/
//sol
class Solution {
    
    static int minInsAndDel(int[] A, int[] B, int N, int M) {
       // code here
       List<Integer> a = new ArrayList<>();
       Set<Integer> set = new HashSet<>();
       for(int i=0; i<M; i++)
       {
           set.add(B[i]);  //added sorted 
       }
       
       for(int i=0; i<N; i++) {
           if(set.contains(A[i])) {
               a.add(A[i]);
           }
       }
       //System.out.println(a);
       int l = LIS(a.stream().mapToInt(Integer::intValue).toArray());
       return N-l+M-l;
    }
    
    static int LIS(int arr[]) {
       if(arr.length == 0) {
           return 0;
       }
       int[] tail = new int[arr.length];
       int len = 1;
       tail[0] = arr[0];
       
       for(int i = 1; i < arr.length; i++) {
           if(arr[i] > tail[len - 1]) {
               tail[len++] = arr[i];
           } else {
               int id = Arrays.binarySearch(tail, 0, len-1, arr[i]);
               if (id < 0) {
                   id = -1*id - 1;
               }
               tail[id] = arr[i];
           }
       }
       return len;
    }
};
