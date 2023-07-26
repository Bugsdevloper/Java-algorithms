public class LinearSearch {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index if the target element is found
            }
        }
        return -1; // Return -1 if the target element is not found
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int target = 9;
        int result = linearSearch(arr, target);

        if (result != -1) {
            System.out.println("Element " + target + " found at index " + result);
        } else {
            System.out.println("Element " + target + " not found in the array.");
        }
    }
}
