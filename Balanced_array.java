import java.util.Scanner;

public class BalancedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the size of the array
        int n = scanner.nextInt();
        
        // Initialize the array and read its elements
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        
        // Call the method to count balanced splits
        int result = countBalancedSplits(a, n);
        
        // Print the result
        System.out.println(result);
        
        scanner.close();
    }

    private static int countBalancedSplits(int[] a, int n) {
        int totalCount = 0;

        // Iterate through possible split points
        for (int i = 1; i < n; i++) {
            // Calculate sum of the first part
            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += a[j];
            }

            // Calculate sum of the second part
            int rightSum = 0;
            for (int j = i; j < n; j++) {
                rightSum += a[j];
            }

            // Check if the two parts are balanced
            if (leftSum == rightSum) {
                totalCount++;
            }
        }
        
        return totalCount;
    }
}
