public class A25DuplicateInArr {
    //  we need to make a cycle like in LinkedList to find the starting point(duplicate value, they are two so circle forms by them), so we make it 
    //  by taking values of array so it forms a circle 
    public int findDuplicate(int[] nums) {
        int slow = nums[0],fast = nums[0];
        do{
            slow=nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);

        slow = nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
