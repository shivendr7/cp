All possible pair sum in an array: O(n)
        firstGroupCount = groupCounts[0]
        for i in range(1, len(groupCounts)):
            ans += firstGroupCount * groupCounts[i]
            firstGroupCount += groupCounts[i]  
        return ans

Contains geeksforgeeks challenges
O(n) algo for pattern matching-https://www.geeksforgeeks.org/z-algorithm-linear-time-pattern-searching-algorithm/
A good BFS problem: https://practice.geeksforgeeks.org/problems/steps-by-knight5927/0/?track=DSASP-Graph&batchId=154#

Must look hint: https://practice.geeksforgeeks.org/problems/mr-modulo-and-pairs5610/1/

DP distinct occurances-https://practice.geeksforgeeks.org/problems/distinct-occurrences/1/

https://practice.geeksforgeeks.org/problems/mobile-numeric-keypad5456/1/

https://practice.geeksforgeeks.org/problems/two-water-jug-problem3402/1/

https://practice.geeksforgeeks.org/problems/probability-of-knight5529/1/

https://practice.geeksforgeeks.org/problems/square-numbers1954/1/

Comments **  https://practice.geeksforgeeks.org/problems/lucky-alive-person-in-a-circle1229/1/
(origin) https://www.cdn.geeksforgeeks.org/josephus-problem-set-1-a-on-solution/


