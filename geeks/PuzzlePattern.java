/*
https://practice.geeksforgeeks.org/problems/the-smurfs4201/1/

A geek once visited a magical island where he found a special creature. He named it as Smurf. He noticed a very strange thing there. The smurfs resembled the primary colors of light. To make it more clear, the primary colors of light are Red(R), Green(G), and Blue(B). He talked to one of the smurfs. The smurfs came to know that he is a good programmer. The smurfs suggested a deal that they will ask him one question and if he is able to answer that question, they will allow the geek to take anything from the island.
The question is as follows:
The smurfs possess a very magical property. When two smurfs of different colors meet with other, they gets converted into a smurf of the third color. How many minimum number of smurfs will be remaining after this transformation? The question looked simple to geek. However, the smurfs put another constraint to make the geek think more. The two smurfs must be adjacent to each other  to make the transformation take place. There are n smurfs the colors of which are given in an array a[].

Example 1:

Input: n = 5
a = {'R' , 'G', 'B', 'R', 'B'}
Output: 1
Explaination: First 'R' and 'G' makes 'B'. 
Then 'B' and 'R' makes 'G' and that 'G' 
with 'B' at index 2 makes 'R', Now the 'R' 
and the last 'B' makes 'G'.
Example 2:

Input: n = 2
a = {'R', 'R'}
Output: 2
Explaination: There are two 'R' s. So 
they cannot change to anything else.
Your Task:
You do not need to read input or print anything. Your task is to complete the function findMin() which takes n and a as input parameters and retunrs the minimum number of smurfs existing at the end.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ n ≤ 1000
*/
//sol
class Solution{
    static int minFind(int n, String a[]){
        // code here
        int r=0, g=0, b=0;
        for(int i=0;i<a.length;i++) {
            if(a[i].equals("R")) {
                r++;
            }
            if(a[i].equals("G")) {
                g++;
            }
            if(a[i].equals("B")) {
                b++;
            }
        }
        if(r==n||g==n||b==n) {
            return n;
        }
        if(r%2==0 && g%2==0 && b%2==0) {
            return 2;
        }
        if(r%2==1 && g%2==1 && b%2==1) {
            return 2;
        }
        return 1;
    }
}
