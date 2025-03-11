public class G4Lemonade {
    public boolean lemonadeChange(int[] bills) {
        int fives=0,tens=0,twens=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5)fives++;
            else if(bills[i]==10){
                if(fives>0){
                    tens++;
                    fives--;
                } 
                else return false;
            }
            else {                 
                boolean have = false;                 
                if (tens > 0) {                     
                    tens--;                     
                    have = true;                 
                }                 
                if (have && fives > 0) {                     
                    fives--;                 
                } else if (!have && fives >= 3) {                     
                    fives = fives - 3;                   
                } else {                     
                    return false;                 
                }             
            }
        }
        return true;
    }
}
