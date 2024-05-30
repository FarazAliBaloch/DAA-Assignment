class CoinChanging {
    private static final int[] denominations = {1, 5, 10, 25, 50, 100, 500, 1000, 5000};

    public static void main(String[] args) {
        int amount = 1988;
        int[] counts = new int[denominations.length];

        for (int i = denominations.length - 1; i >= 0 && amount > 0; i--) {
            if (amount >= denominations[i]) {
                int count = amount / denominations[i];
                counts[i] = count;
                amount -= count * denominations[i];
            }
        }

        System.out.println("Required denominations for Rs. " + amount + " are:");
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                System.out.println(denominations[i] + " x " + counts[i]);
            }
        }
    }
}

