public class CheckPerfectSquareBestCase {
    // Best case method to check if a number is a perfect square
    static boolean checkPerfectSquareBestCase(int number) {
        if (number < 0) return false; // Negative numbers cannot be perfect squares
        int sqrt = (int) Math.sqrt(number); // Calculate integer square root
        return (sqrt * sqrt == number); // Check if the square of sqrt equals the number
    }

    public static void main(String[] args) {
        int number = 16; // Example input
        if (checkPerfectSquareBestCase(number)) {
            System.out.println("Yes, the given number is a perfect square.");
        } else {
            System.out.println("No, the given number is not a perfect square.");
        }
    }
}
