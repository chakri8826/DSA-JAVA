public class B1GetSetClear {
     static void bitManipulation(int num, int i) {
        // System.out.print((num & 1<<i-1));

        // 1 Based Indexing(starts from right most bit as 1,2,3...) so, i-1  
        System.out.print((num>>i-1)&1); //FOR GETTING THE ITH BIT USING LEFT SHIFT IT WONT WORK BECOZ IT PRINTS THE VALUE NOT THE BIT 
        System.out.print(" "+(num|(1<<i-1)));
        System.out.print(" "+(num&~(1<<i-1)));
    }   
    public static void main(String[] args) {
        int num = 5;
        int i = 3;
        // bitManipulation(num, i);
        System.out.println(4>>2);
    }
}

