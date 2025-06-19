import java.util.*;

class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int val){
        this.val=val;
    }
}

class B12SwapedNodes{
    // BRUTE FORCE
    // public void recoverTree(TreeNode root) {
    //     TreeNode curr = root;
    //     Stack<TreeNode> st = new Stack<>();
    //     List<Integer> li = new ArrayList<>();
        
    //     while(curr!=null || !st.isEmpty()){
    //         while(curr!=null){
    //             st.push(curr);
    //             curr=curr.left;
    //         }
    //         curr=st.pop();
    //         li.add(curr.val);
    //         curr=curr.right;
    //     }
    //     Collections.sort(li);
    //     curr=root;
    //     int ind=0;
    //     while(curr!=null || !st.isEmpty()){
    //         while(curr!=null){
    //             st.push(curr);
    //             curr=curr.left;
    //         }
    //         curr=st.pop();
    //         if(curr.val!=li.get(ind)){
    //             curr.val=li.get(ind);
    //         }
    //         ind++;
    //         curr=curr.right;
    //     }
    // }



    // MORRIS TRAVERSAL
    // OPTIMIZED
    TreeNode prev,first,mid,last;
    public void recoverTree(TreeNode root) {
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left==null){
                detect(curr);
                curr=curr.right;
            }
            else{
                TreeNode pred = curr.left;
                while(pred.right!=null && pred.right!=curr){
                    pred=pred.right;
                }
                if(pred.right==null){
                    pred.right=curr;
                    curr=curr.left;
                }
                else{
                    pred.right=null;
                    detect(curr);
                    curr=curr.right;
                }
            }
        }
        if(first!=null && last!=null){
            swap(first,last);
        }
        else{
            swap(first,mid);
        }
    }

    public void detect(TreeNode curr){
        if(prev!=null && prev.val>curr.val){
            if(first==null){
                first=prev;
                mid=curr;
            }
            else{
                last=curr;
            }
        }
        prev=curr;
    }

    public void swap(TreeNode a,TreeNode b){
        int t = a.val;
        a.val=b.val;
        b.val=t;
    }
}