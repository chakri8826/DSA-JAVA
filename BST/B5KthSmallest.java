class B5KthSmallest{
    // BRUTE --> DOINT ANY OF TRAVERSAL AND SORTING AND GETTING THE KTH VALUE TC -> O(n) + O(log N),sc ->O(N)
    // BETTER --> TC-O(N) AND SC-O(N)
    // public void inOrder(TreeNode root,int k,List<Integer> li){
    //     if(root==null) return ;
    //     inOrder(root.left,k,li);
    //     li.add(root.val);
    //     inOrder(root.right,k,li);
    // }
    // public int kthSmallest(TreeNode root, int k) {
    //     List<Integer> li = new ArrayList<>();
    //     inOrder(root,k,li);
    //     return li.get(k-1);
    // }


    // OPTIMAL
    public void inOrder(TreeNode root,int k,int ans[],int[] cnt){
        if(root==null || cnt[0]>k) return ;
        inOrder(root.left,k,ans,cnt);
        cnt[0]++;
        if(cnt[0]==k)  ans[0]=root.val;
        inOrder(root.right,k,ans,cnt);
    }
     public void morris(TreeNode root,int k,int ans[],int[] cnt){
        while(root!=null){
            if(root.left==null){
                cnt[0]++;
                if(cnt[0]==k){
                    ans[0]=root.val;
                    break;
                } 
                root=root.right;
            }
            else{
                TreeNode prev=root.left;
                while(prev.right!=null && prev.right!=root){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=root;
                    root=root.left;
                }
                else{
                    cnt[0]++;
                    if(cnt[0]==k){
                        ans[0]=root.val;
                        break;
                    }
                    prev.right=null;
                    root=root.right;
                }
            }
        }
    } 

    public int kthSmallest(TreeNode root, int k) {
        int ans[] = new int[1];
        int cnt[] = new int[1];
        // inOrder(root,k,ans,cnt);
        morris(root,k,ans,cnt);
        return ans[0];
    }
} 