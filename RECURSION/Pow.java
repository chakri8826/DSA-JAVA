class Pow{
 public static double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        double temp=myPow(x,n/2);
        temp=temp*temp;
        if(n%2==0){
            return temp;
        }
        else{
            return temp*x;
        }
  }
 public static void main(String[] args) {
        System.out.println(myPow(2,3)); 
 }
}
