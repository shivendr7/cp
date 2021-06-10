/*
link- https://practice.geeksforgeeks.org/problems/maximum-subset-xor/1#
Must View- https://www.cdn.geeksforgeeks.org/find-the-maximum-subarray-xor-in-a-given-array/  (soln using trie)

Given an array arr[] of N positive integers. Find an integer denoting the maximum XOR subset value in the given array arr[].

Example 1:

Input : 
N = 3
arr[] = {2, 4, 5}
Output : 7
Explanation : 
The subset {2, 5} has maximum 
subset XOR value.
Example 2 :

Input : 
N= 3
arr[] = {9, 8, 5}
Output : 13
Explanation : 
The subset {8, 5} has maximum 
subset XOR value.
Your Task :
You don't need to read input or print anything. Your task is to complete the function maxSubarrayXOR() which takes the array and an integer as input and returns the maximum subset XOR value.
 
Expected Time Complexity : O(N*Log(max(arr[i])))
Expected Auxiliary Space : O(1)
 
Contraints :
1 <= N <= 105
1 <= arr[i] <= 106
*/
//sol pretty straight forward
class Solution
{
    public static int maxSubarrayXOR(int set[], int n)
    {
        //add code here.
        // Initialize index of
        // chosen elements
        int index = 0;
    
        // Traverse through all
        // bits of integer
        // starting from the most
        // significant bit (MSB)
        for (int i = 32 - 1; i >= 0; i--) 
        {
            // Initialize index of
            // maximum element and
            // the maximum element
            int maxInd = index;
            int maxEle = Integer.MIN_VALUE;
            for (int j = index; j < n; j++) {
                
                // If i'th bit of set[j]
                // is set and set[j] is
                // greater than max so far.
                if ((set[j] & (1 << i)) != 0 && set[j] > maxEle)
                {
                maxEle = set[j];
                maxInd = j;
                }
            }
        
            // If there was no
            // element with i'th
            // bit set, move to
            // smaller i
            if (maxEle == -2147483648)
                continue;
        
            // Put maximum element
            // with i'th bit set
            // at index 'index'
            int temp = set[index];
            set[index] = set[maxInd];
            set[maxInd] = temp;
        
            // Update maxInd and
            // increment index
            maxInd = index;
        
            // Do XOR of set[maxIndex]
            // with all numbers having
            // i'th bit as set.
            for (int j = 0; j < n; j++) {
                
                // XOR set[maxInd] those
                // numbers which have the
                // i'th bit set
                if (j != maxInd && (set[j] & (1 << i)) != 0)
                set[j] = set[j] ^ set[maxInd];
            }
        
            // Increment index of
            // chosen elements
            index++;
        }
    
        // Final result is
        // XOR of all elements
        int res = 0;
        for (int i = 0; i < n; i++)
            res ^= set[i];
        return res;
    }
}
