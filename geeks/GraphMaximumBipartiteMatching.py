# https://practice.geeksforgeeks.org/problems/9a88fe7ada1c49c2b3da7a67b43875e4a76aface/1

"""
There are M job applicants and N jobs.  Each applicant has a subset of jobs that he/she is interested in. Each job opening can only accept one applicant and a job applicant can be appointed for only one job. Given a matrix G with M rows and N columns where G(i,j) denotes ith applicant is interested in the jth job. Find the maximum number of applicants who can get the job.

Example 1:

Input: 
M = 3, N = 5
G = {{1,1,0,1,1},{0,1,0,0,1},
{1,1,0,1,1}}
Output: 3
Explanation: There is one of the possible
assignment-
First applicant gets the 1st job.
Second applicant gets the 2nd job.
Third applicant gets the 4th job.
Example 2:

Input:
M = 6, N = 2
G = {{1,1},{0,1},{0,1},{0,1},
{0,1},{1,0}}
Output: 2
Explanation: There is one of the possible
assignment-
First applicant gets the 1st job.
Second applicant gets the 2nd job.
 

Your Task:
You don't need to read to print anything. Your task is to complete the function maximumMatch() which takes matrix G as input parameter and returns the maximum number of applicants who can get the job.

Expected Time Complexity: O(N3).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N, M ≤ 100
"""

#sol
class Solution:
	def maximumMatch(self, G):
		matched = [-1]*len(G[0])
		ans = 0
		def dfs(u, visited):
		    for i, v in enumerate(G[u]):
		        if v == 1 and i not in visited:
		            visited.add(i)
    		        if matched[i] == -1 or dfs(matched[i], visited):
    		            matched[i] = u
    		            return True
		    return False
	    
	    for u, _ in enumerate(G):
	        if dfs(u, set()):
	            ans += 1
	    return ans
