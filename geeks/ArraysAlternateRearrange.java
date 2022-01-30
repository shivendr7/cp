/*
Similar Logical: https://leetcode.com/problems/rotate-array/
Given an array, rotate the array to the right by k steps, where k is non-negative. Could you do it in-place with O(1) extra space?

sol:
Reverse the whole array.
Then reverse the first k elements.
Finally reverse the remaining elements.
(Do a dry run, it's very easy to understand)
*/

/*
link-https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately-1587115620/1/?category[]=Arrays&category[]=Arrays&difficulty[]=1&page=1&query=category[]Arraysdifficulty[]1page1category[]Arrays

Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively i.e first element should be max value, second should be min value,
third should be second max, fourth should be second min and so on.

Example 1:

Input:
N = 6
arr[] = {1,2,3,4,5,6}
Output: 6 1 5 2 4 3
Explanation: Max element = 6, min = 1, 
second max = 5, second min = 2, and 
so on... Modified array is : 6 1 5 2 4 3.
Example 2:

Input:
N = 11
arr[]={10,20,30,40,50,60,70,80,90,100,110}
Output:110 10 100 20 90 30 80 40 70 50 60
Explanation: Max element = 110, min = 10, 
second max = 100, second min = 20, and 
so on... Modified array is : 
110 10 100 20 90 30 80 40 70 50 60.
Your Task:
The task is to complete the function rearrange() which rearranges elements as explained above. Printing of the modified array will be handled by driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 107
1 <= arr[i] <= 107
*/
class Solution{
    
    // temp: input array
    // n: size of array
    //Function to rearrange  the array elements alternately.
    public static void rearrange(int arr[], int n){
        
        // Your code here
        int max_idx = n - 1, min_idx = 0;

// store maximum element of array
        int max_elem = arr[n - 1] + 1;

// traverse array elements
        for (int i = 0; i < n; i++) {
// at even index : we have to put
// maximum element
            if (i % 2 == 0) {
                arr[i] += (arr[max_idx] % max_elem) * max_elem;
                max_idx--;
            }

// at odd index : we have to put minimum element
            else {
                arr[i] += (arr[min_idx] % max_elem) * max_elem;
                min_idx++;
            }
        }

// array elements back to it's original form
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] / max_elem;
    }
    
}


/*
https://practice.geeksforgeeks.org/problems/rearrange-an-array-such-that-arri-i3618/1/
https://practice.geeksforgeeks.org/problems/reorganize-the-array4810/1/

Given an array of size N that has elements ranging from 0 to N-1. All elements may not be present in the array. If the element is not present then there will be -1 present in the array. Rearrange the array such that A[i] = i, and if i is not present, display -1 at that place.

Example 1:

â€‹Input : arr[ ] = {-1, -1, 6, 1, 9, 3, 2, 
                              -1, 4, -1}
Output : -1 1 2 3 4 -1 6 -1 -1 9
Explanation:
In range 0 to 9, all except 0, 5, 7 and 8 
are present. Hence, we print -1 instead of 
them.

Example 2:

Input : arr[ ] = {0, 1, 2, 3, 4, 5} 
Output : 0 1 2 3 4 5
Your Task:

This is a function problem. The input is already taken care of by the driver code. You only need to complete the function modifyArray() that takes an array (arr), sizeOfArray (n), and return the modified array. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 105
0 ≤ A[i] ≤ N-1

*/
//sol

class Solution{
    // Function for finding maximum and value pair
    public static int[] modifyArray (int arr[], int n) {
        // Complete the function 
        int x=0, temp=0;
        for(int i=0;i<n;i++) {
            if(arr[i]!=-1 && arr[i]!=i) {
                x=arr[i];
                while(arr[x]!=x && arr[x]!=-1) {
                    temp=arr[x];
                    arr[x]=x;
                    x=temp;
                }
                arr[x]=x;
                if(arr[i]!=i) 
                    arr[i]=-1;
            }
        }
        return arr;
    }
}
//O(n)
int * Rearrange(int *arr,int n){
    // Complete the function
    int i=0;
   while(i<n)
   {
       if(arr[i]!=i && arr[i]!=-1)
       {
           swap(arr[i], arr[arr[i]]);
       }
       else
       {
           i++;
       }
   }
   return arr;
}
