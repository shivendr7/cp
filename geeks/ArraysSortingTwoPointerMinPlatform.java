/*

link-https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1/

Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the 
railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same 
for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of time, same 
platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms,

 

Example 1:

Input: n = 6 
arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
Output: 3
Explanation: 
Minimum 3 platforms are required to 
safely arrive and depart all trains.
Example 2:

Input: n = 3
arr[] = {0900, 1100, 1235}
dep[] = {1000, 1200, 1240}
Output: 1
Explanation: Only 1 platform is required to 
safely manage the arrival and departure 
of all trains. 
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function findPlatform() which takes the array arr[] (denoting the arrival times), array dep[] (denoting the departure times) and the size of the array as inputs and returns the minimum number of platforms required at the railway station such that no train waits.

Note: Time intervals are in the 24-hour format(HHMM) , where the first two characters represent hour (between 00 to 23 ) and the last two characters represent minutes (between 00 to 59).

 

Expected Time Complexity: O(nLogn)
Expected Auxiliary Space: O(n)

 

Constraints:
1 <= n <= 1000
1 <= A[i] < D[i] <= 2359
*/
//sol
class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int pf=1;
        int j=0;
        for(int i=1;i<n;i++) {
            if(arr[i]<=dep[j]) {
                pf++;
            }
            else {
                j++;
            }
        }
        return pf;
        
    }
    
}

/*
https://practice.geeksforgeeks.org/problems/63c232252d445a377e01cd91adfd7d1060580038/1

N horizontal line segments are arranged on the X-axis of a 2D plane. The start and end point of each line segment is given in a Nx2 matrix lines[ ][ ]. Your task is to find the maximum number of intersections possible of any vertical line with the given N line segments.

Example 1:

Input:
N = 4
lines[][] = {{1,3}, {2,3}, {1,2}, {4,4}}
Output:
3
Explanation:
A vertical line at X = 2 passes through 
{1,3}, {2,3}, {1,2}, ie three of the 
given horizontal lines.
Example 2:

Input: 
N = 3
lines[][] = {{1, 3}, {5, 6}, {3,4}}
Output:
2
Explanation: 
A vertical line at X = 3 passes through 
two of the given horizontal lines which 
is the maximum possible.
Your Task:
You dont need to read input or print anything. Complete the function maxIntersections() which takes the 2D Matrix lines[][] and the integer N as input parameters, and returns the maximum intersections possible.

Expected Time Complexity: O(N*log(N))
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105 
-109 ≤ lines[i][0] ≤ 109
lines[i][0] ≤ lines[i][1] ≤ 109


*/
// sol
/*

class Solution: 
    def maxIntersections(self, lines, N):
        # Code here 
        s = []
        e = []
        for st, en in lines:
            s.append(st)
            e.append(en)
        s.sort()
        e.sort()
        i, j = 0, 0
        l, ans = 0, 0
        while i<len(s) and j<len(e):
            if s[i]<=e[j]:
                l += 1
                ans = max(ans, l)
                i += 1
            else:
                j += 1
                l -= 1
        return ans

*/
