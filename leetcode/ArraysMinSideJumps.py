"""
There is a 3 lane road of length n that consists of n + 1 points labeled from 0 to n. A frog starts at point 0 in the second lane and wants to jump to point n. However, there could be obstacles along the way.

You are given an array obstacles of length n + 1 where each obstacles[i] (ranging from 0 to 3) describes an obstacle on the lane obstacles[i] at point i. If obstacles[i] == 0, there are no obstacles at point i. There will be at most one obstacle in the 3 lanes at each point.

For example, if obstacles[2] == 1, then there is an obstacle on lane 1 at point 2.
The frog can only travel from point i to point i + 1 on the same lane if there is not an obstacle on the lane at point i + 1. To avoid obstacles, the frog can also perform a side jump to jump to another lane (even if they are not adjacent) at the same point if there is no obstacle on the new lane.

For example, the frog can jump from lane 3 at point 3 to lane 1 at point 3.
Return the minimum number of side jumps the frog needs to reach any lane at point n starting from lane 2 at point 0.

Note: There will be no obstacles on points 0 and n.

 

Example 1:


Input: obstacles = [0,1,2,3,0]
Output: 2 
Explanation: The optimal solution is shown by the arrows above. There are 2 side jumps (red arrows).
Note that the frog can jump over obstacles only when making side jumps (as shown at point 2).
Example 2:


Input: obstacles = [0,1,1,3,3,0]
Output: 0
Explanation: There are no obstacles on lane 2. No side jumps are required.
Example 3:


Input: obstacles = [0,2,1,0,3,0]
Output: 2
Explanation: The optimal solution is shown by the arrows above. There are 2 side jumps.
 

Constraints:

obstacles.length == n + 1
1 <= n <= 5 * 105
0 <= obstacles[i] <= 3
obstacles[0] == obstacles[n] == 0


"""
#mine
class Solution:
    def minSideJumps(self, obstacles: List[int]) -> int:
        c1=[]
        c2=[]
        c3=[]
        n=len(obstacles)-1
        c11=n+2;c22=n+2;c33=n+2
        
        for i in range(n+1):
            if obstacles[n-i]==1:
                c11=n-i
            if obstacles[n-i]==2:
                c22=n-i
            if obstacles[n-i]==3:
                c33=n-i
            c1.append(c11)
            c2.append(c22)
            c3.append(c33)
        c1=c1[::-1]; c2=c2[::-1]; c3=c3[::-1]
        #print(c1,c2,c3)
        c=2
        count=0
        n=len(obstacles)-1
        for i in range(n):
            if obstacles[i+1]==c:
                count+=1
                if c1[i]-i==max(c1[i]-i, c2[i]-i, c3[i]-i):
                    c=1
                if c2[i]-i==max(c1[i]-i, c2[i]-i, c3[i]-i):
                    c=2
                if c3[i]-i==max(c1[i]-i, c2[i]-i, c3[i]-i):
                    c=3
        return count
      
#sol
MAX = 500001

class Solution:
    def minSideJumps(self, obstacles: List[int]) -> int:
        current = [1,0,1]
        for o in obstacles:
            if o == 0:
                for c in range(3):
                    if current[c] == MAX:
                        current[c] = min(current)+1
            else:
                others = [0,1,2]
                others.remove(o-1)
                current[o-1] = MAX
                for c in others:
                    if current[c] == MAX:
                        current[c] = min(current)+1
        return min(current)
