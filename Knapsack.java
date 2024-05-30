import java.util.Scanner;

class Knapsack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number of items: ");
        int numItems = scanner.nextInt();

        int[] weights = new int[numItems];
        int[] values = new int[numItems];

        System.out.println("Enter the weights and values of the items:");
        for (int i = 0; i < numItems; i++) {
            System.out.print("Weight " + (i + 1) + ": ");
            weights[i] = scanner.nextInt();
            System.out.print("Value " + (i + 1) + ": ");
            values[i] = scanner.nextInt();
        }

        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = scanner.nextInt();

        int[][] dp = new int[numItems + 1][capacity + 1];
        boolean[][] selected = new boolean[numItems + 1][capacity + 1];

        for (int i = 1; i <= numItems; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    int incl = values[i - 1] + dp[i - 1][j - weights[i - 1]];
                    int excl = dp[i - 1][j];
                    dp[i][j] = Math.max(incl, excl);
                    selected[i][j] = (incl > excl);
                } else {
                    dp[i][j] = dp[i - 1][j];
                    selected[i][j] = false;
                }
            }
        }

        System.out.println("Dynamic Programming Table:");
        for (int i = 0; i <= numItems; i++) {
            for (int j = 0; j <= capacity; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Items selected for maximum value:");
        for (int i = numItems; i >= 1; i--) {
            if (selected[i][capacity]) {
                System.out.println("Item " + i + " (Weight: " + weights[i - 1] + ", Value: " + values[i - 1] + ")");
                capacity -= weights[i - 1];
            }
        }
    }
}