/*
Geek wants to inspect the quality of vegetables at each shop in the vegetable market. There are N different vegetable sellers in a line. A single kilogram each of brinjal, carrot and tomato are available with every seller but at different prices. Geek wants to buy exactly one vegetable from one shop and avoid buying the same vegetables from adjacent shops. 
Given the cost of each vegetable in each shop in a Nx3 matrix, calculate the minimum amount of money that Geek must spend in the inspection. 


Example 1:

Input: 
N = 3
cost = {{1, 50, 50}, 
        {50, 50, 50}, 
        {1, 50, 50}}
Output: 52
Explaination: 
Shop 1: Buy Brinjals for Rs 1.
Shop 2: Buy Carrot or Tomatoes for Rs 50.
Shop 3: Buy Brinjals for Rs 1.
Total = 1+50+1 = 52

Your Task:
You do not need to read input or print anything. Your task is to complete the function minCost() which takes N and Nx3 matrix cost[][] as input parameters and returns he minimum amount of money that Geek must spend in the inspection. 


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 105 
1 ≤ cost[i][j] ≤ 100 
*/
//sol
class Solution{
    static int minCost(int N, int cost[][]) {
        // code here
        int veg1=cost[0][0];
        int veg2=cost[0][1];
        int veg3=cost[0][2];
        
        for(int i=1;i<N;i++) {
            int a=Math.min(veg2, veg3);
            int b=Math.min(veg1, veg3);
            int c=Math.min(veg1, veg2);
            
            veg1= cost[i][0]+a;
            veg2= cost[i][1]+b;
            veg3= cost[i][2]+c;
        }
        veg1=Math.min(veg1, veg2);
        veg1=Math.min(veg1, veg3);
        return veg1;
    }
}
