/*
Given an array containing 0s and 1s. Find the number of subarrays having equal number of 0s and 1s.

Example 1:

Input:
n = 7
A[] = {1,0,0,1,0,1,1}
Output: 8
Explanation: The index range for the 8 
sub-arrays are: (0, 1), (2, 3), (0, 3), (3, 4), 
(4, 5) ,(2, 5), (0, 5), (1, 6)
Example 2:

Input:
n = 5
A[] = {1,1,1,1,0}
Output: 1
Explanation: The index range for the 
subarray is (3,4).
Your Task:
You don't need to read input or print anything. Your task is to complete the function countSubarrWithEqualZeroAndOne() which takes the array arr[] and the size of the array as inputs and returns the number of subarrays with equal number of 0s and 1s.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).
*/
//sol
class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        // add your code here
        HashMap<String, Integer> map=new HashMap<>();
        int c=0;
        int o=0,z=0;
        String key=z-o+"";
        map.put(key,1);
        for(int i=0;i<n;i++) {
            if(arr[i]==0) {
                z++;
            }
            if(arr[i]==1) {
                o++;
            }
            key=z-o+"";
            if(map.get(key)!=null) {
                c+=map.get(key);
                map.put(key,map.get(key)+1);
            }
            else {
                map.put(key,1);
            }
        }
        return c; 
    }
}

/*
https://practice.geeksforgeeks.org/problems/left-or-right-positioned-array5757/1/

Given an array arr[] of size n>3, the task is to check whether the given array can be arranged in the form of a Left or Right positioned array?
Left or Right Positioned Array means each element in the array is equal to the number of elements to its left or number of elements to its right.
Note: 1 represents true and 0 represents false.

 

Example 1:

Input  : 
arr[] = {1, 3, 3, 2}
Output : 
1
Explanation :
This array has one such arrangement {3, 1, 2, 3}.
In this arrangement, first element '3' indicates
that three numbers are after it, the 2nd element
'1' indicates that one number is before it, the
3rd element '2' indicates that two elements are
before it.
 

Example 2:

Input : 
arr[] = {1, 6, 5, 4, 3, 2, 1}
Output :
0
Explanation :
No such arrangement is possible
 

Example 3:

Input : 
arr[] = {2, 0, 1, 3}
Output: 
1
Explanation :
Possible arrangement is {0, 1, 2, 3}
 

Example 4:

Input : 
arr[] = {2, 1, 5, 2, 1, 5}
Output : 
"1"
Explanation :
Possible arrangement is {5, 1, 2, 2, 1, 5}


Your Task:
You don't need to print anything, printing is done by the driver code. You have to complete the function leftRight() which takes the array arr[] and its size N as inputs and returns True if the array can be arranged to form left or right positioned array, else False as the answer.
 


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)



Constraints:
4 ≤ N ≤ 100000
0 ≤ arr[i] ≤ 1000
*/
//sol
class Solution {

     // Function to check Left or Right Positioned
    // Array.
    // arr[] is array of n elements
    // visited[] is boolean array of size n
    public static boolean leftRight(int arr[], int n)
    {
        // Your code goes here 
        int a[]=new int[n];
        for(int j=0;j<n;j++)
            a[j]=-1;
        for(int i=0;i<n;i++)
        {
            if(arr[i]>=n)
                return false;
            if(a[arr[i]]==-1)
                a[arr[i]]=arr[i];
            else if(a[n-arr[i]-1]==-1)
                a[n-arr[i]-1]=arr[i];
            else
                return false;
        }
        return true;
    }
}
