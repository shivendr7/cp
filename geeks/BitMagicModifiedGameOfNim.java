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


/*
https://practice.geeksforgeeks.org/problems/the-bit-game2313/1/
must see editorial

Two players, Player 1 and Player 2, are given an integer N to play a game. The rules of the game are as follows :
1. In one turn, a player can swap any 2 bits of N in its binary representation to make a new N.
2. In one turn, a player has to make a number strictly less than N.
3. Player 1 always takes first turn.
4. If a player cannot make a move, he loses.
Assume that both the players play optimally.

 

Example 1:

Input:
N = 8
Output:
1
Explanation:
N = 8
N = 1000 (binary)
Player 1 swaps the 1st 
and 4th bit.
1000
N = 0001
Player 2 cannot make a move, 
so Player 1 wins.
 

 

Example 2:

Input:
N = 1
Output:
2
Explanation:
N = 1
Player 1 cannot make 
a move, so Player 2 wins.
 

Your Task:

You don't need to read input or print anything. Your task is to complete the function swapBitGame() which takes an integer N and returns "1" if Player 1 wins, else return "2".

 

Expected Time Complexity: O(log(N))
Expected Auxiliary Space: O(1)

 

Constraints : 
1 <= N <= 10^12

*/

//sol
class Solution:
    def swapBitGame (ob,N):
        # code here 
        zeros=0
        x0r=0
        while (N) :
           if (N&1) :
             x0r ^= zeros
           else :
             zeros=zeros+1
           N>>=1

        if x0r > 0 :
          return 1
        else :
          return 2
