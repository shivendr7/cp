/*
https://practice.geeksforgeeks.org/problems/6b216f3d1f1ce9a14258b982d44f5e5199e7759a/1
https://github.com/shivendr7/cp/blob/main/leetcode/GraphsTopologyAlgoMinTimeToCompleteCourses.py

An IT company is working on a large project. The project is broken into N modules and distributed to different teams. The amount of time (in months) required to complete each module is given in an array duration[ ]. Two modules can be processed simultaneously only if their is no dependency between them and it is given that M modules have interdependecies. 
As the project manager, compute the minimum time required to complete the project.

Example 1:

Input:
N = 6 6
duration[] = {1, 2, 3, 1, 3, 2}
dependencies:
5 2
5 0
4 0 
4 1
2 3
3 1
Output: 
8
Explanation: 
graph
The Graph of dependency forms this and 
the project will be completed when Module 
1 is completed which takes 8 months.
Example 2:

Input:
N = 3 3
duration[] = {5, 5, 5}
dependencies:
0 1
1 2
2 0
Output: 
-1
Explanation: 
There is a cycle in the dependency graph 
hence the project cannot be completed.
Your Task:
Complete the function minTime() which takes N, M, duration array, and dependencies array as input parameter and return the minimum time required. Return -1 if the project can not be completed. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105
1 ≤ M ≤ 2*105
1 ≤ duration[i] ≤ 105

*/
//java
class Solution {
    public int minTime(ArrayList<pair> dependency, int[] duration, int n, int m) {
        // code here 
          ArrayList<Integer> v[] = new ArrayList[n+1];
        
        for(int i = 0; i <= n; i++)
            v[i] = new ArrayList<>();
        
        int[] vis = new int[n+1],deg = new int[n+1],req = new int[n+1];
        int ans = 0;
        
        for(pair i:dependency)
        {
            v[i.x].add(i.y);
            deg[i.y]++;
        }
        Stack<Integer> q = new Stack<>();
        for(int i=0; i<n; i++)
        {
            if(deg[i]==0)
            {
                vis[i]=1;
                q.push(i);
            }
            req[i]=duration[i];
            ans = Math.max(ans, req[i]);
        }
        while(!q.isEmpty())
        {
            int node=q.pop();
            for(int i:v[node])
            {
                deg[i]--;
                req[i]=Math.max(req[node]+duration[i], req[i]);
                if(deg[i]==0){
                q.push(i);
                vis[i]=1;
                ans=Math.max(ans, req[i]);
                }
            }
        }
        for(int i=0;i<n;i++)
        if(vis[i]==0)
        return -1;
        return ans;
    }
}

//cpp
int visited[100005];
int counted[100005];
int isstack[100005];


class Solution{
    public:
    // refer https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
    // for cycle detection in directed graph
    bool checkCycle(int i, vector<vector<int>> &ve) {
        if (isstack[i] == 1) return true;
    
        // insert into stack
        isstack[i] = 1;
        for (auto it : ve[i]) {
            // if next node is visited
            if (visited[it] == 1) {
                // if the node is in stack then cycle is found
                if (isstack[it] == 1) return true;
                continue;
            }
            visited[it] = 1;
            if (checkCycle(it, ve)) return true;
        }
        // removing from stack
        isstack[i] = 0;
        return false;
    }
    /*
        i: current node
        ve: adjacency list of the graph
        duration: time to complete each module
    */
    int dfs(int i, vector<vector<int>> &ve, int duration[]) {
        // return the time to complete the project starting from the node i if it is
        // already calculated
        if (counted[i] != -1) return counted[i];
        int x = 0;
    
        for (auto it : ve[i]) x = max(x, dfs(it, ve, duration));
    
        // time to complete this module and maximum time to complete child modules
        counted[i] = x + duration[i];
        return counted[i];
    }
    
    int minTime(vector<pair<int, int>> &vp, int duration[], int n, int m) {
        // stores which modules are independent
        int independent[n + 5] = {0};
        // create a graph from the dependency vector
        vector<vector<int>> ve(n + 2);
        for (int i = 0; i < m; i++) {
            int x = vp[i].first;
            int y = vp[i].second;
            ve[x].push_back(y);
            independent[y]++;
        }
        memset(visited, -1, sizeof(visited));
        memset(counted, -1, sizeof(counted));
        memset(isstack, -1, sizeof(isstack));
    
        int flag = 0;
        for (int i = 0; i < n; i++)
            if (independent[i] == 0) flag = 1;
    
        // if there is no independent module then the project can't be completed
        if (flag == 0) return -1;
    
        for (int i = 0; i < n; i++) {
            if (independent[i] != 0) {
                continue;
            }
            visited[i] = 1;
            // check if cycle is exist then project can't be completed
            if (checkCycle(i, ve)) return -1;
        }
    
        // starting from any independent module find the maximum time to complete
        // the project
        int ans = 0;
        for (int i = 0; i < n; i++)
            if (independent[i] == 0) ans = max(ans, dfs(i, ve, duration));
    
        return ans;
    }
};

