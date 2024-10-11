import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DistinctPairsSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the size of the array
        int n = scanner.nextInt();
        // Read the target sum k
        int k = scanner.nextInt();
        
        // Initialize the array and read its elements
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        
        // Call the method to count distinct pairs
        int result = countDistinctPairs(a, n, k);
        
        // Print the result
        System.out.println(result);
        
        scanner.close();
    }

    private static int countDistinctPairs(int[] a, int n, int k) {
        // HashMap to store frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int pairCount = 0;

        // Count the frequency of each number in the array
        for (int num : a) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Iterate through the frequency map
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int complement = k - num; // The number needed to form a pair with num
            
            // Check if the complement exists in the map
            if (frequencyMap.containsKey(complement)) {
                // If num and complement are the same, we can form pairs within them
                if (num == complement) {
                    // Choose 2 out of frequency[num]
                    int count = entry.getValue();
                    pairCount += (count * (count - 1)) / 2; // nC2 = n!/(2!(n-2)!)
                } else if (num < complement) { // Ensure each pair is counted only once
                    pairCount += entry.getValue() * frequencyMap.get(complement);
                }
            }
        }
        
        return pairCount;
    }
}
