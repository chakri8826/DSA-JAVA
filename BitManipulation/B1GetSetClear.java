public class B1GetSetClear {
     static void bitManipulation(int num, int i) {
        // System.out.print((num & 1<<i-1));

        System.out.print((num>>i-1)&1); //FOR GETTING THE ITH BIT USING LEFT SHIFT IT WONT WORK BECOZ IT PRINTS THE VALUE NOT THE BIT 
        System.out.print(" "+(num|(1<<i-1)));
        System.out.print(" "+(num&~(1<<i-1)));
    }
}
