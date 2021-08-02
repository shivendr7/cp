/*
https://practice.geeksforgeeks.org/problems/numbers-with-alternative-1s4819/1/

Given a number n, the task is to find all 1 to n bit numbers with no consecutive 1's in their binary representation.
 

Example 1:

Input: n = 3
Output: 1 2 4 5
Explanation: All numbers upto 2 bit are:
1 - 1
2 - 10
3 - 11
4 - 100
5 - 101
6 - 110
7 - 111
Here 3, 6 and 7 have consecutive 1's in their 
binary representation. 
Example 2:

Input: n = 2
Output: 1 2 
Explanation: All numbers upto 2 bit are:
1 - 1
2 - 10
3 - 11
Here 3 has consecutive 1's in it's
binary representation.
class Solution
{
    public int[]  numberWithNoConsecutiveOnes(int n)
    {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        int limit=(int)Math.pow(2,n)-1;
        
        for(int i=1;i<=limit;i++){
            if((i & i>>1) == 0)
                ans.add(i);
        }
        int res[]=new int[ans.size()];
        for(int i=0;i<ans.size();i++) {
            res[i]=ans.get(i);
        }
        return res;
    }
}


Your Task:
You don't need to read or print anything.Your task is to complete the function numberWithNoConsecutiveOnes() which takes n as input parameter and returns a list of numbers in increasing order which do not contains 1's in their binary reperesentation.
 

Expected Time Complexity: O(2n)
Expected Space Complexity: O(n)
*/
//sol
