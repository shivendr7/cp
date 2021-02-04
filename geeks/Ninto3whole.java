/*
Given a really large number N, break it into 3 whole numbers such that they sum up to the original number and count number of ways to do so..
Input:
N = 2
Output:
6
Explanation:
Possible ways to break the number:
0 + 0 + 2 = 2 
0 + 2 + 0 = 2
2 + 0 + 0 = 2
0 + 1 + 1 = 2
1 + 1 + 0 = 2
1 + 0 + 1 = 2

*/

class Solution{
    static int waysToBreakNumber(int N){
        // code here
        return((N+1)*(N+2)/2);
    }
}
