/*
https://leetcode.com/problems/the-score-of-students-solving-math-expression/

You are given a string s that contains digits 0-9, addition symbols '+', and multiplication symbols '*' only, representing a valid math expression of single digit numbers (e.g., 3+5*2). This expression was given to n elementary school students. The students were instructed to get the answer of the expression by following this order of operations:

Compute multiplication, reading from left to right; Then,
Compute addition, reading from left to right.
You are given an integer array answers of length n, which are the submitted answers of the students in no particular order. You are asked to grade the answers, by following these rules:

If an answer equals the correct answer of the expression, this student will be rewarded 5 points;
Otherwise, if the answer could be interpreted as if the student used the incorrect order of operations, once or multiple times, this student will be rewarded 2 points;
Otherwise, this student will be rewarded 0 points.
Return the sum of the points of the students.

 

Example 1:


Input: s = "7+3*1*2", answers = [20,13,42]
Output: 7
Explanation: As illustrated above, the correct answer of the expression is 13, therefore one student is rewarded 5 points: [20,13,42]
A student might have used this incorrect order of operations: 7+3=10, 10*1=10, 10*2=20. Therefore one student is rewarded 2 points: [20,13,42]
The points for the students are: [2,5,0]. The sum of the points is 2+5+0=7.
Example 2:

Input: s = "3+5*2", answers = [13,0,10,13,13,16,16]
Output: 19
Explanation: The correct answer of the expression is 13, therefore three students are rewarded 5 points each: [13,0,10,13,13,16,16]
A student might have used this incorrect order of operations: 3+5=8, 8*2=16. Therefore two students are rewarded 2 points: [13,0,10,13,13,16,16]
The points for the students are: [5,0,0,5,5,2,2]. The sum of the points is 5+0+0+5+5+2+2=19.
Example 3:

Input: s = "6+0*1", answers = [12,9,6,4,8,6]
Output: 10
Explanation: The correct answer of the expression is 6.
If a student had used some incorrect order of operations, the answer would also be 6.
By the rules of grading, the students will still be rewarded 5 points (as they got the correct answer), not 2 points.
The points for the students are: [0,0,5,0,0,5]. The sum of the points is 10.
 

Constraints:

3 <= s.length <= 31
s represents a valid expression that contains only digits 0-9, '+', and '*' only.
All the integer operands in the expression are in the inclusive range [0, 9].
1 <= The count of all operators ('+' and '*') in the math expression <= 15
Test data are generated such that the correct answer of the expression is in the range of [0, 1000].
n == answers.length
1 <= n <= 104
0 <= answers[i] <= 1000

*/
//sol
class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        final int N = s.length() / 2 + 1;
        int correct = calculate(s);      
        
        Set<Integer>[][] sets = new HashSet[N][N];
        for (int i = N - 1; i >= 0; i--) {
            sets[i][i] = new HashSet<>();
            sets[i][i].add(s.charAt(i * 2) - '0');
            for (int j = i + 1; j < N; j++) {
                sets[i][j] = new HashSet<>();
                for (int k = i; k < j; k++) {
                    for (int left : sets[i][k]) {
                        for (int right : sets[k + 1][j]) {
                            int ans = s.charAt(2 * k + 1) == '+' ? left + right : left * right;
                            if (ans <= 1000) {
                                sets[i][j].add(ans);    
                            }                            
                        }
                    }
                }
            }
        }
        
        int res = 0;
        for (int a : answers) {
            if (a == correct) {
                res += 5;
            } else if (sets[0][N - 1].contains(a)) {
                res += 2;
            }
        }
        return res;
    }
    
	// calculate the correct answer using stack.
    private int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '+') {
                i++;
            } else if (Character.isDigit(s.charAt(i))) {
                stack.offerFirst(s.charAt(i++) - '0');
            } else {
				// '*'
                i++;
                stack.offerFirst(stack.pollFirst() * (s.charAt(i++) - '0'));
            }            
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pollFirst();
        }
        return sum;
    }
}

/*

class Solution:
    def scoreOfStudents(self, s: str, answers: List[int]) -> int:
        gold = eval(s)
        
        @functools.lru_cache(None)
        def get_all_poss(p0=0, p1=len(s)-1) :
            if p0 == p1 :
                return set([int(s[p0])])
            to_ret = set()
            for p_sign in range(p0+1, p1, 2) :
                v1 = get_all_poss(p0, p_sign-1)
                v2 = get_all_poss(p_sign+1, p1)
                for a in v1 :
                    for b in v2 :
                        to_add = a+b if s[p_sign] == '+' else a*b
                        if to_add <= 1000 :
                            to_ret.add(to_add) 
            # print(p0, p1, to_ret)
            return to_ret
        
        pos = get_all_poss()
        to_ret = 0
        for at in answers :
            if at == gold :
                to_ret += 5
            elif at in pos :
                to_ret += 2
        return to_ret

*/
