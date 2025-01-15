import java.util.ArrayList;
import java.util.List;

public class A2Majority2 {
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length,c1=Integer.MIN_VALUE,c2=Integer.MIN_VALUE,cnt1=0,cnt2=0;
        for(int i=0;i<n;i++){
            if(cnt1==0 && nums[i]!=c2){
                c1=nums[i];
                cnt1=1;
            }
            else if(nums[i]==c1){
                cnt1++;
            }
            else if(cnt2==0){
                c2=nums[i];
                cnt2=1;
            }
            else if(nums[i]==c2){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        int c1cnt=0,c2cnt=0;
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]==c1){
                c1cnt++;
            }
            if(nums[i]==c2){
                c2cnt++;
            }
        }
 
        List<Integer> result = new ArrayList<>();
        if (c1cnt > n / 3) result.add(c1);
        if (c2cnt > n / 3) result.add(c2);

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-1,-1};
        System.out.println(majorityElement(nums));
    }
}
