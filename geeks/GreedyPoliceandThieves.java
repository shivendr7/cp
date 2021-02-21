/*
O(1) space sol

Given an array of size n such that each element contains either a 'P' for policeman or a 'T' for thief. Find the maximum number of thieves that can be caught by the police. 
Keep in mind the following conditions :

Each policeman can catch only one thief.
A policeman cannot catch a thief who is more than K units away from him.
Example 1:

Input:
N = 5, K = 1
arr[] = {P, T, T, P, T}
Output: 2
Explanation: Maximum 2 thieves can be 
caught. First policeman catches first thief 
and second police man can catch either second 
or third thief.
Example 2:

Input:
N = 6, K = 2
arr[] = {T, T, P, P, T, P}
Output: 3
Explanation: Maximum 3 thieves can be caught.
Your Task:  
You dont need to read input or print anything. Complete the function catchThieves() that takes n, k and arr[ ] as input parameters and returns the maximum number of thieves that can be caught by the police. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ n ≤ 105
1 ≤ k ≤ 100
arr[i] = 'P' or 'T'

hint-1. Get the lowest index of policeman p and thief t. Make an allotment
if |p-t| <= k and increment to the next p and t found.
2. Otherwise increment min(p, t) to the next p or t found.
3. Repeat above two steps until next p and t are found.
4. Return the number of allotments made.
*/
//2 pointer approach
class Solution 
{ 
    static int catchThieves(char a[], int n, int k) 
	{ 
        // Code here
        int p=0,t=0;
        while(p<n&&a[p]!='P') {
            p++;
        }
        while(t<n&&a[t]!='T') {
            t++;
        } //pointing leftmost p and leftmost t
        int c=0;
        while(p<n&&t<n) {
            if(Math.abs(p-t)>k) {
                if(p>t) {
                    t++;  
                }
                else {
                    p++;
                }
            }
            else {
                c++;  //count
                p++;  //exclude police
                t++;  //exclude thief
            }
            while(p<n&&a[p]!='P') {
                p++;
            }
            while(t<n&&a[t]!='T') {
                t++;
            }
        }
        return c;
	} 
} 
