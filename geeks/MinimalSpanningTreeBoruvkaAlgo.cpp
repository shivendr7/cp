/*
Given a weighted, undirected and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.

 

Example 1:

Input:

Output:
4
Explanation:

The Spanning Tree resulting in a weight
of 4 is shown above.
Example 2:

Input:

Output:
5
Explanation:
Only one Spanning Tree is possible
which has a weight of 5.
 

Your task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function  spanningTree() which takes number of vertices V and an adjacency matrix adj as input parameters and returns an integer denoting the sum of weights of the edges of the Minimum Spanning Tree. Here adj[i] contains a list of lists containing two integers where the first integer j denotes that there is an edge between i and j and second integer w denotes that the distance between edge i and j is w.
 

Expected Time Complexity: O(ElogV).
Expected Auxiliary Space: O(V2).
 
*/
//sol
int Find(vector<pair<int,int>> &parent,int x)
{
    if(parent[x].first!=x)
    parent[x].first=Find(parent,parent[x].first);
    
    return parent[x].first;
}
void Union(vector<pair<int,int>> &parent,int sroot,int droot)
{
    if(parent[sroot].second > parent[droot].second)
    parent[droot].first=sroot;
    
    else if(parent[sroot].second < parent[droot].second)
    parent[sroot].first=droot;
    
    else
    {
        parent[droot].first=sroot;
        parent[sroot].second++;
    }
}
int spanningTree(int V,int E,vector<vector<int>> &graph)
{
   vector<pair<int,pair<int,int>>> edge;
   for(int i=0;i<V;i++)
   {
       for(int j=i;j<V;j++)
       if(graph[i][j]!=INT_MAX)
       edge.push_back({graph[i][j],{i,j}});
   }
   
   int wt=0;
   
	int cheapest[V];
	
	vector<pair<int,int>> parent(V);
	
	for(int i=0;i<V;i++)
	parent[i]={i,0};
	
	int Dsets=V;
	
	while(Dsets > 1)
	{
		memset(cheapest,-1,sizeof(cheapest));
		
		for(int i=0;i<E;i++)
		{
			int set1=Find(parent,edge[i].second.first);
			int set2=Find(parent,edge[i].second.second);
			
			if(set1==set2)
			continue;
			
			if(cheapest[set1] == -1 || edge[cheapest[set1]].first > edge[i].first)
			cheapest[set1]=i;
			
			if(cheapest[set2] == -1 || edge[cheapest[set2]].first > edge[i].first)
			cheapest[set2]=i;
		}
		
		for(int i=0;i<V;i++)
		{
			if(cheapest[i]!=-1)
			{
				int set1=Find(parent,edge[cheapest[i]].second.first);
				int set2=Find(parent,edge[cheapest[i]].second.second);
				
				if(set1==set2)
				continue;
				
				Union(parent,set1,set2);
				
				wt+=edge[cheapest[i]].first;
				
				Dsets--;
			}
		}
	}
	return wt;
}
