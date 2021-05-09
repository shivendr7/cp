/*
Given an array Arr of size N, each element of the array represents the amount of calories, the task is to calculate the maximum of amount of calories you can get remembering the fact that you cannot take three consecutive calories.

Example 1:

Input: N = 5, arr[] = {3, 2, 1, 10, 3}
Output: 18
Explanation: You can take 1st, 2nd, 4th 
and 5th calories (3 + 2 + 10 + 3) = 18
Example 2:

Input: N = 2, arr[] = {8, 15}
Output: 23
Explanation: You can take 1st and 2nd
calories (8 + 15) = 23
Your Task: 
You don't need to read input or print anything. Complete the function maxCalories() which takes N  and array Arr as input parameter and returns an integer value.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
*/
//sol
class Solution
{
	public int maxCalories(int arr[], int n)
	{
		// Your code goes here
		int sum[]=new int[n];
		sum[0]=arr[0];
		if(n==1) return arr[0];
		sum[1]=arr[0]+arr[1];
		for(int i=2;i<n;i++) {
		    int a=sum[i-1];
		    int b=sum[i-2]+arr[i];
		    int c=arr[i-1]+arr[i];
		    if(i>2)
		    c=sum[i-3]+arr[i]+arr[i-1];
		    b=Math.max(a,b);
		    b=Math.max(b,c);
		    sum[i]=b;
		}
		return sum[n-1];
	}
}
