
class Contest414 {
    public static void convertDateToBinary(String date) {
        String year=date.substring(0,4);
        String month=date.substring(5,7 );
        String day=date.substring(8, 10);
        StringBuilder bin = new StringBuilder();
        StringBuilder mon = new StringBuilder();
        StringBuilder da = new StringBuilder();
        int y=Integer.parseInt(year);
        int m=Integer.parseInt(month);
        int d=Integer.parseInt(day);
        while(y>0){
            int rem=y%2;
            bin.append(rem);
            y=y/2;
        }
        bin.reverse();

        while(m>0){
            int r = m%2;
            mon.append(r);
            m=m/2;
        }
        mon.reverse();
        while(d>0){
            int re = d%2;
            da.append(re);
            d=d/2;
        }
        da.reverse();

        System.out.println(bin.toString()+"-"+mon.toString()+"-"+da.toString());

    }
    public static void main(String[] args) {
        convertDateToBinary("2080-02-29");
    }
}
