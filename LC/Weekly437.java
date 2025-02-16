import java.util.Arrays;

class Weekly437 {
    public long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);
        int n = pizzas.length, days = n / 4;
        long totalWeight = 0;
        int index = n - 1;

        // Pick heaviest pizza on odd days
        for (int day = 1; day <= days; day += 2) {
            totalWeight += pizzas[index--];
        }

        // Pick second heaviest pizza on even days
        index--;
        System.out.println(index);
        for (int day = 2; day <= days; day += 2) {
            totalWeight += pizzas[index];
            index -= 2;
        }
        return totalWeight;
    }

    public static void main(String[] args) {
        Weekly437 obj = new Weekly437();
        int[] pizzas = {1,2,3,4,5,6,7,8};
        long result = obj.maxWeight(pizzas);
        System.out.println("Maximum Weight: " + result);
    }
}
