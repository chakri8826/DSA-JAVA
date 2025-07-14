import java.util.*;
// User function Template for Java
class DSU{
    int parent[],rank[];
    public DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    
    public int find(int x){
        if(parent[x]==x)return x;
        return parent[x]=find(parent[x]);
    }
    
    public void unionByRank(int u,int v){
        int px=find(u);
        int py=find(v);
        if(rank[px]<rank[py]){
            parent[px]=py;
        }
        else if(rank[py]<rank[px]){
            parent[py]=px;
        }
        else{
            parent[py]=px;
            rank[px]++;
        }
    }
}
public class M5AccountsMerge {
    static ArrayList<ArrayList<String>> accountsMerge(ArrayList<ArrayList<String>> accounts) {
        // code here
        DSU dsu = new DSU(accounts.size());
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String detail = accounts.get(i).get(j);
                map.putIfAbsent(detail,i);
                if(map.containsKey(detail)){
                    int u = map.get(detail);
                    dsu.unionByRank(u,i);
                }
            }
        }
        
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for(int i=0;i<accounts.size();i++){
            res.add(new ArrayList<String>());
        }
        
        for(Map.Entry<String,Integer> it:map.entrySet()){
            String  detail = it.getKey();
            int node = dsu.find(it.getValue());
            res.get(node).add(detail);
        }
        
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for(int i=0;i<res.size();i++){
            if(res.get(i).size()==0)continue;
            Collections.sort(res.get(i));
            String name = accounts.get(i).get(0);
            res.get(i).add(0,name);
            ans.add(res.get(i));
        }
        return ans;
    }
}
