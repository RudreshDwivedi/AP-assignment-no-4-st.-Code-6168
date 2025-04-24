import java.util.Scanner;

public class Main java {

    // Interpolation Search method
    public static int interpolationSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high && target >= arr[low] && target <= arr[high]) {
            // Avoid division by zero
            if (arr[low] == arr[high]) {
                if (arr[low] == target) return low;
                else return -1;
            }

            // Estimate the position of the target
            int pos = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low]);

            // Check if found
            if (arr[pos] == target)
                return pos;

            // If target is larger, target is in upper part
            if (arr[pos] < target)
                low = pos + 1;
            else // If target is smaller, target is in lower part
                high = pos - 1;
        }

        return -1; // Target not found
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // Input sorted array elements
        System.out.println("Enter " + n + " sorted elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Input the target value to search
        System.out.print("Enter the element to search: ");
        int target = scanner.nextInt();

        // Perform interpolation search
        int result = interpolationSearch(arr, target);

        // Output the result
        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found in the array.");

        scanner.close();
    }
}
