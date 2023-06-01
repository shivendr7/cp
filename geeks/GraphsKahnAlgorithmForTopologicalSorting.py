"""

Topological sorting is an algorithm for ordering a directed graph such that for each directed edge uv, vertex u comes before vertex v in the ordering.
Topological sorting is often used to find a linear ordering of tasks in a workflow, where each task has a set of prerequisites that must be completed
before the task can be started.

There are two main topological sorting algorithms:

Kahn's algorithm is a simple algorithm that works by repeatedly removing nodes from the graph that have no incoming edges.
Tarjan's algorithm is a more complex algorithm that works by recursively exploring the graph and marking visited nodes.
Kahn's algorithm is generally faster than Tarjan's algorithm, but Tarjan's algorithm can handle graphs with cycles, while Kahn's algorithm cannot.

Here is an example of how to use Kahn's algorithm to topologically sort a graph:
"""

"""
https://practice.geeksforgeeks.org/problems/course-schedule/1/
https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/


There are a total of n tasks you have to pick, labeled from 0 to n-1. Some tasks may have prerequisites tasks, for example to pick task 0 you 
have to first finish tasks 1, which is expressed as a pair: [0, 1]
Given the total number of n tasks and a list of prerequisite pairs of size m. Find a ordering of tasks you should pick to finish all tasks.
Note: There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all tasks, return an empty array.
Returning any correct order will give the output as 1, whereas any invalid order will give the output 0.


Example 1:

Input:
n = 2, m = 1
prerequisites = {{1, 0}}
Output:
1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible order is [0, 1].
Example 2:

Input:
n = 4, m = 4
prerequisites = {{1, 0},
                 {2, 0},
                 {3, 1},
                 {3, 2}}
Output:
1
Explanation:
There are a total of 4 tasks to pick.
To pick task 3 you should have finished
both tasks 1 and 2. Both tasks 1 and 2
should be pick after you finished task 0.
So one correct task order is [0, 1, 2, 3].
Another correct ordering is [0, 2, 1, 3].
Returning any of these order will result in
a Output of 1.

Your Task:
The task is to complete the function findOrder() which takes two integers n, and m and a list of lists of size m*2 denoting the prerequisite pairs as input and returns any correct order to finish all the tasks. Return an empty array if it's impossible to finish all tasks.


Constraints:
1 ≤ n ≤ 104
0 ≤ m ≤ 105
0 ≤ prerequisites[0], prerequisites[1] ≤ 105
All prerequisite pairs are unique
prerequisites[0] ≠ prerequisites[1]

Expected Time Complexity: O(n+m).
Expected Auxiliary Space: O(n+m).
"""
class Solution:
    
    def findOrder(self, n, m, pre):
        # Code here
        adj=[[] for i in range(n)]
        for p in pre:
            adj[p[1]].append(p[0])
        q=[]
        indegree=[0 for i in range(n)]
        for u in adj:
            for v in u:
                indegree[v]+=1
        res=[]
        for i in range(n):
            if indegree[i]==0:
                q.append(i)
        c=0
        while len(q)>0:
            u=q.pop(0)
            c+=1
            for v in adj[u]:
                if indegree[v]==0:
                    return []
                indegree[v]-=1
                if indegree[v]==0:
                    q.append(v)
            res.append(u)
        if c!=n:
            return []
        return res
        
