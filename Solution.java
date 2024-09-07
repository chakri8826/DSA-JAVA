public class Solution {
    public static boolean check(int i,int s,int k,int []a){
        if(i==a.length){
            if(s==k){
                return true;
            }
            else{
                return false;
            }
        }
        s+=a[i];
        if(check(i+1,s,k,a)==true){
            return true;
        }
        s-=a[i];
        if(check(i+1,s,k,a)==true){
            return true;
        }
        return false;
    }
    public static boolean isSubsetPresent(int n, int k,int []a) {
        return check(0,0,k,a);
    }
    public static void main(String[] args) {
        int a[]={4,3,5,2};
        System.out.println(isSubsetPresent(4, 13, a));
    }
}