/*
https://practice.geeksforgeeks.org/problems/963b3db8c7ac09d564c9d354c07af13c624ba94d/1/

Given a tree with N nodes and (N-1) edges such that each edge has some weight. You are given Q queries. Each query contains a number X. Find the number of paths in which the edge that has the maximum weight is less than or equals to X.

Note: Path from A to B and B to A are considered to be the same.

 

Example 1:

Input: N = 7
Tree = 
              1
           3 /
            /
           2
          / \
       1 /   \ 9
        /     \
       3       4
      / \     
   7 /   \ 8
    /     \
   6       5
          /    
       4 /
        /
       7
list of edges {start,end,weight}= 
{{1, 2, 3}, {2, 3, 1}, {2, 4, 9},
{3, 6, 7}, {3, 5, 8}, {5, 7, 4}}
Q = 3
queries[] = {1, 3, 5}
Output: 1 3 4
Explanation: 
Query 1: Path from 2 to 3
Query 2: Path from 1 to 2, 1 to 3, and 
         2 to 3
Query 3: Path from 1 to 2, 1 to 3, 2 to 3, 
         and 5 to 7
 

Example 2:

Input: N = 3
list of edges {start, end, weight}= 
{{1, 2, 1}, {2, 3, 4}}
Q = 1
queries[] = {3}
Output: 1
Explanation:
Query 1: Path from 1 to 2

 

Your Task:  
You don't need to read input or print anything. Complete the function maximumWeight()which takes integers N, list of edges where each edge is given by {start,end,weight}, an integer Q and a list of Q queries as input parameters and returns a list of integers denoting the maximum number of possible paths for each query. 

Expected Time Complexity: O(NlogN + QlogN)
Expected Auxiliary Space: O(N)

Constraints:
2 ≤ N ≤ 104
Number of edges = N - 1
1 ≤ val[i] ≤ 105
*/

//sol
class Dsu {
    public int[] par;

    public Dsu() {
    }

    public Dsu(int N) {
        par = new int[N];
        for (int i = 0; i < N; ++i) {
            par[i] = -1;
        }
    }

    public int find(int x) {
        return par[x] < 0 ? x : (par[x] = find(par[x]));
    }

    public int all(int x) {
        return x * (x - 1) / 2;
    }

    public boolean Union(int x, int y, int[] ans) {
        x = find(x);
        y = find(y);
        if (x != y) {
            ans[0] += all(-par[x] - par[y]) - all(-par[x]) - all(-par[y]);
            if (par[x] > par[y]) {
                par[x] += par[y];
                par[y] = x;
            } else {
                par[y] += par[x];
                par[x] = y;
            }
            return true;
        }
        return false;
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public int size(int x) {
        return -par[find(x)];
    }

    public boolean isParent(int x) {
        return par[x] < 0;
    }
}

class Pair implements Comparable<Pair> {
    int fs, sc;

    Pair() {
    }

    Pair(int fs_, int sc_) {
        fs = fs_;
        sc = sc_;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "fs=" + fs +
                ", sc=" + sc +
                '}';
    }

    @Override
    public int compareTo(Pair oth) {
        int ret = Integer.compare(fs, oth.fs);
        if (ret != 0) return ret;
        return Integer.compare(sc, oth.sc);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return fs == pair.fs &&
                sc == pair.sc;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fs, sc);
    }
}

class Solution {
    ArrayList<Integer> maximumWeight(int n, int edges_[][], int q, int que[]) {
        Arrays.sort(edges_, (lhs, rhs) -> Integer.compare(lhs[2], rhs[2]));
        Pair[] query = new Pair[q];
        for (int i = 0; i < q; ++i) query[i] = new Pair(que[i], i);
        Arrays.sort(query);
        int m = 0;
        Dsu dsu = new Dsu(n);
        int[] ans = new int[1];
        for (int i = 0; i < q; ++i) {
            while (m < edges_.length && edges_[m][2] <= query[i].fs) {
                dsu.Union(edges_[m][0] - 1, edges_[m][1] - 1, ans);
                ++m;
            }
            que[query[i].sc] = ans[0];
        }
        ArrayList<Integer> integers = new ArrayList<Integer>();
        for(int i=0;i<q;++i) integers.add(que[i]);
        return integers;
    }
}
