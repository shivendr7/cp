/*
https://practice.geeksforgeeks.org/problems/variation-in-nim-game4317/1/

You are given an array A[] of n elements. There are two players player 1 and player 2.
A player can choose any of element from an array and remove it. If the bitwise XOR of all remaining elements equals 0 after removal of the selected element, then that player loses. Find out the winner if player 1 starts the game and they both play their best. 


Example 1:

Input: n = 3
A[] = {3, 3, 2}
Output: 2
Explaination: Optimal removal of values are 
3, 2, 3 sequentially. Then the array is empty. 
So player 2 wins.

Example 2:

Input: n = 2
A[] = {3, 3}
Output: 1
Explaination: In this case the xor is 0 from 
beginning of the game. So, player 1 does not 
need to make a move. So, he is the winner.

Your Task:
You do not need to read input or print anything. Your task is to complete the function findWinner() which takes the number n and the array A[] as input parameters and returns an integer denoting the winner.


Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ n ≤ 1000
1 ≤ A[i] ≤ 106
*/
//sol
class Solution{
    static int findWinner(int n, int A[]){ 
        // code here 
        int k=0;
        for(int i:A) {
            k^=i;
        }
        if(k==0) return 1;
        if(n%2==0) return 1;
        return 2;
    }
}
