class S12CitySmallestNeighbours{
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int mat[][] = new int[n][n];
        int cnt[] = new int[n];
        for(int row[]:mat){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        for(int edge[]:edges){
            int i=edge[0],j=edge[1],wt=edge[2];
            mat[i][j]=wt;
            mat[j][i]=wt;
        }
        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][via]!=Integer.MAX_VALUE && mat[via][j]!=Integer.MAX_VALUE){
                        mat[i][j]=Math.min(mat[i][j],mat[i][via]+mat[via][j]);
                    } 
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && mat[i][j]<=distanceThreshold){
                    cnt[i]++;
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        int res=-1;
        for(int i=0;i<n;i++){
            if(cnt[i]<=ans){
                ans=cnt[i];
                res=i;
            }
        }
        return res;
    }
}