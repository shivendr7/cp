/*
https://practice.geeksforgeeks.org/problems/divide-and-subtract-game2253/1/

Jon and Arya are playing a game. Rules of game as follows:
·  They have a single number N initially.
·   Both will play an alternate move. Jon starts first.
·   Both will play each move optimally.
·   In each move, they can perform only one of these operation
          1. Divide that number by 2, 3, 4 or 5 and take floor of result.
          2. Subtract that number by 2, 3, 4 or 5.
·   If after making a move the number becomes 1, the player who made the move automatically loses the game.
·   When number becomes zero, the game will stop and the player who can't make a move loses the game.

 

Example 1:

Input:
N = 3
Output:
Jon
Explanation:
Jon will just subtract 3 from initial
number and win the game.
Example 2:

Input:
N = 6
Output:
Arya
Explanation:
Jon will divide by 3 and then in next step
Arya will subtract by 2 and win the game.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function divAndSub() which takes an Integer N as input and returns a string denoting who won the game.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1 <= N <= 105
*/
//sol
class Solution {
    static String divAndSub(int N) {
        // code here
        //  1-> wining player swap
        //  0-> curr is winning player
        //  In every turn, if -2, -3, -4, -5, /2, /3, /4, /5 makes us reach 
        //  a point where winning player swaps look_up[i_new]=1
        //  means curr player can win the game
        //  else other will win the game
        
        //  Given our curr player=Jon 
        int look_up[]=new int[N+1];
        look_up[1]=1;  //  at 1 winning player changes
        for(int i=2;i<=N;i++) {
            look_up[i]=1; 
            //let there be a swap(means curr player cannot win)
            //after this assumption we find if curr player can win
            for(int ch=2;ch<=5;ch++) {
                //check if there is possibilty of reaching a swap
                if(look_up[i/ch]==1 && i/ch!=1) look_up[i]=0;
                if(i-1>ch && look_up[i-ch]==1 || i==ch) look_up[i]=0;
            }
        }
        //  check for player change at N
        return look_up[N]==0?"Jon":"Arya";
    }
}
