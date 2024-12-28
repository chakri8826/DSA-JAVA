public class A15MajorityEle {
    // public int majorityElement(int[] nums) {
    //     int n = nums.length;
    //     int max=n/2;
    //     HashMap<Integer,Integer> map = new HashMap();
    //     for(int i=0;i<n;i++){
    //         map.put(nums[i],map.getOrDefault(nums[i],0)+1);
    //     }

    //     for(Map.Entry<Integer,Integer> e:map.entrySet()){
    //         if(e.getValue()>max) return e.getKey();
    //     }
    //     return -1;
    // }

    public int majorityElement(int[] nums) {
        int cnt=0,ele=0,res=0,n=nums.length;
        for(int i=0;i<n;i++){
            if(cnt==0) ele=nums[i];
            if(nums[i]==ele) cnt++;
            else if(nums[i]!=ele)cnt--;
        }
        for(int i=0;i<n;i++){
            if(nums[i]==ele){
                res++;
            }
        }
        if(ele>n/2){
            return ele;    
        }
        return -1;
    }
}
