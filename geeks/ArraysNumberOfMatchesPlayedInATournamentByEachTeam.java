/*
https://practice.geeksforgeeks.org/problems/number-of-matches1120/1/

hint: see editorial

A knockout tournament is going on. A total of N number of players are participating. Each match will have two players. Every player has a distinct rating associated with him.
The player with the more rating wins in a match. In one round, the 1st player will play a match against 2nd player, 3rd player will play a match against 4th player and so on.
If there is odd number of players, last one will qualify to the next round without playing a match. Since it is a knockout tournament, whoever loses a match leaves the
tournament. Rating of each player is unique.

Your task is to find out the number of matches each player wins in the tournament. The tournament ends when there is only one player remaining in the end.

 

Example 1:

Input:
N = 5
A[] = {7, 1, 5, 3, 9}
Output:
3 1 2 1 1
Explanation:
players: 7 1 5 3 9
The first round: (7 has a match with 1),
(5 has a match with 3), (9 has no matches
automatically qualifies)

players: 7 5 9
The second round: (7 has a match with 5),
(9 has no matches automatically qualifies)

players: 7 9
The third round: (7 has a match with 9).
The player with rating 7 played 3 matches. 
The player with rating 1 played 1 match. 
The player with rating 5 played 2 matches.
The player with rating 3 played 1 match.  
The player with rating 9 played 1 match.
 

Example 2:

Input:
N = 6
A[] = {8, 4, 3, 5, 2, 6}
Output:
3 1 1 2 1 2 
Your Task:  
You don't need to read input or print anything. Your task is to complete the function getAnswer() which takes the array A[] and its size N as inputs and stores the number of
wins of each player in the answer[] array.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105 
0 ≤ rating of player ≤ 106
The rating of the players will be distinct.

*/
//sol
class Solution {

    public static void getAnswer(int arr[], int answer[], int n) 
    {
        // Your task is to store the answer of each index in the 'answer' array
        // Note: indexing is 0 based 
        int [][] a = new int [n+5][2];
        for(int i = 1; i<=n; i++)
        {
            a[i][0] = arr[i-1];
            a[i][1] = i;
        }
    
        int count = n;
    
        while(count>1)
        {
            int p = 1;
            for(int i = 1; i<count; i+=2)
            {
                answer[a[i][1] - 1]++;
                answer[a[i+1][1] - 1]++;
    
                if(a[i][0]>a[i+1][0])
                {
                    a[p][0] = a[i][0];
                    a[p][1] = a[i][1];
                    p++;
                }
                else if(a[i+1][0]>a[i][0])
                {
                    a[p][0] = a[i+1][0];
                    a[p][1] = a[i+1][1];
                    p++;
                }
            }
    
            if(count%2==1){
                a[(count/2) + 1][0] = a[count][0];
                a[(count/2) + 1][1] = a[count][1];
                count = (count/2) + 1;
            }
    
            else if(count%2==0){
                count = count/2;
            }
        }
    }
}
