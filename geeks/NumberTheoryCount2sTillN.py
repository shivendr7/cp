"""
https://practice.geeksforgeeks.org/problems/occurences-of-2-as-a-digit/1/

Count the number of 2s as digit in all numbers from 0 to n.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains the input integer n.

Output:
Print the count of the number of 2s as digit in all numbers from 0 to n.

Constraints:
1<=T<=100
1<=N<=10^5

Example:
Input:
2
22
100

Output:
6
20
"""
#sol
def number0f2s(n):
    
    #add Code here
    digit_arr = [int(ch) for ch in str(n)[::-1]]
    l = len(str(n))
    summ = 0
    for digit, indx in zip(digit_arr, range(l)):
        ks_value=int(indx*(10**(indx-1))) #ks_value is no of 2 in 10,100,1000...etc
        this_sum = 0
        this_sum += ks_value * digit
        if digit > 2:
            this_sum += 10 ** indx
        if digit is 2:
            this_sum +=n%(10 ** indx)+1
        summ += this_sum
    return summ
    
def numberOf2sinRange(n):
    
    #add code here
    return number0f2s(n)
