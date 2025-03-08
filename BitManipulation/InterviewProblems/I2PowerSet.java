import java.util.ArrayList;
import java.util.List;

public class I2PowerSet {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int subs = (1<<n);
        for(int num=0;num<subs;num++){
            List<Integer> li = new ArrayList<>();
            for(int i=0;i<n;i++){
                if((num&(1<<i))!=0){
                    li.add(nums[i]);
                }
            }
            ans.add(li);
        }
        return ans;
    }
    public static void main(String[] args) {
        I2PowerSet obj = new I2PowerSet();
        int[] nums = {1,2,3};
        List<List<Integer>> ans = obj.subsets(nums);
        for(List<Integer> li:ans){
            System.out.println(li);
        }
    }
}
