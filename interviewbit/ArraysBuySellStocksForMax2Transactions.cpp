/*
https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-iii/

Say you have an array, A, for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most 2 transactions.

Return the maximum possible profit.

Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).



Input Format:

The first and the only argument is an integer array, A.
Output Format:

Return an integer, representing the maximum possible profit.
Constraints:

1 <= length(A) <= 7e5
1 <= A[i] <= 1e7
Examples:

Input 1:
    A = [1, 2, 1, 2]

Output 1:
    2

Explanation 1: 
    Day 0 : Buy 
    Day 1 : Sell
    Day 2 : Buy
    Day 3 : Sell

Input 2:
    A = [7, 2, 4, 8, 7]

Output 2:
    6

Explanation 2:
    Day 1 : Buy
    Day 3 : Sell
*/
//sol
int Solution::maxProfit(const vector<int> &A) {
    if(A.empty()) return 0;
    int one_t=0,two_t=0;
    int mp1=INT_MAX, mp2=INT_MAX;
    for(int i : A){
        mp1 = min(mp1,i);
        one_t = max(one_t,i-mp1);
        mp2 = min(mp2,i-one_t);
        two_t = max(two_t,i-mp2);
    }
    return two_t;
}
