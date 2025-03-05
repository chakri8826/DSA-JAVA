class B3SetRightMost0{
    static int setBit(int n) {
        return (n|n+1);
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println(setBit(n));
        

    }
}