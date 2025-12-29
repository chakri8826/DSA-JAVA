import java.util.ArrayList;
import java.util.List;

public class A1PascalRowPrint {
    
    public List<Integer> getRow(int rowIndex) {
        int rowSize = rowIndex + 1;  
        List<Integer> row = new ArrayList<>();
        row.add(1);  
        long currentValue = 1;  //Integer may be overflow 
        for (int c = 1; c < rowSize; c++) {
            currentValue = currentValue * (rowSize - c);  
            currentValue = currentValue / c;         
            row.add((int)currentValue);
        }
        return row;
    } 
    public static void main(String[] args) {
        
    }
}


