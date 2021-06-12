/*
You are given a valid boolean expression as a string expression consisting of the characters '1','0','&' (bitwise AND operator),'|' (bitwise OR operator),'(', and ')'.

For example, "()1|1" and "(1)&()" are not valid while "1", "(((1))|(0))", and "1|(0&(1))" are valid expressions.
Return the minimum cost to change the final value of the expression.

For example, if expression = "1|1|(0&0)&1", its value is 1|1|(0&0)&1 = 1|1|0&1 = 1|0&1 = 1&1 = 1. We want to apply operations so that the new expression evaluates to 0.
The cost of changing the final value of an expression is the number of operations performed on the expression. The types of operations are described as follows:

Turn a '1' into a '0'.
Turn a '0' into a '1'.
Turn a '&' into a '|'.
Turn a '|' into a '&'.
Note: '&' does not take precedence over '|' in the order of calculation. Evaluate parentheses first, then in left-to-right order.

 

Example 1:

Input: expression = "1&(0|1)"
Output: 1
Explanation: We can turn "1&(0|1)" into "1&(0&1)" by changing the '|' to a '&' using 1 operation.
The new expression evaluates to 0. 
Example 2:

Input: expression = "(0&0)&(0&0&0)"
Output: 3
Explanation: We can turn "(0&0)&(0&0&0)" into "(0|1)|(0&0&0)" using 3 operations.
The new expression evaluates to 1.
Example 3:

Input: expression = "(0|(1|0&1))"
Output: 1
Explanation: We can turn "(0|(1|0&1))" into "(0|(0|0&1))" using 1 operation.
The new expression evaluates to 0.
 

Constraints:

1 <= expression.length <= 105
expression only contains '1','0','&','|','(', and ')'
All parentheses are properly matched.
There will be no empty parentheses (i.e: "()" is not a substring of expression).

*/
//sol
class Solution {
    char[] s;
    int pos;
    int len;
    
    public int minOperationsToFlip(String expression) {
        s = expression.toCharArray();
        len = s.length;
        pos = 0;
        int[] res = expr();
        return res[1];
    }
    
    int[] expr()
    {
        int[] res = expr2();
        while(pos < len && s[pos] != ')'){
            char o = s[pos++];
            int[] to = expr2();
            if(o == '|'){
                int nv = res[0]|to[0];
                int cost = 0;
                if(nv == 1){
                    if(res[0] == 1 && to[0] == 1){
                        cost = Math.min(to[1]+1, res[1]+1);
                    }else{
                        cost = 1;
                    }
                }else{
                    cost = Math.min(res[1], to[1]);
                }
                res[0] = nv;
                res[1] = cost;
            }else{
                assert o == '&';
                int nv = res[0]&to[0];
                int cost = 0;
                if(nv == 0){
                    if(res[0] == 0 && to[0] == 0){
                        cost = Math.min(to[1]+1, res[1]+1);
                    }else{
                        cost = 1;
                    }
                }else{
                    cost = Math.min(res[1], to[1]);
                }
                res[0] = nv;
                res[1] = cost;
            }
        }
        return res;
    }
    
    int[] expr2()
    {
        if(s[pos] == '('){
            pos++;
            int[] ret = expr();
            pos++;
            return ret;
        }else if(s[pos] == '0'){
            pos++;
            return new int[]{0, 1};
        }else{
            pos++;
            return new int[]{1, 1};
        }
    }
}
