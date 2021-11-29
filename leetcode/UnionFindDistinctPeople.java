/*
https://leetcode.com/problems/accounts-merge/

Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

 

Example 1:

Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Explanation:
The first and second John's are the same person as they have the common email "johnsmith@mail.com".
The third John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
Example 2:

Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
 

Constraints:

1 <= accounts.length <= 1000
2 <= accounts[i].length <= 10
1 <= accounts[i][j] <= 30
accounts[i][0] consists of English letters.
accounts[i][j] (for j > 0) is a valid email.
*/
//sol
/*
mine correct py3
class Solution:
    
    def union(self, d, x1, x2):
        p1=self.find(d, x1)
        p2=self.find(d, x2)
        d[p1]=p2
        
    def find(self, d, x):
        if d[x]==x:
            return x
        return self.find(d, d[x])
    
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        d={}
        for ar in accounts:
            for s in ar[1:]:
                d[s]=s
        for ar in accounts:
            for s in ar[2:]:
                self.union(d, ar[1], s)
        di={} #for list of email
        dn={} #for name
        for ar in accounts:
            if di.get(self.find(d, ar[1]), None) is None:
                di[self.find(d, ar[1])]=set()
            if dn.get(self.find(d, ar[1]), None) is None:
                dn[self.find(d, ar[1])]=ar[0]
            for s in ar[1:]:
                di[self.find(d, ar[1])].add(s)
        
        ans=[]
        for v in di:
            ans.append([dn[self.find(d, v)]]+sorted(list(di[v])))
        return ans
        
        
        
*/
//sol java given
class DSU {
    int representative [];
    int size [];
    
    DSU(int sz) {
        representative = new int[sz];
        size = new int[sz];
        
        for (int i = 0; i < sz; ++i) {
            // Initially each group is its own representative
            representative[i] = i;
            // Intialize the size of all groups to 1
            size[i] = 1;
        }
    }
    
    // Finds the representative of group x
    public int findRepresentative(int x) {
        if (x == representative[x]) {
            return x;
        }
        
        // This is path compression
        return representative[x] = findRepresentative(representative[x]);
    }
    
    // Unite the group that contains "a" with the group that contains "b"
    public void unionBySize(int a, int b) {
        int representativeA = findRepresentative(a);
        int representativeB = findRepresentative(b);
        
        // If nodes a and b already belong to the same group, do nothing.
        if (representativeA == representativeB) {
            return;
        }
        
        // Union by size: point the representative of the smaller
        // group to the representative of the larger group.
        if (size[representativeA] >= size[representativeB]) {
            size[representativeA] += size[representativeB];
            representative[representativeB] = representativeA;
        } else {
            size[representativeB] += size[representativeA];
            representative[representativeA] = representativeB;
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accountList) {
        int accountListSize = accountList.size();
        DSU dsu = new DSU(accountListSize);
        
        // Maps email to their component index
        Map<String, Integer> emailGroup = new HashMap<>();
        
        for (int i = 0; i < accountListSize; i++) {
            int accountSize = accountList.get(i).size();
            
            for (int j = 1; j < accountSize; j++) {
                String email = accountList.get(i).get(j);
                String accountName = accountList.get(i).get(0);
                
                // If this is the first time seeing this email then
                // assign component group as the account index
                if (!emailGroup.containsKey(email)) {
                    emailGroup.put(email, i);
                } else {
                    // If we have seen this email before then union this
                    // group with the previous group of the email
                    dsu.unionBySize(i, emailGroup.get(email));
                }
            }
        }
        
        // Store emails corresponding to the component's representative
        Map<Integer, List<String>> components = new HashMap<Integer, List<String>>();
        for (String email : emailGroup.keySet()) {
            int group = emailGroup.get(email);
            int groupRep = dsu.findRepresentative(group);
            
            if (!components.containsKey(groupRep)) {
                components.put(groupRep, new ArrayList<String>());
            }
            
            components.get(groupRep).add(email);
        }
        
        // Sort the components and add the account name
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (int group : components.keySet()) {
            List<String> component = components.get(group);
            Collections.sort(component); 
            component.add(0, accountList.get(group).get(0));
            mergedAccounts.add(component);
        }
        
        return mergedAccounts;
    }
}
