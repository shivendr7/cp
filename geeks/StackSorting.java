/*
https://practice.geeksforgeeks.org/problems/sort-a-stack/1

Given a stack, the task is to sort it such that the top of the stack has the greatest element.

Example 1:

Input:
Stack: 3 2 1
Output: 3 2 1
Example 2:

Input:
Stack: 11 2 32 3 41
Output: 41 32 11 3 2
Your Task: 
You don't have to read input or print anything. Your task is to complete the function sort() which sorts the elements present in the given stack. (The sorted stack is printed by the driver's code by popping the elements of the stack.)

Expected Time Complexity: O(N*N)
Expected Auxilliary Space: O(N) recursive.

Constraints:
1<=N<=100

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.
*/
//sol
class GfG{
    public void sortStack(Stack<Integer> s) {
        if(!s.empty()) {
            int temp=s.pop();
            sortStack(s);
            sortedStack(s, temp);
        }
    }
    public void sortedStack(Stack<Integer> s, int temp) {
        if(s.empty()||s.peek()<temp) {
            s.push(temp);
        }
        else {
            int p=s.pop();
            sortedStack(s, temp);
            s.push(p);
        }
    }
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here. 
		sortStack(s);
		return s;
	}
}

/*
https://practice.geeksforgeeks.org/problems/max-length-removal0452/1/

Given a binary string (consists of only 0 and 1). If there is “100” as a sub-string in the string, then we can delete this sub-string. The task is to find the length of longest sub-string which can be make removed?

Example 1:

Input  : 
str = "1011100000100"
Output :
6
Explanation :
Sub-strings present in str that can be make
removed 101{110000}0{100}. First
sub-string 110000-->100-->null, length is = 6.
Second sub-string 100-->null, length is = 3
 

Example 2:

Input  :
str = "111011"
Output :
0
Explanation :
There is no sub-string which can be make null.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function longestNull() which takes the string S[] as inputs and returns the length of the longest string that can be removed.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ string length ≤ 104
S[i] = {0, 1}
*/
//sol

class Solution{
    public:
        
    int longestNull(string str)
    {
        // Your code goes here   
        vector<pair<char,int>> arr;
        arr.push_back({'$',-1});
        int max_substr=0;
        for(int i=0;i<str.length();i++) {
            arr.push_back({str[i],i}); 
            while(arr.size()>=3 &&
                    arr[arr.size()-3].first=='1' &&
                    arr[arr.size()-2].first=='0' &&
                    arr[arr.size()-1].first=='0')
            {
                arr.pop_back();
                arr.pop_back();
                arr.pop_back();
            }
            int temp=arr.back().second;
            max_substr=max(max_substr,i-temp);
        }
        return max_substr;
    }
};
