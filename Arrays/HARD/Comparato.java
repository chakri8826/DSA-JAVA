import java.util.*;

class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer num1, Integer num2) {
        return num1 - num2; // Compare integers by their value
    }
}

public class Comparato {
    public static void main(String[] args) {
        // Create a list of integers
        // List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 2);

        Integer numbers[] = {5,3,8,1,2};
        // Print the original list
        System.out.println("Original List: " + Arrays.toString(numbers));

        // Sort the list using MyComparator
       Arrays.sort(numbers, new MyComparator());

        // Print the sorted list
        System.out.println("Sorted List: " +Arrays.toString(numbers));
    }
}

