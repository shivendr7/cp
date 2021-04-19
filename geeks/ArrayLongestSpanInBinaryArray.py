"""
Given two binary arrays arr1[] and arr2[] of same size N. Find length of the longest common span [i, j] where j>=i such that arr1[i] + arr1[i+1] + …. + arr1[j] = arr2[i] + arr2[i+1] + …. + arr2[j]. 

 

Example 1:

Input:
N = 6
Arr1[] = {0, 1, 0, 0, 0, 0}
Arr2[] = {1, 0, 1, 0, 0, 1}
Output: 4
Explanation: The longest span with same
sum is from index 1 to 4 following zero 
based indexing.
 

Your Task:
You don't need to read input or print anything. Complete the function longestCommonSum() which takes two arrays arr1, arr2 and integer n as input parameters and returns the length of the longest common span.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1 <= N <= 105
0 <= Arr1[i], Arr2[i] <= 1
"""
#sol
class Solution:
	def longestCommonSum(self, arr1, arr2, n): 
		# code here 
		maxLen = 0
     
    # Initialize prefix sums of two arrays
        presum1 = presum2 = 0
     
    # Create a dictionary to store indices
    # of all possible sums
        diff = {}
     
    # Traverse both arrays
        for i in range(n):
       
        # Update prefix sums
            presum1 += arr1[i]
            presum2 += arr2[i]
         
        # Compute current diff which will be
        # used as index in diff dictionary
            curr_diff = presum1 - presum2
         
        # If current diff is 0, then there
        # are same number of 1's so far in
        # both arrays, i.e., (i+1) is
        # maximum length.
            if curr_diff == 0:
                maxLen = i+1 
            elif curr_diff not in diff:
                # save the index for this diff
                diff[curr_diff] = i
            else:                 
                # calculate the span length
                length = i - diff[curr_diff]
                maxLen = max(maxLen, length)
         
        return maxLen
